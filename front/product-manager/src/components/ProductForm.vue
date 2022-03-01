<script setup>
import {onMounted, ref} from "vue";
import Input from './ui/Input.vue'
import Button from './ui/Button.vue'
import {api, BadRequestError} from "../helper/api";
import Alert from "./ui/Alert.vue";
import {useFetch} from "../composition/fetcher";
import {config} from "../config";

const  props = defineProps({
  source: {
    default: ''
  },
  type: String
})

const product = ref({
  name: '',
  price: 0,
  description: ''
});
const submitText = props.type === 'add' ? 'Add product' : 'Edit product';
const error = ref('');
const success = ref(false);
const {data: productEdit, loading, err, fetchData: fetchProduct} = useFetch(props.source);
onMounted(async () => {
  await fetchProduct();
  product.value = productEdit.value;
});

async function handleSubmit(e) {
  e.preventDefault();
  const method = props.type === 'add' ? 'POST' : 'PUT';
  try {
    const response = await api(props.source, method, {
      name: product.value.name,
      price: product.value.price,
      description: product.value.description
    });
    if (props.type === 'add') {

      product.value.name = '';
      product.value.price = 0;
      product.value.description = '';
    }
    success.value = true;

  } catch (e) {
    if (e instanceof BadRequestError) {
      error.value = 'Name and descriptions field must be not null';
    }
  }

}

function hideNotification () {
  success.value = false;
  error.value = '';
}
</script>
<template>
  <form :action="source" method="post" class="box">
    <h1 class="title has-text-centered">{{ submitText }}</h1>

    <Alert type="is-success" :is-active="success" @show="hideNotification" v-if="type === 'add'">Product added successfully</Alert>
    <Alert type="is-success" :is-active="success" @show="hideNotification" v-if="type === 'edit'">Product edited successfully</Alert>
    <Alert type="is-danger" :is-active="error !== ''"  @show="hideNotification">{{ error }}</Alert>

    <Input id="name" type="text" label="Name" placeholder="Your product name" :required="true" :value="product.name" v-model="product.name"/>
    <Input id="price" type="number" label="Price" placeholder="product price" :required="true" :value="product.price" v-model="product.price"/>
    <Input id="description" type="textarea" label="Description" placeholder="Product description"  :required="false" :value="product.description" v-model="product.description"/>
    <Button type="submit" :is-field="true" color="is-success" :is-full-width="true" @click="handleSubmit">{{ submitText }}</Button>
  </form>
</template>
