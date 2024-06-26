import React, { useState } from 'react'
// Components
import SuccessOrFailed from '../SuccessOrFailed/SuccessOrFailed';
import Form from './Form'
//styles
import Modal from 'react-bootstrap/Modal';
import 'bootstrap/dist/css/bootstrap.min.css';
import { ThreeDots } from 'react-loader-spinner';
//redux
import { useSelector } from 'react-redux'
//utils
import FormSubmission from '../../../utils/FormSubmission'
import useUpdateEmployee from '../../../customHooks/useUpdateEmployee'



const EmployeeForm = (props) => {
    
    const[loading, setLoading] = useState(false);
    const[successMessage,setSuccessMessage] = useState(false);
    const[fetchResult,setFetchResult] = useState(false);

    const empDetails = useSelector((state) => state.AddEmployeeForm);

    const {submitUpdatedForm} = useUpdateEmployee(); 
    

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        const result = await (props.updateClicked ?submitUpdatedForm(empDetails) : FormSubmission(empDetails)) ;
        setFetchResult(result);
        setSuccessMessage(true);
        setLoading(false);
        props.getAllEmployees();
      };

      const successOrFailurePopup = (value) => {
        return <SuccessOrFailed 
        status={value}
        getAllEmployees={props.getAllEmployees}
        handleClose={props.handleClose}
        updateClicked={props.updateClicked}
        setUpdateClicked={props.setUpdateClicked}
        setSuccessMessage={setSuccessMessage}
        />  
      }
     
      const spinnerStyle = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        zIndex:'1',
      };
  return (
    <Modal {...props} centered>
        
        <div className='Popup_wrapper'>

      {/* //Loading animation from react spinners library */}
        <ThreeDots
            visible={loading} height="80"
            width="80" color="#4fa94d"
            radius="9" ariaLabel="three-dots-loading"
            wrapperStyle={spinnerStyle} wrapperClass=""
        />
        {
        !successMessage
        ?
        <>
        {/* Employee Form */}
        <Form
            handleSubmit={handleSubmit}
            empDetails={empDetails}
            handleClose={props.handleClose}
            updateClicked={props.updateClicked}
            loading={loading}
        />
        </>
        :
        <>
        {/* Success or Failure Submission popup */}
        {successOrFailurePopup(fetchResult)}
        </>
        }
        </div>  
      </Modal>
  )
}

export default EmployeeForm