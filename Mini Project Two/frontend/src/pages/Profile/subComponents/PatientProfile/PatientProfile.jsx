import React, { useEffect, useState } from 'react'
import "./PatientProfile.css"
import { useNavigate } from 'react-router-dom';
import  DoctorCard from "../../../../Components/DoctorCard/DoctorCard"
import Axios from '../../../../api/Axios';
import PrescriptionList from '../../../../Popups/PrescriptionList/PrescriptionList';
import { useSelector } from 'react-redux';


const PatientProfile = ({logoutUser}) => {
  const navigate = useNavigate();
  const {user}= useSelector((state) => state.auth)

  useEffect(() =>{
    getAllPatientAppointments();
  },[])

  const [appoinmentList,setAppoinmentList] = useState([])
  const [showPricribedList, setShowpriscribedList] = useState(false);
  const[selectedMedications,setSelectedMedications] = useState([]);
  const[selectedAppoinment,setSelectedAppoinment] = useState({});

  const getAllPatientAppointments = async () =>{
    try {
      const response = await Axios.get("/appointment/all/patient/appointments", { headers: { 'Content-Type': 'application/json' }})
      setAppoinmentList(response.data)
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
  const handleViewPriscribedList = (appoinment) => {
    setSelectedAppoinment(appoinment)
    setSelectedMedications(appoinment?.prescriptionList)
    setShowpriscribedList(true)
  }
  const handleAccept = async (medications) =>{
    const checkedMedications = medications.filter(medication => medication.checked);
    const body={
      prescriptionList:checkedMedications,
      appointmentId:selectedAppoinment.appointmentId
    }
    console.log(medications,selectedAppoinment);
    try {
      const response = await Axios.put("/appointment/accepted/medicines",body,{ headers: { 'Content-Type': 'application/json' }})
      console.log(response.status);
      if(response?.status === 200){
        setShowpriscribedList(false);
        getAllPatientAppointments()
      } 
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

  const imageData = `data:image/jpeg;charset=utf-8;base64,${user?.profilePicture}`;
  return (
    <div className='PatientProfile_wrapper'>
      <PrescriptionList
      handleAccept={handleAccept}
      prescriptionList={selectedMedications}
      setShowpriscribedList={setShowpriscribedList}
      showPricribedList={showPricribedList}
      />
      <div className='profile_section'>
          <img src={imageData} alt="profile" className='profile_image' />
          <p className='name'>{user?.name}</p>
          <p className='email'>{user?.email}</p>

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
              {appoinmentList.map((app,index) => (
                <>
                  <DoctorCard
                  doctor={app}
                  allign="findDoctor"
                  handleViewPriscribedList={handleViewPriscribedList}
                  setShowpriscribedList={setShowpriscribedList}
                  showPrescription={true}
                  />
                </>
              ))}
            </div>
      </div>
    </div>  
  )
}

export default PatientProfile