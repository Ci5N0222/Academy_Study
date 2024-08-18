import './App.css';
import React, {useEffect, useState} from "react"
import {Side} from "./components/Side/Side";

function App() {


  const [open, setOpen] = useState(true);

    useEffect(() => {
        /* Side-Bar toggle */
        if(localStorage.getItem("sidebar") === "true") setOpen(true);
        else setOpen(!open); 
    }, []);

  return (
    <div className="container">
      <Side open={open} setOpen={setOpen} />
      <div className="header">
        React Side Bar practice
        반응형 실습
      </div>
    </div>
  );
}

export default App;
