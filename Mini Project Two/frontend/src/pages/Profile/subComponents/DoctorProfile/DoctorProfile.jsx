import React, { useEffect, useState } from 'react'
import "./DoctorProfile.css"
import { redirect, useNavigate } from 'react-router-dom';
import DoctorCard from "../../../../Components/DoctorCard/DoctorCard"
import { IoIosInformationCircle } from "react-icons/io";
import DoctorProfileForm from './DoctorProfileForm';
import Axios from '../../../../api/Axios';
import { useSelector, useDispatch } from 'react-redux';
import "./TableStyle.css"
import { updateProfileField, updateSlotField, addTimeSlot, deleteTimeSlot, setImage } from '../../../../Redux/Slices/doctorProfileSlice';
import PrescribeForm from '../../../../Popups/PrescribeForm/PrescribeForm';


const DoctorProfile = ({logoutUser}) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const { profile } = useSelector(state => state.doctorProfile);

  const [section,setSection] = useState(0);
  const handleSection = (e) =>{
    if(e.target.id == 1){
      getAllAppointments();
    }
    setSection(parseInt(e.target.id));
  }
 
 



  const [appointments,setAppointments] = useState([]);
  const getAllAppointments =  async () =>{
    try {
      const response = await Axios.get("/appointment/all/doctor/appointments",{
        headers: { 'Content-Type': 'application/json' }
      })
      if(response.data) setAppointments(response.data);
    } catch (error) {
        console.error(error);
    }
  }

  
  useEffect(() => {
    getDoctorProfile();
  },[])
  const getDoctorProfile = async () => {
    try {
      const response = await Axios.get("/doctor", {
        headers: { 'Content-Type': 'application/json' }
      });
      if(response.data){
        const {username,email,gender,verified,phoneNumber,roles,specialization,fees,timeSlots,image} = response.data;
        dispatch(updateProfileField({ field: "username", value: username }));
        dispatch(updateProfileField({ field: "email", value: email }));
        dispatch(updateProfileField({ field: "phone", value: phoneNumber }));
        dispatch(updateProfileField({ field: "gender", value: gender }));
        dispatch(updateProfileField({ field: "verified", value: verified }));
        dispatch(updateProfileField({ field: "role", value: roles[0] }));
        dispatch(updateProfileField({ field: "specialization", value: specialization }));
        dispatch(updateProfileField({ field: "fees", value: fees }));
        dispatch(updateProfileField({ field: "timeSlots", value: timeSlots }));
        dispatch( setImage({image}));
      }
  
    } catch (error) {

      localStorage.removeItem("token");
      localStorage.removeItem("role");
      navigate("/login");
      // if(error.response.status === 403) navigate("/login");
      
      console.error("Error fetching doctor profile:", error);
    }
  };

  const[showPrescribeForm,seShowtPrescribeForm] = useState(false)
  const [medicines, setMedicines] = useState([{ name: '', dosage: '', frequency: '' }]);
  const[selectedAppointment,setSelectedAppoinment] = useState({});

  const handlePrescribe = async (appointment) => {
    setSelectedAppoinment(appointment);
    if(!showPrescribeForm){
      seShowtPrescribeForm(true);
      return
    } 
    const body = {
      doctorEmail:selectedAppointment.doctorEmail,
      patientEmail:selectedAppointment.patientEmail,
      patientName:selectedAppointment.name,
      prescriptionList:medicines,
      isPatientConfirmed:false,
    }
    try {
      const response = await Axios.post("/prescription/save",body,{ headers: { 'Content-Type': 'application/json' }})
      if(response.status === 200){
        seShowtPrescribeForm(false);
      }
    } catch (error) {
      
    }
  }

  
 
  return (
    <div className='Doctor_Profile_wrapper'>
      <div className='profile_section'>
            <p className={section === 0 ? "activeSection" : "section"} id='0' onClick={handleSection}>Overview</p>
            <p className={section === 1 ? "activeSection" : "section"} id='1' onClick={handleSection}>Appointments</p>
            <p className={section === 2 ? "activeSection" : "section"} id='2' onClick={handleSection}>Profile</p>

          <button className='logout_btn' onClick={() => {
            logoutUser();
            navigate("/login");
            }}>
              Logout
          </button>
          <button className='delete_acc_btn'>Delete Account</button>
      </div>
      <div className='Doctor_Profile_section_two'>
        {!profile.verified &&
            <p className='approval_notification' ><IoIosInformationCircle/>To get approval please complete your profile</p>
          }
          {section === 0 &&  
          <DoctorCard
          doctor={profile}
          /> }
          {section === 1 &&  
          <>
          <PrescribeForm
          handlePrescribe={handlePrescribe}
          showPrescribeForm={showPrescribeForm}
          seShowtPrescribeForm={seShowtPrescribeForm}
          medicines={medicines}
          setMedicines={setMedicines}
          />
          <table className='Appoinment_table'>
          <thead>
            <tr>
              <th>NAME</th>
              <th>GENDER</th>
              <th>APPOINTMENT</th>
              <th>BOOKED ON</th>
              <th>STATUS</th>
              <th>PRESCRIBE</th>
            </tr>
          </thead>
          <tbody>
            {appointments?.map((appointment, index) => (
              <tr key={index}>
                <td>{appointment.name}</td>
                <td>{appointment.gender}</td>
                <td>{appointment.timeSlots}</td>
                <td>{appointment.bookedOn}</td>
                <td>{appointment.status ? "Completed" : "Pending"}</td>
                <td>  {appointment.prescribe ? (
                        "Done"
                    ) : (
                    <button className="prescribe-button" onClick={() => handlePrescribe(appointment)}>Prescribe</button>
              )}
              </td>
              </tr>
            ))}
          </tbody>
          </table>
          </>
        
          }
          {section === 2 &&  
      
            <DoctorProfileForm 
            getDoctorProfile={getDoctorProfile}
            />
          
          }
      </div>
    </div>  
  )
}

export default DoctorProfile