import React, { useState, useEffect } from 'react'
import './Home.css'
import EmployeeCard from '../../components/EmployeeCard/EmployeeCard'
import EmployeeForm from '../../components/Popups/EmployeeForm/EmployeeForm'
import Axios from '../../api/Axios'
import EmptyTable from "../../Assets/empty_table.png"
import EmployeeSkeleton from '../../LoadingScreens/EmployeeSkeleton'


const Home = ({show,handleShow,handleClose}) => {

  const[employeesList,setEmployeeList] = useState([]);
  const[updateClicked,setUpdateClicked] = useState(false);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(()=>{
    getAllEmployees();
  },[])
 
  const getAllEmployees = async () => {
    try {
      const employeesList = await Axios.get("/get-all-employee", { headers: { "content-type": "application/json" } });
      if (employeesList.status === 200) {
        setEmployeeList(employeesList.data);
        console.log(employeesList.data)
        setIsLoading(false);
      } else {
        setEmployeeList([]);
        setIsLoading(false);
      }
    } catch (error) {
      console.log("from get all employee", error);
      setIsLoading(false);
    }
  };

  return (
    <>
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