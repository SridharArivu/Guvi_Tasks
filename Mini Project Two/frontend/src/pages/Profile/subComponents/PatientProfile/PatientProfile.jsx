import React from 'react'
import "./PatientProfile.css"
import Profile from "../../../../Components/DoctorCard/Images/imageOne.png"
import { useNavigate } from 'react-router-dom';
import  DoctorCard from "../../../../Components/DoctorCard/DoctorCard"


const PatientProfile = ({logoutUser}) => {
  const navigate = useNavigate();
  return (
    <div className='PatientProfile_wrapper'>
      <div className='profile_section'>
          <img src={Profile} alt="profile" className='profile_image' />
          <p className='name'>emran</p>
          <p className='email'>emram@gmail.com</p>

          <button className='logout_btn' onClick={() => {
            logoutUser();
            navigate("/login");
            }}>
              Logout
          </button>
          <button className='delete_acc_btn'>Delete Account</button>
      </div>
      <div className='Appoinment_section'>
          <div>
            <button className="MyBookings" >My Bookings</button>
            <button className="Settings" >Settings</button>
            </div>
            <h3 className="MyBooking_heading">My bookings</h3>
            <div className="myBookings_wrapper_grid">
              <DoctorCard
              allign="findDoctor"
              />
              <DoctorCard
              allign="findDoctor"
              />
              <DoctorCard
              allign="findDoctor"
              />
              <DoctorCard
              allign="findDoctor"
              />
            </div>
      </div>
    </div>  
  )
}

export default PatientProfile