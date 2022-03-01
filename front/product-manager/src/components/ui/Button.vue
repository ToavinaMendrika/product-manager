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
    <button :type="type" @click="handleClick" :class="'button ' +  color   + [isFullWidth ? ' is-fullwidth': '']" >
      <slot />
    </button>
  </div>
  <button :type="type" @click="handleClick" :class="'button ' +  color   + [isFullWidth ? ' is-fullwidth': '']" v-else>
    <slot />
  </button>
</template>


