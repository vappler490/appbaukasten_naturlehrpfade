<template>
  <div>
    <v-dialog
      v-if="this.$store.getters.centerIsSet === true"
      v-model="dialog"
      max-width="290"
      style="z-index:9999;"
    >
      <v-card>
        <v-card-title class="headline">Name des POI</v-card-title>
        <v-card-text v-model="poiName"
          >Bitte geben Sie hier den Namen des POI ein.</v-card-text
        >
        <v-col>
          <v-text-field
            label="POI Name"
            v-model="poiName"
            required
          ></v-text-field>
        </v-col>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" text @click="dialog = false"
            >Verwerfen</v-btn
          >
          <v-btn
            color="green darken-1"
            text
            @click="(dialog = false), savePoi(poiName)"
            >Speichern</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog v-else v-model="dialog" max-width="290" style="z-index:9999;">
      <v-card>
        <v-card-title class="headline">Zentrum</v-card-title>
        <v-card-text>Center + Zoom setzen?</v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" text @click="dialog = false"
            >Verwerfen</v-btn
          >
          <v-btn
            color="green darken-1"
            text
            @click="(dialog = false), saveCenterZoom($event)"
            >Speichern</v-btn
          >
        </v-card-actions>
      </v-card>
    </v-dialog>
    <div>
      <l-map
              style="z-index:0; height: 61vh; width: 61vh"
        :zoom="this.$store.getters.zoom"
        :center="center"
        @click="setLatLng($event), setCenterZoom($event), (dialog = true)"
      >
        <l-tile-layer :url="url"></l-tile-layer>
        <l-marker
          v-for="item in this.$store.getters.pois"
          :key="item.poiId"
          :lat-lng="item.latLng"
        >
          <l-popup :content="item.name"></l-popup>
        </l-marker>
      </l-map>
    </div>
  </div>
</template>

<script>
import L from "leaflet";
import { LMap, LTileLayer, LMarker, LPopup } from "vue2-leaflet";

export default {
  name: "LeafMap",
  components: {
    LMap,
    LTileLayer,
    LMarker,
    LPopup
  },
  data() {
    return {
      dialog: false,
      latNLng: [],
      url: "http://{s}.tile.osm.org/{z}/{x}/{y}.png",
      center: L.latLng(this.$store.getters.center),
      bounds: null,
      poiName: ""
    };
  },
  methods: {
    removeMarker(index) {
      this.markers.splice(index, 1);
    },
    setLatLng(event) {
      this.latNLng = event.latlng;
    },
    setCenterZoom(event) {
      this.$store.commit("changeCenter", event.latlng)
      this.$store.commit("changeZoom", event.target._zoom)
    },
    saveCenterZoom(){

    },
    savePoi(poiName) {
      let poi = {
        poiId: this.$store.getters.pois.length + 1,
        name: poiName,
        latLng: L.latLng(this.latNLng.lat, this.latNLng.lng),
        project: this.$store.getters.currentProject.name,
        author: this.$store.getters.author,
        htmlData: this.$store.getters.htmlData,
        poiIsStored: false
      };
      this.$store.commit("addPoi", poi);
      this.$store.commit("changePoiIsStored", false);
    }
  }
};
</script>

<style scoped></style>
