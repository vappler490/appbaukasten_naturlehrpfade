import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store/index";
import vuetify from "./plugins/vuetify";
import "leaflet/dist/leaflet.css";
import { Icon } from "leaflet";
import Keycloak from "keycloak-js";
import wysiwyg from "vue-wysiwyg";
import "vue-wysiwyg/dist/vueWysiwyg.css";

Vue.config.productionTip = false;

delete Icon.Default.prototype._getIconUrl;

Vue.use(wysiwyg, {hideModules: { "code": true },});

Icon.Default.mergeOptions({
  iconRetinaUrl: require("leaflet/dist/images/marker-icon-2x.png"),
  iconUrl: require("leaflet/dist/images/marker-icon.png"),
  shadowUrl: require("leaflet/dist/images/marker-shadow.png")
});
export const bus = new Vue();

let initOptions = {
  url: "http://127.0.0.1:8080/auth",
  realm: "lehrpfad-baukasten",
  clientId: "baukasten-web",
  onLoad: "login-required"
};

let keycloak = Keycloak(initOptions);

keycloak.init({ onLoad: initOptions.onLoad });

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount("#app");

localStorage.setItem("vue-token", keycloak.token);
localStorage.setItem("vue-refresh-token", keycloak.refreshToken);
