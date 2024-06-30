import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  doctors: [],
  selectedDoctor: localStorage.getItem("selectedDoctor") || {},
};

const findDoctorSlice = createSlice({
  name: 'findDoctor',
  initialState,
  reducers: {
    setAllDoctors: (state, action) => {
      state.doctors = action.payload;
    },
    setDoctorField: (state, action) => {
      const { index, field, value } = action.payload;
      state.doctors[index][field] = value;
    },
    setSelectedDoctor: (state, action) => {
      state.selectedDoctor = action.payload;
    },
  },
});

export const { setAllDoctors, setDoctorField, setSelectedDoctor } = findDoctorSlice.actions;

export default findDoctorSlice.reducer;
