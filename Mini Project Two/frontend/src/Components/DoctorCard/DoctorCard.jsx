import React from 'react'
import "./DoctorCard.css"
import { FaStar } from "react-icons/fa6";
import { IoIosArrowRoundForward } from "react-icons/io";
import {setSelectedDoctor} from "../../Redux/Slices/findDoctorSlice"
import { useDispatch } from 'react-redux';
import { FaPrescriptionBottleMedical } from "react-icons/fa6";

const DoctorCard = ({setBookButtonClicked,allign,doctor,showPrescription,handleViewPriscribedList,user}) => {
  const dispatch = useDispatch();
  

  const handleBookButton = (doctor) =>{
    setBookButtonClicked(true);
    dispatch(setSelectedDoctor(doctor))
    localStorage.setItem("selectedDoctor",doctor);
  }

  
  
  const imageUrl = `data:image/jpeg;charset=utf-8;base64,${doctor?.image || doctor?.doctorImage || user?.profilePicture }`;
  return (
    <div className='Doctor_card' style={allign === "findDoctor" ?{flexDirection:"column"} : {flexDirection:"row"}}>
        <img id='profile_pic' src={imageUrl} alt="Doctor Profile" />
        <div className={allign === "findDoctor" ? "" : "allign"}>
          <h3 className='name'>Dr. {doctor?.username || doctor?.doctorName || user?.name}</h3>
          {allign === "findDoctor"
          ?
            <div className='specialist_and_ratings'>
                <span className='specialist'>{doctor?.specialization}</span>
                <p className='rating'> <FaStar className='star'/>  4.5 <span>{"(2)"}</span></p>
            </div>
            :
            <>
              <span className='specialist'>{doctor?.specialization}</span>
              <p className='rating'> <FaStar className='star'/>  4.5 <span>{"(2)"}</span></p>
            </>
          }
          

          <div className='hospitalName_and_book_appointment'>
            { !showPrescription &&  <p className='hospital_name'>At Mount Adora hospital, Sylhet</p> }
              {allign === "findDoctor" &&
                showPrescription ?
                <button onClick={() => handleViewPriscribedList(doctor)} disabled={!doctor?.isPrescribed} className='view-prescription-button'>
                        View Prescription
                        <FaPrescriptionBottleMedical/>
                </button>
                :
                <button className='book_appointment' onClick={() => handleBookButton(doctor)}>
                    <IoIosArrowRoundForward className='arrow_icon'/>
                </button>
              }
          </div>
        </div>
    </div>
  )
}

export default DoctorCard