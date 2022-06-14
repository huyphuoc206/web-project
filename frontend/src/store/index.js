import Vue from "vue";
import Vuex from "vuex";
import global from "./global";
import songs from "./songs";
import auth from "./auth";
import category from "./category";
import podcast from "./podcast";
import artists from "./artists";
import user from "./user";
Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        auth,
        global,
        songs,
        category,
        podcast,
        artists,
        user,
    },
});