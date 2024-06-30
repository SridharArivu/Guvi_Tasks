import { configureStore } from '@reduxjs/toolkit'
import authReducer from "./Slices/authSlice";
import doctorProfileReducer from "./Slices/doctorProfileSlice"
import findDoctorSlice from "./Slices/findDoctorSlice"

export const store = configureStore({
  reducer: {
    auth :authReducer ,
    doctorProfile:doctorProfileReducer,
    findDoctor:findDoctorSlice,
  },
});