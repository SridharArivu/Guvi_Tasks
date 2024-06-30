import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Navbar from "./Components/navbar/Navbar";
import Home from "./pages/Home/Home";
import Register from "./pages/Register/Register"
import Login from "./pages/Login/Login"
import FindDoctor from "./pages/FindDoctor/FindDoctor";
import Profile from "./pages/Profile/Profile";


function App() {
  return (
    <Router>
      <Navbar/>
              <Routes>
                <Route path="/register" element={<Register/>} />
                <Route path="/login" element={<Login/>} />
                <Route path="/" element={<Home/>} />
                <Route path="/find-doctor" element={<FindDoctor/>} />
                <Route path="/profile" element={<Profile/>} />
              </Routes>
        </Router>
  );
}

export default App;
