const poiModule = {
  state: {
    poiIsSelected: false,
    poiIsStored: true,
    name: "",
    poiId: "",
    author: "",
    poi: {},
    pois: []
  },
  mutations: {
    changeName(state, name) {
      state.name = name;
    },
    changeId(state, poiId) {
      state.poiId = poiId;
    },
    changeAuthor(state, author) {
      state.author = author;
    },
    changePoi(state, poi) {
      state.poi = poi;
    },
    addPoi(state, poi) {
      state.pois.push(poi);
    },
    getPois(state, pois) {
      state.pois = pois;
    },
    updatePoi(state, htmlData) {
      state.poi.htmlData = htmlData;
    },
    changePoiIsStored(state, isStored) {
      state.poiIsStored = isStored;
    },
    changePoiIsSelected(state, isSelected) {
      state.poiIsSelected = isSelected;
    }
  },
  actions: {},
  getters: {
    name: state => state.name,
    poiId: state => state.poiId,
    author: state => state.author,
    poi: state => state.poi,
    pois: state => state.pois,
    poiIsStored: state => state.poiIsStored,
    poiIsSelected: state => state.poiIsSelected
  }
};

export default poiModule;
