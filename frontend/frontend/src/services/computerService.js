import axios from 'axios';

const API_URL = 'http://localhost:8081/computers';

export default {
    getComputers() {
        return axios.get(API_URL);
    },
    addComputer(computer) {
        return axios.post(API_URL, computer);
    },
    updateComputer(computer) {
        return axios.put(API_URL, computer);
    },
    deleteComputer(id) {
        return axios.delete(`${API_URL}/${id}`);
    },
};
