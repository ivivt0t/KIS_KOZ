import { createApp } from 'vue';
import App from './App.vue';
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8081'; // Убедитесь, что адрес соответствует вашему бэкенду
createApp(App).mount('#app');
