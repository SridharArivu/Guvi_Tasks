import Axios from '../api/Axios';

const FormSubmission = async (empDetails,url) => {
    const isStateEmpty = (state) => {
        return Object.values(state).every(value => {
          return !(value === "" || value === 0 || value === undefined || value === null || (typeof value === 'number' && isNaN(value)));
        });
      };

    if (!isStateEmpty(empDetails)) {
        return false;
    }

    const formData = new FormData();
    formData.append('image',empDetails.file);
    formData.append('employee', new Blob([JSON.stringify(empDetails)], { type: 'application/json' }));

    try {
      const response = await Axios.post('/save-emp-details', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      
      if (response.status === 200) {
        console.log('POST request successful:', response.data);
        return true;
      } else {
        console.error('Error: Unexpected response status:', response.status);
        return false;
      }
    } catch (error) {
      console.error('Error making POST request:', error);
      return false;
    }

}

export default FormSubmission