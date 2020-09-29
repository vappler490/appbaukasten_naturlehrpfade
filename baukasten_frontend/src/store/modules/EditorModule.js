const editorModule = {
  state: { htmlData: "" },
  mutations: {
    changeHtmlData(state, htmlData) {
      state.htmlData = htmlData;
    }
  },
  actions: {},
  getters: { htmlData: state => state.htmlData }
};
export default editorModule;
