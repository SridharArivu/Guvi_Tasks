import React,{useState} from 'react';
import { useSelector, useDispatch } from 'react-redux';
import {MdDeleteOutline} from 'react-icons/md'
import { updateProfileField, updateSlotField, addTimeSlot, deleteTimeSlot, setImage } from '../../../../Redux/Slices/doctorProfileSlice';
import { specialties } from "./Specialties"
import SuccessOrFailed from '../../../../Popups/SuccessOrFailed/SuccessOrFailed';
import Axios from '../../../../api/Axios';

const DoctorProfileForm = ({getDoctorProfile}) => {
  const dispatch = useDispatch();
  const { profile } = useSelector(state => state.doctorProfile);
  const[success,setSuccess] = useState(false);

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    dispatch(setImage(file));
    dispatch(updateProfileField({ field:"isImageUploaded", value: true }))
  };

  const timeSlots = useSelector(state => state.doctorProfile.profile.timeSlots);


  const addTimeSlotHandler = () => {
    dispatch(addTimeSlot({ day: '', startTime: '', endTime: '' }));
  };

  const deleteTimeSlotHandler = (index) => {
    dispatch(deleteTimeSlot(index));
  };

  const handleChange = (index, field, value) => {
    dispatch(updateSlotField({ index, field, value }));
  };

  const handleProfileFeild = (e) =>{
    const { name, value } = e.target;
    dispatch(updateProfileField({ field: name, value: value }));
  }

  const imageUrl = `data:image/jpeg;charset=utf-8;base64,${profile?.image}`;

  const handleDocProfileSubmit = async (e) =>{
    if(profile.timeSlots.length === 0 || profile.specialization === '' || profile.fees === ''){
      window.alert("Please complete your profile before submitting.");
      return
    }
    console.log("called")
    e.preventDefault()
    setSuccess(false);
    const {image,...rest} = profile;
    const formData = new FormData();
    if(profile.isImageUploaded){
      formData.append("image", profile.image);
    }
    formData.append("user", new Blob([JSON.stringify(rest)], { type: 'application/json' }));
   
      try {
        const response = await Axios.put("/doctor/update-doctor-includes-image",formData, {
          headers: { 'Content-Type': 'multipart/form-data' }
        });
        if(response.status === 200) {
          setSuccess(true);
        }
        console.log(response);
        getDoctorProfile();
      } catch (error) {
        console.error(error)
      }
  }

 

  return (
    <form className='doctor_profile_form' onSubmit={handleDocProfileSubmit} >
      <SuccessOrFailed
      success={success}
      setSuccess={setSuccess}
      />
      <h3>Profile Information</h3>
      <div style={{display:'flex',flexDirection:'column'}}>
        <label htmlFor="name">Name*</label>
        <input type="text" name="username" id="username" value={profile.username} onChange={handleProfileFeild} />
      </div>

      <div style={{display:'flex',flexDirection:'column'}}>
        <label htmlFor="email">Email*</label>
        <input type="email" name="email" id="email" value={profile.email} onChange={handleProfileFeild} />
      </div>

      <div style={{display:'flex',flexDirection:'column'}}>
        <label htmlFor="phone">Phone*</label>
        <input type="tel" name="phone" id="phone" maxLength='10' placeholder='Phone Number' value={profile.phone} onChange={handleProfileFeild} />
      </div>

      <div style={{ display: "flex", flexDirection: "row", alignItems: "center", width: '90%' }}>
        <div className='vertical_align_wrapper'>
          <label htmlFor="gender">Gender</label>
          <select name="gender" className='gender' value={profile.gender} onChange={handleProfileFeild}>
            <option value="">Select</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Others">Others</option>
          </select>
        </div>
        <div className='vertical_align_wrapper'>
          <label htmlFor="specialization">Specialization</label>
          <select name="specialization" id='specialization' className='special' value={profile.specialization} onChange={handleProfileFeild}>
            <option value="">Select</option>
            {specialties?.map((specialty, index) => (
              <option key={index} value={specialty}>
                {specialty}
              </option>
            ))}
          </select>
        </div>
        <div className='vertical_align_wrapper'>
          <label htmlFor="fees" >Fees*</label>
          <input type="number" name="fees" id="fees" className='fees' value={profile.fees} onChange={handleProfileFeild} />
        </div>
      </div>

      <div>
        <label htmlFor="timeSlots">Time Slots*</label>
        {timeSlots?.map((slot, index) => (
        <div key={index} style={{ display: "flex", flexDirection: "row", alignItems: "center", width: '84%',marginTop:'2vh',position:'relative' }}>
         <div className='vertical_align_wrapper'>
         <label htmlFor="time">Day*</label>  
            <select
                value={slot?.day}
                required
                style={{marginTop:'0.5vh'}}
                className='day_input_field'
                onChange={(e) => handleChange(index, 'day', e.target.value)}
            >
                <option value="">Select Day</option>
                <option value="Monday">Monday</option>
                <option value="Tuesday">Tuesday</option>
                <option value="Wednesday">Wednesday</option>
                <option value="Thursday">Thursday</option>
                <option value="Friday">Friday</option>
                <option value="Saturday">Saturday</option>
                <option value="Sunday">Sunday</option>
            </select>
          </div>
          <div className='vertical_align_wrapper' style={{marginLeft:'4vh'}}>
            <label htmlFor="time">Starting Time*</label>
            <input
                required
                type="time"
                value={slot?.startTime}
                onChange={(e) => handleChange(index, 'startTime', e.target.value)}
            />
          </div>
          <div className='vertical_align_wrapper' style={{marginLeft:'4vh'}}>
          <label htmlFor="time" >Ending Time*</label>
            <input
                required
                type="time"
                value={slot?.endTime}
                onChange={(e) => handleChange(index, 'endTime', e.target.value)}
            />
          </div>
          <MdDeleteOutline onClick={() => deleteTimeSlotHandler(index)}  className='delete_time_slots_btn' />
        </div>
        
        ))}
      </div>

      <button type="button" onClick={addTimeSlotHandler} className='addTimeSlot_btn'>Add Time Slot</button>

      <div className='vertical_align_wrapper' style={{width:"fit-content"}}>
        <label htmlFor="image">Image Upload*</label>
        <div style={{display:'flex',flexDirection:"row",height:'fit-content',alignItems:'center',gap:'3vh'}}>
          <img src={imageUrl} alt="profile" className='previous_profile'/>
          <input type="file" id='image' name='image' className='image_upload' onChange={handleImageChange} />
        </div>
      </div>

      <button type='submit' className='form_submit_btn'>Update Profile</button>
    </form>
  );
};

export default DoctorProfileForm;
