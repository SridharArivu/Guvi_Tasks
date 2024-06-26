import React from 'react'
import './Navbar.css'
import { FaReact } from "react-icons/fa";
import { IoSearch } from "react-icons/io5";
import { MdPersonAddAlt1 } from "react-icons/md";

const Navbar = ({handleShow}) => {
  return (
    <div className='Navbar_wrapper'>
        < FaReact className='logo'/>
        <p>Logo</p>
        
       <button onClick={() => handleShow()} className='add_new_btn'><MdPersonAddAlt1 className='add_new_icon'/>Add New Employee</button>
    </div>
  )
}

export default Navbar