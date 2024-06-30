import React, { useState, useEffect } from 'react'
import './Home.css'
import EmployeeCard from '../../components/EmployeeCard/EmployeeCard'
import EmployeeForm from '../../components/Popups/EmployeeForm/EmployeeForm'
import Axios from '../../api/Axios'
import EmptyTable from "../../Assets/empty_table.png"
import EmployeeSkeleton from '../../LoadingScreens/EmployeeSkeleton'
import { ThreeDots } from 'react-loader-spinner';


const Home = ({show,handleShow,handleClose}) => {

  const[employeesList,setEmployeeList] = useState([]);
  const[updateClicked,setUpdateClicked] = useState(false);
  const [isLoading, setIsLoading] = useState(true);
  const[updateLoading, setUpdateLoading] = useState(false);

  useEffect(()=>{
    getAllEmployees();
  },[])
 
  const getAllEmployees = async () => {
    try {
      const employeesList = await Axios.get("/get-all-employee", { headers: { "Content-type": "application/json" } });
      if (employeesList.status === 200) {
        setEmployeeList(employeesList.data);
        setIsLoading(false);
        return true;
      } else {
        setEmployeeList([]);
        setIsLoading(false);
        return true
      }
    } catch (error) {
      console.log("from get all employee", error);
      setIsLoading(false);
      return false;
    }
  };
  const spinnerStyle = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    zIndex:'1',
  };

  return (
    <>
    <ThreeDots
            visible={updateLoading} height="80"
            width="80" color="#4fa94d"
            radius="9" ariaLabel="three-dots-loading"
            wrapperStyle={spinnerStyle} wrapperClass=""
        />
      <EmployeeForm
        show={show}
        handleClose={handleClose}
        getAllEmployees={getAllEmployees}
        updateClicked={updateClicked}
        setUpdateClicked={setUpdateClicked}
      />
      <div className='Employee_Cards_Container'>
        {
          isLoading ?
           Array(12).fill().map((arr,index) => (
            <EmployeeSkeleton/>
          ))
          :
          employeesList.length !== 0 
          ?
         employeesList?.map((emp, index) => (
              <EmployeeCard 
                emp={emp} 
                key={index}
                isLoading={isLoading}
                handleShow={handleShow}
                setUpdateLoading={setUpdateLoading}
                updateLoading={updateLoading}
                setUpdateClicked={setUpdateClicked}
                getAllEmployees={getAllEmployees}
              />
            ))
            :
            <img className='empty_list_background' src={EmptyTable} alt="Empty list" />
          }
      </div>
    </>
  );
};

export default Home