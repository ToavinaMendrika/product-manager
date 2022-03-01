<script setup>
import Navbar from "../ui/Navbar.vue";
import ProductForm from "../ProductForm.vue";
import {config} from "../../config";
import ProductList from "../ProductList.vue";
const postUrl = config.urls.addProduct;
</script>
<template>
  <Navbar/>
  <div class="container mt-5">
    <router-link :to="{name: 'product_add'}" class="button is-primary mb-4">Add product</router-link>
    <ProductList />
  </div>
</template>
