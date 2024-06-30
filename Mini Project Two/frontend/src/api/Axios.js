import axios from 'axios';

const Axios = axios.create({
//   baseURL: 'https://guvi-mini-project-one-10082893234.development.catalystappsail.com/api/v1',
  baseURL: 'http://localhost:8080/api/v1',

});

Axios.interceptors.request.use(
    (config) => {
      const token = localStorage.getItem('token');
      if (token) {
        config.headers.Authorization = `Bearer ${token}`;
      }
      return config;
    },
    (error) => {
      return Promise.reject(error);
    }
  );

export default Axios;
