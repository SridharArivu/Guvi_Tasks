import React from 'react'
import './Form.css'
import { setEmployeeDetails } from '../../../Redux/Slices/AddEmployeeForm';
import { IoClose } from "react-icons/io5";
import { useDispatch } from 'react-redux'
import {empID_First_and_LastName, email_phone_and_photo,
    gender_and_role, City_and_state, Country_and_zipcode} from './FormAttributes'

import {resetEmployeeDetailsState} from "../../../Redux/Slices/AddEmployeeForm"

const Form = (props) => {
    
    const{image,streetAddress} = props.empDetails;

    const dispatch = useDispatch();

    const handleInputChange = (e) => {
        const { name, value, files } = e.target;
        if(files){
            dispatch(setEmployeeDetails({ key: name, value: files[0] }));
        }else{
            dispatch(setEmployeeDetails({ key: name, value: value }));
        }       
    };    
    
  return (
    <>
    <h2>Add a new Employee</h2>
    <p>Fill out the form to add a new employee to your organization.</p>
    <form onSubmit={props.handleSubmit}>
    
        <IoClose className='close_btn' onClick={() => props.handleClose()}/>

        {/* <!-- <=== employeeID , Firstname and LastName ===> --> */}
                <h4 className="sub_heading">Basic Details:</h4>
                <div className="multiple_input_container">
                    {empID_First_and_LastName.map((field, index) => (
                        <div className="input_container" key={index}>
                            <label htmlFor={field.id}>{field.label}</label>
                            <input
                                className="input_field"
                                type={field.type}
                                name={field.name}
                                id={field.id}
                                maxLength={field.maxLength}
                                value={props.empDetails[field.name]}
                                onChange={handleInputChange}
                                autoComplete={field.autoComplete}
                                required
                            />
                        </div>
                    ))}
                </div>

        {/* <!-- <=== Email , Phone & Photo ===> --> */}
                <div className="multiple_input_container">
                    {email_phone_and_photo.map((field, index) => (
                        <div className="input_container" key={index} style={field.containerStyle}>
                            <label htmlFor={field.name}>{field.label}</label>
                            <input
                                className={field.className}
                                type={field.type}
                                name={field.name}
                                id={field.id}
                                maxLength={field.max}
                                value={props.empDetails[field.value]}
                                accept={field.accept}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                     ))}
                     {!props.updateClicked && 
                        <div className="input_container" style={{width: "65%"}}>
                            <label htmlFor="input-file">Profile Picture</label>
                            <input 
                                style={{width: "100%"}} 
                                type="file" 
                                value={image}
                                onChange={handleInputChange} 
                                required
                                accept="image/png, image/jpeg"
                                name="file" 
                                id="input-file"  />
                        </div>
                    }
                </div>

        {/* <!-- <=== Role & Gender ===> --> */}
            <div className="multiple_input_container">
                {gender_and_role.map((field, index) => (
                    <div className="input_container" key={index}>
                    <label htmlFor={field.id}>{field.label}</label>
                        <select
                            className="input_field"
                            name={field.name}
                            id={field.id}
                            value={props.empDetails[field.name]}
                            onChange={handleInputChange}
                            required
                        >
                            {field.options.map((option, idx) => (
                                <option key={idx} value={option.value}>
                                    {option.label}
                                </option>
                            ))}
                        </select>
                    </div>
                ))}

            </div>

            <h4 className="sub_heading" style={{marginTop: "2vh"}}>Location:</h4>

        {/* <!-- <=== Location Details ===> --> */}
            <div className="multiple_input_container">
                <div className="input_container" style={{width: "65%"}}>
                    <label htmlFor="streetAddress">Street Address</label>
                    <input 
                        style={{width: "100%"}} 
                        className="input_field" 
                        type="text" 
                        value={streetAddress}
                        onChange={handleInputChange} 
                        required
                        name="streetAddress" 
                        id="streetAddress"  />
                </div>
            </div>

            {/* <!-- <=== City & State ===> --> */}
            <div className="multiple_input_container">
                {City_and_state.map((field, index) => (
                    <div className="input_container" key={index} style={field.containerStyle}>
                        <label htmlFor={field.id}>{field.label}</label>
                        <input
                            className="input_field"
                            type={field.type}
                            name={field.name}
                            id={field.id}
                            required
                            value={props.empDetails[field.name]}
                            onChange={handleInputChange}
                        />
                    </div>
                ))}
            </div>

             {/* <!-- <=== Country & Zipcode ===> --> */}
            <div className="multiple_input_container">
                {Country_and_zipcode.map((field, index) => (
                    <div className="input_container" key={index} style={field.containerStyle}>
                        <label htmlFor={field.id}>{field.label}</label>
                        <input
                            className="input_field"
                            type={field.type}
                            name={field.name}
                            id={field.id}
                            required
                            maxLength={field.maxLength}
                            value={props.empDetails[field.name]}
                            onChange={handleInputChange}
                        />
                    </div>
                ))}
            </div>
            
            {/* <!-- <=== Submit & Cancel buttons ===> --> */}
            <div className="buttons">
                <button className="viewTable_BTN" 
                    type='reset' 
                    disabled={props.loading}
                    onClick={() => {
                        props.handleClose()
                        dispatch(resetEmployeeDetailsState());
                    }}>
                        Cancel
                </button>
                <button className="Submit_BTN" 
                    disabled={props.loading}
                    type="submit" >
                        {props.updateClicked ? "Update Employee" : " Add Employee"}
                       
                </button>
            </div>
        </form>
    </>
  )
}

export default Form