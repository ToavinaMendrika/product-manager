import {createRouter, createWebHistory} from "vue-router";
import Home from "./components/screens/Home.vue";
import Product from "./components/screens/Product.vue";
import {isAuthenticate} from "./helper/auth";

const routes = [
    {path: '/', component: Home, name: 'home'},
    {path: '/product', component: Product, name: 'product'}
]



const router = createRouter({
    history: createWebHistory(),
    routes
});

router.beforeEach( async (to, from, next) => {
    if (isAuthenticate() && to.name === 'home') {
        next({name: 'product'});
    }
    if (!isAuthenticate() && to.name !== 'home') {
        next({name: 'home'});
    } else next();
})

export {router}




