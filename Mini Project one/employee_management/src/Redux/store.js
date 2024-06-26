import { configureStore } from '@reduxjs/toolkit'

import AddEmployeeForm from './Slices/AddEmployeeForm';

export const store = configureStore({
  reducer: {
    AddEmployeeForm,
  },
});