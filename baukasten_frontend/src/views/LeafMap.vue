<template>
  <LeafMap :key="this.$store.getters.currentProject.center.lat"></LeafMap>
</template>

<script>
import LeafMap from "../components/LeafMap";

export default {
  name: "leafMap",
  components: {
    LeafMap
  }
};
</script>

<style scoped></style>
