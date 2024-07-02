import React, { useState, useEffect } from 'react'
import "./FindDoctor.css"
import DoctorCard from '../../Components/DoctorCard/DoctorCard'
import BookAppointment from '../../Components/BookAppointment/BookAppointment'
import { useNavigate } from 'react-router-dom'
import Axios from "../../api/Axios"
import {setAllDoctors,setDoctorField} from "../../Redux/Slices/findDoctorSlice"
import { useDispatch, useSelector } from 'react-redux'

const FindDoctor = () => {
    const [bookbuttonClicked,setBookButtonClicked] = useState(false);
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const {doctors} = useSelector(state => state.findDoctor);

    useEffect(() =>{
      findAllDoctors();
    },[])

    const findAllDoctors = async () =>{
      try {
        const response = await Axios.get("/doctor/all", {
          headers: { 'Content-Type': 'application/json' }
        });
        loopSetState(response.data);
        console.log(response.data[0])
       
      } catch (error) {
        if(error.status === 403){
          window.alert("Session Expired Login again")
        } 
        localStorage.removeItem("token");
        localStorage.removeItem("role");
        localStorage.removeItem("user")
        navigate("/login")
      }
    }
    
    const loopSetState = (doctorsList) => {
      dispatch(setAllDoctors(doctorsList));
      doctorsList.forEach((doctor, index) => {
        Object.entries(doctor).forEach(([key, value]) => {
          dispatch(setDoctorField({ index, field: key, value }));
        });
      });
    };
      
   
  return (
   
    <div className='findDoctor_wrapper'>
         {!bookbuttonClicked 
    ?
         <>
            <h4>Find a Doctor</h4>

            <div className='search_doctor_input_wrapper'>
                    <input type="text" name="searchDoctor" id="searchDoctor" placeholder='Search by doctor name' />
                    <button className='search_submit_btn'>Search</button>
            </div>
            <div className='Doctor_list_cards_wrapper'>
              {
                doctors.map((doctor,index) => (
                <DoctorCard
                  doctor={doctor}
                  key={index}
                  setBookButtonClicked={setBookButtonClicked}
                  allign="findDoctor"
                />
                ))
              }
                    
            </div>
        </>
        :
        <BookAppointment
          setBookButtonClicked={setBookButtonClicked}
        />
        }
    </div>

  )
}

export default FindDoctor;