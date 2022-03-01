<script setup>

const props = defineProps({
  label: String,
  type: String,
  placeholder: String,
  required: Boolean,
  fa: Boolean,
  id: String,
  value: String
});

const emit = defineEmits(['update:modelValue']);

function updateValue(event) {
  emit('update:modelValue', event.target.value);
}

</script>

<template>
  <div class="field" v-if="type !== 'textarea'">
    <label :for="id" class="label">{{ label }}</label>
    <div :class="[fa ? 'control has-icons-left': 'control']">

      <input :id="id" :type="type" :placeholder="placeholder" class="input" :value="value" :required="required" @input="updateValue">

      <span class="icon is-small is-left" v-if="fa">
        <i class="fa fa-envelope"></i>
      </span>
    </div>

  </div>
  <div class="field" v-else>
    <label :for="id" class="label">{{ label }}</label>
    <textarea  :id="id" @input="updateValue" class="textarea" :placeholder="placeholder">{{ value }}</textarea>
  </div>
</template>
