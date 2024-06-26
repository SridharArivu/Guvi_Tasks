import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import './App.css';
import { useEffect, useState } from "react";
import Home from "./pages/Home/Home";
import Navbar from "./components/NavBar/Navbar";


function App() {
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  
  return (
    <Router>
      <Navbar handleShow={handleShow}/>
      <Routes>
      <Route path="/" element={
        <Home 
          show={show}
          handleShow={handleShow}
          handleClose={handleClose}
          />} 
        />
      </Routes>
    </Router>
  );
}

export default App;
