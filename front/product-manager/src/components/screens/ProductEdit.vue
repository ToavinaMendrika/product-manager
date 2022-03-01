<script setup>
import ProductForm from "../ProductForm.vue";
import Navbar from "../ui/Navbar.vue";
import {config} from "../../config";
import {useRoute} from "vue-router";

const route = useRoute();
const source = config.urls.getProducts + '/' + route.params.id;
</script>
<template>
  <Navbar/>
  <div class="container">
    <ProductForm type="edit" :source="source"/>
  </div>
</template>