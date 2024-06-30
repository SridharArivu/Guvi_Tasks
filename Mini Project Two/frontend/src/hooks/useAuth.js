// src/hooks/useAuth.js
import { useSelector, useDispatch } from 'react-redux';
import { login, logout,register } from '../Redux/Slices/authSlice';


const useAuth = () => {
  const dispatch = useDispatch();
  const isAuthenticated = useSelector((state) => state.auth.isAuthenticated);
  const role = useSelector((state) => state.auth.role);
  const loading = useSelector((state) => state.auth.loading);
  const error = useSelector((state) => state.auth.error);

  const loginUser = (credentials) => {
    return dispatch(login(credentials));
  };

  const registerUser = (credentials) =>{
    return dispatch(register(credentials))
  }

  const logoutUser = () => {
    return dispatch(logout());
  };

  return {
    loginUser,
    logoutUser,
    registerUser,
    isAuthenticated,
    role,
    loading,
    error,
  };
};

export default useAuth;
