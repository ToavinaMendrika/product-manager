<script setup>
const props = defineProps({
  type: String,
  isField: Boolean,
  color: String,
  isFullWidth: Boolean
});
const emit = defineEmits(['click']);

function handleClick(e) {
  emit('click', e);
}

</script>
<template>
  <div class="field" v-if="isField">
    <button @click="handleClick" :class="'button ' +  color   + [isFullWidth ? ' is-fullwidth': '']" >
      Login
    </button>
  </div>
  <button @click="handleClick" :class="'button ' +  color   + [isFullWidth ? ' is-fullwidth': '']" v-else>
    <slot />
  </button>
</template>


