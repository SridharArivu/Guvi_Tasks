import React,{useState} from 'react'
import "./Login.css"
import useAuth from '../../hooks/useAuth'
import {setAuthState} from "../../Redux/Slices/authSlice"
import { useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'

const Login = () => {
    const {loginUser} = useAuth();
    const dispatch = useDispatch();
    const navigate = useNavigate();
    
    const [Data, setData] = useState({
        email: '',
        password: '',
        role: 'PATIENT',
      });
    const handleChange = (e) => {
        const { name, value } = e.target;
        setData({
          ...Data,
          [name] : value,
        });
        
    };
    
    const handleSubmit = async (e) => {
        e.preventDefault();
       
        const response = await loginUser(Data);
        if(!response.payload){
            dispatch({isAuth:false,role:null});
            return;
        }
        const role = response.payload.role[0];
        dispatch(setAuthState({isAuth:true,role}));
        navigate("/");
      };
  return (
    <div className='Login_wrapper'>
        <div className='Login_component_wrapper'>
            <div className='login'>

                <h4>Hello! <span>Welcome</span> Back </h4>
                <input className='input_feild' type="email" name="email" id="email" placeholder='Email' onChange={handleChange}/>
                <input className='input_feild' type="password" name="password" id="password" placeholder='Password' onChange={handleChange}/>
                <div className='gender_and_role'>
                    <h4>Are you a:
                        <select onChange={handleChange} value={Data.role} name="role">
                            <option value="PATIENT">Patient</option>
                            <option value="DOCTOR">Doctor</option>
                        </select>
                    </h4>
                </div>

                <button type='submit' onClick={handleSubmit}>Login</button>
                <p>Don't have an account? <a href='/register'>Register</a></p>
            </div>
        </div>
    </div>
  )
}

export default Login