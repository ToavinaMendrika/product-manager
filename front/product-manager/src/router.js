import {createRouter, createWebHistory} from "vue-router";
import Home from "./components/screens/Home.vue";
import Product from "./components/screens/Product.vue";
import ProductEdit from "./components/screens/ProductEdit.vue";
import ProductShow from "./components/screens/ProductShow.vue";
import ProductAdd from "./components/screens/ProductAdd.vue";
import {isAuthenticate} from "./helper/auth";

const routes = [
    {path: '/', component: Home, name: 'home'},
    {path: '/product', component: Product, name: 'product'},
    {path: '/product/add', component: ProductAdd, name: 'product_add'},
    {path: '/product/:id/edit', component: ProductEdit, name: 'product_edit'},
    {path: '/product/:id/show', component: ProductShow, name: 'product_show'}
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




