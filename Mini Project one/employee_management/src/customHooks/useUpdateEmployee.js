// useFetchEmployee.js

import { useDispatch } from 'react-redux';
import Axios from '../api/Axios';
import { setEmployeeDetails } from '../Redux/Slices/AddEmployeeForm';


const useUpdateEmployee = () => {
    const dispatch = useDispatch();

    const getUserById = async (id) => {
        try {
            const response = await Axios.get(`/emp-by-id/${id}`, { headers: { "content-type": "application/json" } });
            return response;
        } catch (error) {
            return error;
        }
    }

    const updateFormState = async (id) => {
        try {
            const response = await getUserById(id);
            const { data } = response;
    
            Object.keys(data).forEach(key => {
                // const { name, value, files } = data[key];
                // console.log(key);
                if (key == "image") {
                    dispatch(setEmployeeDetails({ key: "file", value: data[key] }));
                } else {
                    dispatch(setEmployeeDetails({ key: key, value: data[key] }));
                }
            });
            return true;
        } catch (error) {
            console.error('Error updating form state:', error);
            return false;
        }
    }

    
    const submitUpdatedForm = async (empDetails) => {
        const body = {
            employeeID: empDetails.employeeID,
            firstName: empDetails.firstName,
            lastName: empDetails.lastName,
            role: empDetails.role,
            gender: empDetails.gender,
            email: empDetails.email,
            image: empDetails.file,
            phone: empDetails.phone,
            streetAddress: empDetails.streetAddress,
            city: empDetails.city,
            state: empDetails.state,
            country: empDetails.country,
            pincode: empDetails.pincode,
        };
    
        try {
            const response = await Axios.put(`update-emp/${empDetails.employeeID}`, body, {
                headers: { "Content-Type": "application/json" },
            });
            return true;
        } catch (error) {
            return false;
        }
    };
    
    return { getUserById, updateFormState,submitUpdatedForm };
}

export default useUpdateEmployee;
