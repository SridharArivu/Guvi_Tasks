import React from 'react'
import './EmployeeCard.css'
import profilePic from '../../Assets/Profile.jpg'
import { FaRegEdit } from "react-icons/fa";
import { MdEmail,MdOutlineDelete } from "react-icons/md";
import { FaPhone } from "react-icons/fa6";
import useUpdateEmployee from "../../customHooks/useUpdateEmployee"
import Axios from '../../api/Axios';
import {resetEmployeeDetailsState} from "../../Redux/Slices/AddEmployeeForm"
import { useDispatch } from 'react-redux';
import { Skeleton } from '@mui/material';

const EmployeeCard = ({emp,handleShow,setUpdateClicked,getAllEmployees,isLoading}) => {

  const {updateFormState} = useUpdateEmployee();

  const dispatch = useDispatch();
  
  const handleUpdate = (id) =>{
       const response = updateFormState(id);
       if(response){
        handleShow();
        setUpdateClicked(true);
       } 
  }
  const handleDelete = async (id) =>{
    try {
      const response = await Axios.delete(`delete-emp/${id}`);
      console.log(response)
      getAllEmployees();
      dispatch(resetEmployeeDetailsState());
    } catch (error) {
      console.log(error);
    }
  }
  

  const imageUrl = `data:image/jpeg;charset=utf-8;base64,${emp.image}`;
  return (
    <div className='Card_Wrapper' >

          <div className='front'>
              <div className='img_wrapper'>
                <img className='profilePic' src={imageUrl} alt="profile" />
              </div>
              <div className='emp_details'>
                <div>
                  <h4 className='name'>{emp.firstName+" "}{emp.lastName}</h4>
                  <p className='role'>{emp.role}</p>
                </div>
                <div>
                  <p className='phone'>
                    <i className='icon'> <FaPhone /></i>
                     +91 {emp.phone}
                  </p>
                  <p className='email'>
                    <i className='icon'> <MdEmail /> </i>
                      {emp.email}
                  </p>
                </div>
              </div>
          </div>


          <div className='back'>
            <h4>Address:</h4>
          
                <p>{emp.streetAddress}</p>
                <p>{emp.city}</p>
                <p>{emp.state + ', '}{emp.pincode}</p>
               
            <div className='Buttons'>
                <button className='edit_btn'
                  onClick={() => handleUpdate(emp.employeeID)}
                >
                  <FaRegEdit className='update_icon'/>Update
                </button>
                <button className='delete_btn'
                onClick={() => handleDelete(emp.employeeID)}
                >

                  <MdOutlineDelete className='delete_icon'/>Delete
                  </button>
            </div>
          </div>

    </div>
  )
}

export default EmployeeCard