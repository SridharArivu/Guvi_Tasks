import React from 'react'
import Modal from 'react-bootstrap/Modal';
import './SuccessOrFailed.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import { MdOutlineDone, MdOutlineClose} from "react-icons/md";
import {resetEmployeeDetailsState}  from '../../../Redux/Slices/AddEmployeeForm'
import { useDispatch } from 'react-redux'
const SuccessOrFailed = ({status,setSuccessMessage,handleClose,getAllEmployees,updateClicked,setUpdateClicked}) => {
    const dispatch = useDispatch();
    const handleSuccess = () => {
        handleClose();
        setSuccessMessage(false); 
        dispatch(resetEmployeeDetailsState());
        getAllEmployees();
        setUpdateClicked(false);
    }
  return (
    <div className='SuccessOrFailed_wrapper'>
        <div className='icon_wrapper' style={{border: status ?  "5px dashed #02D367" : "5px dashed #FF535F"}}>
            {status ? 
            <MdOutlineDone className='icon' style={{color: status ?  "#02D367" : "#FF535F"}}/>
            :
            <MdOutlineClose className='icon' style={{color: status ?  "#02D367" : "#FF535F"}}/>
            }
        </div>
        <h4 className='status' style={{color: status ?  "#02D367" : "#FF535F"}}>
            {status ? "SUCCESS!" : "ERROR!" }
        </h4>
        <p className='description' style={{color: status ?  "#02D367" : "#FF535F"}}>
            {status 
            ? updateClicked ? "Employee Has been Updated" : "New Employee Has been added"  
            : "Sorry something went wrong" 
            }
        </p>
        <button onClick={() => status ? handleSuccess() : setSuccessMessage(false)} className='Status_handle_btn' style={{backgroundColor: status ?  "#02D367" : "#FF535F"}}>
            {status 
            ? "Done" 
            : "Try Again" 
            }
        </button>
    </div>
  )
}

export default SuccessOrFailed