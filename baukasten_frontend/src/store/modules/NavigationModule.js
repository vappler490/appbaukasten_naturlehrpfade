const navigationModule = {
  state: {
    headlineRoutes: [
      { headline: "Home", route: "/" },
      { headline: "Projekt", route: "/project" },
    ],
    currentHeadline: "Naturlehrpfad Website",
    currentOption: ""
  },
  mutations: {
    changeCurrentHeadline(state, currentHeadline) {
      state.currentHeadline = currentHeadline;
    },
    changeCurrentOption(state, option) {
      state.currentOption = option;
    }
  },
  actions: {},
  getters: {
    currentHeadline: state => state.currentHeadline,
    headlineRoutes: state => state.headlineRoutes,
    currentOption: state => state.currentOption
  }
};

export default navigationModule;
