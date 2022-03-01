<script setup>
import {useFetch} from "../../composition/fetcher";
import Navbar from "../ui/Navbar.vue";
import {config} from "../../config";
import {useRoute} from "vue-router";
import {onMounted} from "vue";
const route = useRoute();
const source = config.urls.getProducts + '/' + route.params.id;

const {data: product, loading, err, fetchData: fetchProduct} = useFetch(source);
onMounted(() => fetchProduct());

</script>
<template>
  <Navbar/>
  <div class="container">
    <div class="box">
      <h1 class="title">{{ product.name }}</h1>
      <p>Price: <strong>{{ product.price }}</strong></p>
      <p>{{ product.description }}</p>
    </div>
  </div>

</template>
