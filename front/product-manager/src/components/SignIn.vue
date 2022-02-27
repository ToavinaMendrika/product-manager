<script setup>
import Input from './ui/Input.vue'
import Button from  './ui/Button.vue'
import Alert from "./ui/Alert.vue";
import {ref} from "vue";
import {api, UnauthorizedError} from "../helper/api";
import {config} from "../config";
import {router} from "../router";


const username = ref("admin");
const password = ref("admin");
const showAuthError = ref(false);


async function handleSubmit(e) {
  e.preventDefault();
  try {
    const postResponse = await api(config.urls.signIn, 'POST', {username: username.value, password: password.value});
    await window.localStorage.setItem('auth-tok', postResponse.jwt);
    await router.push({name: 'product'});
  } catch (e) {
    if (e instanceof UnauthorizedError) {
      showAuthError.value = true;
    }
  }

}

function hideNotification () {
  showAuthError.value = false;
}
</script>

<template>
  <form action="/login" class="box">
    <h1 class="title has-text-centered">Sign in</h1>
    <Alert type="is-danger" background="is-light" :is-active="showAuthError" @show="hideNotification">
      Sorry, your username or password was incorrect.
    </Alert>
    <Input id="email" type="text" label="Username" placeholder="Your username" :required="true" :value="username" v-model="username"/>
    <Input id="password" type="password" label="Password" placeholder="*********" :required="true" :value="password" v-model="password"/>
    <Button type="submit" :is-field="true" color="is-success" :is-full-width="true" @click="handleSubmit">Login</Button>
  </form>
</template>

<style scoped>
.title {
  color: #363636 !important;
}
</style>