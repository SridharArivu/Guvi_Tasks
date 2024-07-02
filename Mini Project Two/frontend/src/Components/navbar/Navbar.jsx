import React, { useEffect,useState } from 'react';
import { FaPlus } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';
import useAuth from '../../hooks/useAuth';
import "./Navbar.css"
import { useSelector } from 'react-redux';

const Navbar = () => {
  const { isAuthenticated, logoutUser } = useAuth();
  const navigate = useNavigate();

  const {user} = useSelector((state) => state.auth);

  const findDoctor = window.location.pathname === "/find-doctor";
  const home = window.location.pathname === "/";
  const service = window.location.pathname === "/service";
  const contact = window.location.pathname === "/contact";

  const [imageUrl, setImageUrl] = useState('');

  useEffect(() => {
    const imageData = `data:image/jpeg;charset=utf-8;base64,${user?.profilePicture}`;
    setImageUrl(imageData)
  }, [user]);


  const updateProfileIcon = () => {
    return isAuthenticated ? (
      <img className='profile_picture' onClick={() => navigate("/profile")} src={imageUrl} alt='profile' />
    ) : (
      <button onClick={() => navigate("/login")} className='login_btn'>Log In</button>
    );
  };

  
  return (
    <div className='Navbar_wrapper'>
      <p className='brand_name'  onClick={() => navigate("/")}> <FaPlus className='logo'/>Medicare</p>
      <ul className="Navlinks">
        <li 
          onClick={() => navigate("/")} 
          className={home ? 'active' : ''}
        >
          Home
        </li>
        <li 
          onClick={() => navigate("/")} 
          className={service ? 'active' : ''}
        >
          Services
        </li>
        <li 
          onClick={() => navigate("/find-doctor")} 
          className={findDoctor ? 'active' : ''}
        >
          Find a Doctor
        </li>
        <li 
          onClick={() => navigate("/")} 
          className={contact ? 'active' : ''}
        >
          Contact
        </li>
      </ul>
      {updateProfileIcon()}
    </div>
  );
};

export default Navbar;
