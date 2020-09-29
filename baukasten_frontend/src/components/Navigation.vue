<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <div id="nav">
    <v-app id="inspire">
      <div>
          <v-toolbar>
            <v-toolbar-title :key="$store.getters.currentHeadline">{{
              $store.getters.currentHeadline
            }}</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-toolbar-items
              v-for="item in $store.getters.headlineRoutes"
              :key="item.route"
            >
              <v-btn
                v-if="!item.options"
                text
                @click="setCurrentHeadline(item.headline)"
              >
                <router-link :to="item.route">{{ item.headline }} </router-link>
              </v-btn>
              <v-menu v-else offset-y>
                <template v-slot:activator="{ on }">
                  <v-btn v-on="on">{{ item.headline }}</v-btn>
                </template>
                <v-list v-for="option in item.options" :key="option.optionName">
                  <v-list-item>
                    <v-list-item-title v-on:click="setOption(option.optionName)"
                      ><router-link :to="item.route"
                        >{{ option.optionName }}
                      </router-link>
                    </v-list-item-title>
                  </v-list-item>
                </v-list>
              </v-menu>
            </v-toolbar-items>
            <v-btn v-if="activeUser" v-on:click="login">Login</v-btn>
            <v-btn v-else >Logout</v-btn>
          </v-toolbar>
      </div>
      <router-view />
    </v-app>
  </div>
</template>

<script>
export default {
  name: "Navigation",
  data() {
    return {
      activeUser: null
    };
  },
  beforeCreate() {},
  methods: {
    setCurrentHeadline(headline) {
      this.$store.commit("changeCurrentHeadline", headline);
    },
    setOption(option) {
      this.$store.commit("changeCurrentOption", option);
    }
  }
};
</script>

<style scoped></style>
