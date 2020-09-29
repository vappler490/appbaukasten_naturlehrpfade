import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Editor from "../views/Editor";
import Project from "../views/Project";
import LeafMap from "../views/LeafMap";
//import Auth from "@okta/okta-vue";

/*Vue.use(Auth, {
  issuer: "https://dev-329317.okta.com/oauth2/default",
  clientId: "0oa2bixny9BgLYLIg357",
  redirectUri: "http://localhost:8080/implicit/callback",
  scopes: ["openid", "profile", "email"],
  pkce: true
});*/

Vue.use(VueRouter)

const routes = [
/*  { path: "/implicit/callback",
    component: Auth.handleCallback() },*/
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/map",
    name: "map",
    component: LeafMap
  },
  {
    path: "/project",
    name: "project",
    component: Project,
/*    meta: {
      requiresAuth: true
    }*/
  },
  {
    path: "/editor",
    name: "editor",
    component: Editor
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  //base: process.env.BASE_URL,
  routes
});

//router.beforeEach(Vue.prototype.$auth.authRedirectGuard());

export default router;
