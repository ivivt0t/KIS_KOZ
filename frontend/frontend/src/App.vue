<template>
  <div id="app">
    <h1>Управление компьютерами</h1>
    <ComputerForm @refresh="refreshList" ref="form" />
    <ComputerList @edit="editComputer" ref="list" />
  </div>
</template>

<script>
import ComputerForm from '@/components/ComputerForm.vue';
import ComputerList from '@/components/ComputerList.vue';

export default {
  name: 'App',
  components: {
    ComputerForm,
    ComputerList,
  },
  methods: {
    refreshList() {
      this.$refs.list.fetchComputers();
    },
    editComputer(computer) {
      this.$refs.form.editComputer(computer);
    },
  },
};
</script>
