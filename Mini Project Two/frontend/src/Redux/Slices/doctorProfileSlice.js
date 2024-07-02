import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    profile: {
      username: '',
      email: '',
      phone: '',
      gender: '',
      specialization: '',
      fees: '',
      isImageUploaded:false,
      timeSlots: [],
      image: null,
      verified:true,
      role:null,
    },
    specialties: "",
    loading: false,
    error: null
  };


  const doctorProfileSlice = createSlice({
    name: 'doctorProfile',
    initialState,
    reducers: {
      updateProfileField: (state, action) => {
        const { field, value } = action.payload;
        state.profile[field] = value;
      },
      addTimeSlot: (state, action) => {
        
        state.profile.timeSlots.push(action.payload);
      },
      deleteTimeSlot: (state, action) => {
        state.profile.timeSlots.splice(action.payload, 1);
      },
      updateSlotField: (state, action) => {
        const { index, field, value } = action.payload;
        state.profile.timeSlots[index][field] = value;
      },
      setImage: (state, action) => {
          const { image } = action.payload;
          if (!image) {
            state.profile.image = action.payload;
          } else {
            state.profile.image = image;
          }  
      },
      setLoading: (state, action) => {
        state.loading = action.payload;
      },
      setError: (state, action) => {
        const {image} = action.payload
        state.error = image.image;
      },
      clearForm: (state) => {
        state.profile = {
          name: '',
          email: '',
          phone: '',
          gender: '',
          specialization: '',
          fee: '',
          timeSlots: [],
          image: null
        };
        state.loading = false;
        state.error = null;
      }
    }
  });
  
  export const { updateProfileField, addTimeSlot, deleteTimeSlot, updateSlotField, setImage, setLoading, setError, clearForm } = doctorProfileSlice.actions;
  
  export default doctorProfileSlice.reducer;
  