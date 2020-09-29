const mapModule = {
  state: {
    latLng: [],
    center: [52.479738, 13.351705],
    zoom: 7,
    centerIsSet: false
  },
  mutations: {
    changeLatLng(state, latLng) {
      state.latLng = latLng;
    },
    changeZoom(state, zoom) {
      state.zoom = zoom;
    },
    changeCenterIsSet(state, isSet) {
      state.centerIsSet = isSet;
    },
    changeCenter(state, latLng) {
      state.center = [latLng.lat, latLng.lng];
    }
    /*,
    actions: {
      SetCenterAndZoom() {}
    }*/
  },
  getters: {
    latLng: state => state.latLng,
    zoom: state => state.zoom,
    center: state => state.center,
    centerIsSet: state => state.centerIsSet
  }
};

export default mapModule;
