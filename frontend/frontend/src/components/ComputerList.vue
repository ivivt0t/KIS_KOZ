<template>
  <div>
    <h2>Список компьютеров</h2>
    <ul>
      <li v-for="computer in computers" :key="computer.id">
        {{ computer.brand }} {{ computer.model }} ({{ computer.processor }}),
        RAM: {{ computer.ram }} ГБ, Диск: {{ computer.storage }} ГБ,
        Доступен: {{ computer.is_available ? 'Да' : 'Нет' }}
        <button @click="$emit('edit', computer)">Редактировать</button>
        <button @click="deleteComputer(computer.id)">Удалить</button>
      </li>
    </ul>
  </div>
</template>

<script>
import computerService from '@/services/computerService';

export default {
  data() {
    return {
      computers: [],
    };
  },
  methods: {
    async fetchComputers() {
      // Предполагаем, что у нас есть .data в ответе
      this.computers = (await computerService.getComputers()).data;
    },
    async deleteComputer(id) {
      await computerService.deleteComputer(id);
      this.fetchComputers();
    },
  },
  mounted() {
    this.fetchComputers();
  },
};
</script>
