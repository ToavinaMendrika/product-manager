<script setup>
import {useFetch} from "../composition/fetcher";
import {onMounted} from "vue";
import {config} from "../config";
import ProductBtnAction from "./ProductBtnAction.vue";

const {data: products, loading, error, fetchData: fetchProducts} = useFetch(config.urls.getProducts);

onMounted(() => {
  fetchProducts();
})
function onProductDelete(product) {
  products.value = products.value.filter((value, i, arr) => value.id !== product.id);
}
</script>
<template>
  <div class="product-list">
    <table class="table is-fullwidth">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Price</th>
          <th>Description</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" v-if="products && products.length > 0">
          <td>{{ product.id }}</td>
          <td>{{ product.name }}</td>
          <td>{{ product.price }}</td>
          <td>{{ product.description }}</td>
          <td><ProductBtnAction :id="product.id" @delete="onProductDelete"/></td>
        </tr>
        <tr v-else>
          <td colspan="5" class="has-text-centered">No data</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
