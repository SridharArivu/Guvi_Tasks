import axios from 'axios';

const Axios = axios.create({
   baseURL: 'https://guvi-428306.el.r.appspot.com/api/v1',
  // baseURL: 'http://localhost:9000/api/v1',

});

export default Axios;
