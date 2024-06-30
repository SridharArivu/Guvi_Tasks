import axios from 'axios';

const Axios = axios.create({
  baseURL: 'https://guvi-mini-project-one-10082893234.development.catalystappsail.com/api/v1',
  // baseURL: 'http://localhost:9000/api/v1',

});

export default Axios;
