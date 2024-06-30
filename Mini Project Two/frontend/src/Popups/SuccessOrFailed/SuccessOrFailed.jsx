import React from 'react'
import "./SuccessOrFailed.css"
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import { MdOutlineDone, MdOutlineClose} from "react-icons/md";

const SuccessOrFailed = ({handleClose,success}) => {
  return (
    <Modal show={success} onHide={handleClose}>
             <div className='SuccessOrFailed_wrapper'>
        <div className='icon_wrapper' style={{border: success ?  "5px dashed #02D367" : "5px dashed #FF535F"}}>
            {success ? 
            <MdOutlineDone className='icon' style={{color: success ?  "#02D367" : "#FF535F"}}/>
            :
            <MdOutlineClose className='icon' style={{color: success ?  "#02D367" : "#FF535F"}}/>
            }
        </div>
        <h4 className='success' style={{color: success ?  "#02D367" : "#FF535F"}}>
            {success ? "SUCCESS!" : "ERROR!" }
        </h4>
        <p className='description' style={{color: success ?  "#02D367" : "#FF535F"}}>
            {success 
            ? "Employee Has been Updated"  
            : "Sorry something went wrong" 
            }
        </p>
        <button onClick={() => handleClose(true)} className='success_handle_btn' style={{backgroundColor: success ?  "#02D367" : "#FF535F"}}>
            {success 
            ? "Done" 
            : "Try Again" 
            }
        </button>
    </div>
    </Modal>
    
  )
}

export default SuccessOrFailed