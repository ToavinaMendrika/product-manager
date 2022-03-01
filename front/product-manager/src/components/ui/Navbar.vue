<template>
  <nav class="navbar is-primary">
    <div class="container">
      <div class="navbar-brand">
        <a class="navbar-item" href="#">
          <img src="https://bulma.io/images/bulma-logo.png" alt="Bulma: a modern CSS framework based on Flexbox" width="112" height="28">
        </a>
        <div class="navbar-burger" data-target="navbarExampleTransparentExample">
          <span></span>
          <span></span>
          <span></span>
        </div>
      </div>

      <div id="navbarExampleTransparentExample" class="navbar-menu">
        <div class="navbar-start">
          <router-link class="navbar-item" :to="{name: 'product'}">
            Product
          </router-link>
        </div>

        <div class="navbar-end">
          <div class="navbar-item has-dropdown is-hoverable">
            <a class="navbar-link" href="#">
              Admin
            </a>
            <div class="navbar-dropdown is-boxed">
              <a class="navbar-item" href="#">
                Profil
              </a>
              <a class="navbar-item" href="#" @click="logout">
                Logout
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script setup>
import {router} from "../../router";

function logout() {
  window.localStorage.removeItem('auth-tok');
  router.push({name: 'home'});
}
</script>
