<script setup>
import {ref} from "vue";

const props = defineProps({
  type: String,
  background: String,
  isActive: {
    type: Boolean,
    default: false
  }
});

const emit = defineEmits(['show']);

function hideNotification(e) {
  e.preventDefault();
  emit('show', false);
}

</script>

<template>
  <div :class="'notification ' + type + ' ' + background" v-if="isActive">
    <button class="delete" @click="hideNotification"></button>
    <slot/>
  </div>
</template>
