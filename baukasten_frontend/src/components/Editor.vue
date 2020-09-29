<template id="editor">
  <div>
    <wysiwyg v-model="htmlData" />
  </div>
</template>

<script>
import { bus } from '../main'

export default {
  name: "editor",
  data() {
    return {
      htmlData: this.$store.getters.poi.htmlData};
  },
  components: {
  },
  created() {
    bus.$on('preview',() => {
      this.saveData();
    })

  },
  methods: {
    saveData() {
      this.$store.commit(
        "updatePoi",
        this.htmlData
      ),
      this.$store.commit(
        "changeHtmlData",
        this.htmlData
      );
    }
  }
};
</script>
