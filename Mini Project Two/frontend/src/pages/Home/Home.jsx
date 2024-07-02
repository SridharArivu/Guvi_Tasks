import React, { useEffect } from 'react'
import "./Home.css"
import grid_image_doctors from "./Assets/Image_grid_doctors.png"
import Axios from '../../api/Axios'


const Home = () => {
    useEffect(() => {
        pingServer();
      }, []);
    
      const pingServer = async () => {
        try {
          const response = await Axios.get("/ping");
          if (response.status === 200) {
            console.log(response.data);
          }
        } catch (error) {
          console.error(error);
          window.alert("Server Down, Please visit later");
        }
      };
  return (
    <div className='Home_wrapper'>
    <div className='section_1'>
        <div>
            <h2>We help patients <br/> live a healthy, <br/>longer life </h2>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Maxime <br/> rem, eaque consequuntur deleniti cupiditate autem necessitatibus <br/> quaerat adipisci sunt laborum dolore, placeat magnam cumque?</p>
            <button>Request an Appoinment</button>
            <div className='expertise'>
                <div>
                    30+ <span></span>
                    <p>Years of Experience</p>
                </div>
                <div>
                    15+ <span style={{backgroundColor:"#7D53C5"}}></span>
                    <p>Clinic Location</p>
                </div>
                <div>
                    100% <span style={{backgroundColor:"#0091A0"}}></span>
                    <p>Patient Satisfaction</p>
                </div>
            
            </div>
        </div>
        <div className='grid_image_wrapper'>
            <img className='grid_image' src={grid_image_doctors} alt="grid images of doctors" />
        </div>
    </div>
    </div>
  )
}

export default Home