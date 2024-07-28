import './App.css';
import React, {useState} from "react"
import { HiMenuAlt3 } from 'react-icons/hi';
import { MdOutlineDashboard } from "react-icons/md";
import {RiSettings4Line} from "react-icons/ri";
import {AiOutlineHeart, AiOutlineUser} from "react-icons/ai";
import {FiFolder, FiMessageSquare, FiShoppingCart} from "react-icons/fi";
import {TbReportAnalytics} from "react-icons/tb";
import {Side} from "./components/Side/Side";

function App() {


  const [open, setOpen] = useState(true);

  return (
    <div className="container">
      <Side open={open} setOpen={setOpen} />
      <div className="header">
        React Side Bar
      </div>
    </div>
  );
}

export default App;
