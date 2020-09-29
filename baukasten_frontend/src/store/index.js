import Vue from "vue";
import Vuex from "vuex";
import navigationModule from "./modules/NavigationModule";
import mapModule from "./modules/MapModule";
import poiModule from "./modules/PoiModule";
import projectModule from "./modules/ProjectModule";
import editorModule from "./modules/EditorModule";
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    navigationModule,
    poiModule,
    projectModule,
    mapModule,
    editorModule
  }
});
