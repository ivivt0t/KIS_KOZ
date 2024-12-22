<template>
  <div>
    <h2>Добавить/Обновить компьютер</h2>
    <form @submit.prevent="submitComputer">
      <input
          v-model="computer.brand"
          placeholder="Бренд компьютера"
          required
      />
      <input
          v-model="computer.model"
          placeholder="Модель"
          required
      />
      <input
          v-model="computer.processor"
          placeholder="Процессор"
          required
      />
      <input
          v-model.number="computer.ram"
          type="number"
          placeholder="RAM (ГБ)"
          required
      />
      <input
          v-model.number="computer.storage"
          type="number"
          placeholder="Объём диска (ГБ)"
          required
      />
      <label>
        Доступен:
        <input
            type="checkbox"
            v-model="computer.is_available"
            @change="updateIsAvailable"
        />
      </label>
      <button type="submit">Сохранить</button>
    </form>
  </div>
</template>

<script>
import computerService from '@/services/computerService';

export default {
  data() {
    return {
      computer: {
        id: null,
        brand: '',
        model: '',
        processor: '',
        ram: 0,
        storage: 0,
        is_available: false,
      },
    };
  },
  methods: {
    updateIsAvailable(event) {
      this.computer.is_available = event.target.checked || false;
    },
    async submitComputer() {
      // Переводим is_available в Boolean, чтобы убедиться в правильном типе.
      this.computer.is_available = !!this.computer.is_available;
      if (this.computer.id) {
        await computerService.updateComputer(this.computer);
      } else {
        await computerService.addComputer(this.computer);
      }
      this.clearForm();
      this.$emit('refresh');
    },
    clearForm() {
      this.computer = {
        id: null,
        brand: '',
        model: '',
        processor: '',
        ram: 0,
        storage: 0,
        is_available: false,
      };
    },
    editComputer(computer) {
      this.computer = { ...computer };
    },
  },
};
</script>
