<script setup>
import ProductForm from "../ProductForm.vue";
import Navbar from "../ui/Navbar.vue";
import {config} from "../../config";
const source = config.urls.addProduct;
</script>
<template>
  <Navbar/>
  <div class="container">
    <ProductForm type="add" :source="source"/>
  </div>
</template>