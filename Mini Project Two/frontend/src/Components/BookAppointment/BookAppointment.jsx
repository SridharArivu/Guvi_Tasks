import React, { useEffect, useState } from 'react'
import "./BookAppointment.css"
import DoctorCard from '../DoctorCard/DoctorCard'
import About from './subComponents/about/About'
import FeedBack from './subComponents/feedback/FeedBack'
import { IoArrowBack } from "react-icons/io5";
import { useNavigate } from 'react-router-dom'
import { useSelector } from 'react-redux';
import Axios from '../../api/Axios'

const BookAppointment = ({setBookButtonClicked}) => {
    const [toggleAbout, setToggleAbout] = useState(true);
    const navigate = useNavigate();
    const {selectedDoctor} = useSelector(state => state.findDoctor);
    const {timeSlots} = selectedDoctor;

    const [selectedTimeSlot,setSelectedTimeSlot] = useState("");

    useEffect(()=>{
        const initialTimeSlot = timeSlots[0].day + " " +timeSlots[0].startTime +" - "+ timeSlots[0].endTime
        setSelectedTimeSlot(initialTimeSlot);
    },[])
    
    const handleBookAppoinment = async (selectedDoctor) =>{
        const body = {
            doctorEmail:selectedDoctor.email,
            timeSlots:selectedTimeSlot
        }
        try {
            const response = await Axios.post("/appointment/save",body,{ headers: { 'Content-Type': 'application/json' }})
            if(response.status === 200) navigate("/profile");
        } catch (error) {
            window.alert("Session Expired Login again")
            if(error.status === 403) navigate("/login");
            console.error(error);
        }
    }

  return (
    <div className='BookAppointment_wrapper'>
        <IoArrowBack onClick={() => setBookButtonClicked(false)} className='back_arrow' />
        <div className='Doctor_info_wrapper'>
            
            <DoctorCard allign="book" doctor={selectedDoctor}/>
            <div className='About_and_feedback'>
                <button className='About' 
                    onClick={() => setToggleAbout(true)} 
                    style={toggleAbout ? {borderBottom:"2px solid #8c88ad"} : {borderBottom:"none"}}>
                        About
                </button>
                <button className='feedback' 
                    onClick={() => setToggleAbout(false)} 
                    style={toggleAbout ? {borderBottom:"none"} : {borderBottom:"2px solid #8c88ad"}}>
                        Feeback
                </button>
            </div>
           
            {
                toggleAbout ?
                <About/>
                :
                <FeedBack/>
            }
        </div>
        <div className='book_Appoinment_wrapper'>
             <h3 className='fee'>Appointment Fee <span>{selectedDoctor.fees} INR</span></h3>
             <h3 style={{fontWeight:"500",fontSize:"2.5vh"}}>Available Time Slots:</h3>
             <select className='Available_slots' onChange={(e) => setSelectedTimeSlot(e.target.value)}>
                {timeSlots?.map((item) => (
                    <option>{item.day} {item.startTime} - {item.endTime}</option>
                ))}
                
            </select>
            <button className='book_Appoinment_btn' onClick={() => handleBookAppoinment(selectedDoctor)}>Book Appoinment</button>
        </div>
    </div>
  )
}

export default BookAppointment