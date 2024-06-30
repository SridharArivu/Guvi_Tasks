import { createSlice } from "@reduxjs/toolkit";
const initialState = {
employeeID : "",
firstName : "",
lastName : "",
email: "",
phone:undefined,
file :undefined,
role:"UI/UX Designer",
gender : "Male",
streetAddress : "",
city : "",
state : "",
country:"",
pincode :undefined,
}
export const AddEmployeeForm =  createSlice({
    name:"AddEmployeeForm",
    initialState,
    reducers : {

        setEmployeeDetails: (state, action) => {
            const { key, value } = action.payload;
            return { ...state, [key]: value }; 
        },
        resetEmployeeDetailsState : () => initialState,
    }
})

export const {setEmployeeDetails, resetEmployeeDetailsState} = AddEmployeeForm.actions

export default AddEmployeeForm.reducer;