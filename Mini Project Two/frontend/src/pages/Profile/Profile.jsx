import React,{useEffect, useState} from 'react'
import useAuth from '../../hooks/useAuth'
import PatientProfile from "./subComponents/PatientProfile/PatientProfile"
import DoctorProfile from "./subComponents/DoctorProfile/DoctorProfile"


const Profile = () => {
    const {role,logoutUser} = useAuth();


    const checkUserRole = () =>{
        if(role == "PATIENT"){
            return(
                <PatientProfile logoutUser={logoutUser}/>
            )
        } 
        if(role == "DOCTOR"){
            return(
                <DoctorProfile logoutUser={logoutUser}/>
            )
        }
    }
    
  return (
    <div style={{display:"flex",alignItems:"center",justifyContent:"center",width:"100vw"}}>
        {checkUserRole()}
    </div>
  
  )
}

export default Profile