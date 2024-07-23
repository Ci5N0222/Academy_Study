import './App.css';
import { Login } from './components/Login/Login';
import {SideMenu} from "./components/SideMenu/SideMenu";
import {Home} from "./components/Home/Home";
import {BrowserRouter as Router} from "react-router-dom";
import {useEffect, useState} from "react";
import {useMemberStore} from "./store/store";

function App() {
  const userId = sessionStorage.getItem("sessionId");
  const userName = sessionStorage.getItem("sessionName");
  const {sign, setSign, setUser} = useMemberStore();
  useEffect(() => {
    setUser({id: userId, name: userName});
    if(userId !== "") setSign(true);
  }, []);

  return (
    <div className="container">
      <Router>
        { !sign && <Login /> }
        { sign && <SideMenu />  }
        { sign && <Home /> }
      </Router>
    </div>
  );
}

export default App;
