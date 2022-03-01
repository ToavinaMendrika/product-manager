<script setup>
import {api} from "../helper/api";
import {config} from "../config";

const props = defineProps({
  id: Number
})
const emit = defineEmits(['delete']);

async function handleDelete(e) {
  e.preventDefault();
  const url = config.urls.getProducts + '/' + props.id;
  confirm('Are you sur to delete this item?');
  try {
    const response = await api(url, 'DELETE');
    emit('delete', response);
  } catch (e) {
    alert('Server not respond to your request');
  }


}

</script>
<template>
  <div class="field has-addons">
    <p class="control">
      <router-link :to="{name: 'product_show', params: {id} }" class="button">
        <span>Show</span>
      </router-link>
    </p>
    <p class="control">
      <router-link :to="{name: 'product_edit', params: {id} }" class="button">
        <span>Edit</span>
      </router-link>
    </p>
    <p class="control">
      <button :to="toEdit" class="button" @click="handleDelete">
        <span>delete</span>
      </button>
    </p>
  </div>
</template>
