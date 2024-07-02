import React,{useState} from 'react'
import "./Register.css"
import LoginBg from "../../Assets/LoginBG.png"
import useAuth from '../../hooks/useAuth'
import {setAuthState} from "../../Redux/Slices/authSlice"
import { useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'

const Register = () => {
    const {registerUser,getUser} = useAuth();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    
    const[loading,setLoading] = useState(false);
    const [Data, setData] = useState({
        fullname: '',
        email: '',
        password: '',
        role: 'PATIENT',
        gender: 'Male',
        file: null,
      });
    const handleChange = (e) => {
        const { name, value, files } = e.target;
        setData({
          ...Data,
          [name]: files ? files[0] : value,
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setLoading(true);
        const formData = new FormData();
        const {file,...rest} = Data;
        formData.append("user", new Blob([JSON.stringify(rest)], { type: 'application/json' }));
        formData.append("image", file);

        const response = await registerUser(formData);
        if(!response.payload){
            dispatch(setAuthState({isAuth:false,role:null}));
            return;
        }
        if(response) getUser();
        setLoading(false);
        const role = response.payload.role[0];
        dispatch(setAuthState({isAuth:true,role}));
        navigate("/");
      };
  return (
    <div className='register_wrapper'>
        <div className='register_component_wrapper'>
                <img className='img'  src={LoginBg} alt="register_background" />
    
            <div className='register'>

                    <h4>Create an <span>Account</span> </h4>
                    <input className='register_input_feild' onChange={handleChange} type="text" name="fullname" id="fullname" placeholder='Full Name' required/>
                    <input className='register_input_feild' onChange={handleChange} type="email" name="email" id="email" placeholder='Email' required/>
                    <input className='register_input_feild' onChange={handleChange} type="password" name="password" id="password" placeholder='Password' required/>
                    <div className='register_gender_and_role'>
                        <h4>Are you a:
                            <select required onChange={handleChange} value={Data.role} name="role">
                                <option value="PATIENT">Patient</option>
                                <option value="DOCTOR">Doctor</option>
                            </select>
                        </h4>
                        <h4>Gender:
                            <select required onChange={handleChange} value={Data.gender} name="gender">
                                <option selected disabled hidden>Select</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Others">Others</option>
                            </select>
                        </h4>
                    </div>
                    <input type="file" name="file" id="file"  placeholder='up' required onChange={handleChange}/>
                    <button type='submit' className='register_submit_btn' onClick={handleSubmit} disabled={loading}>Sign Up</button>
                    <p>Already have an account? <a href='/login'>Login</a></p>
            </div>
        </div>
    </div>
  )
}

export default Register