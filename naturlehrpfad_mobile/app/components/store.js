import Vue from 'nativescript-vue';
import Vuex from 'vuex';
Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        htmlData:'',
        projectName: '',
        projectCenter: [],
        pois: []
    },

    mutations: {
        changeHtmlData(state, htmlData) {
            state.htmlData = htmlData
            console.log("STORE")
        },
        changeProjectName(state, projectName) {
            state.projectName = projectName;
        },
        changePois(state, pois) {
            state.pois = pois;
        },
        changeCenter(state, projectCenter) {
            state.projectCenter = projectCenter;
        }
    },

    getters: {
        htmlData: state => state.htmlData,
        getProjectName: state => state.projectName,
        pois: state => state.pois,
        projectCenter: state => state.projectCenter
    }
})

export default store;
