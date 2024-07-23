import './App.css';
import { Login } from './components/Login/Login';
import {SideMenu} from "./components/SideMenu/SideMenu";
import {Home} from "./components/Home/Home";
import {BrowserRouter as Router} from "react-router-dom";
import {useState} from "react";

function App() {
  const [ user, setUser ] = useState(false);
  return (
    <div className="container">
      <Router>
        { user === false && <Login login={ setUser }/> }
        { user === true && <SideMenu />  }
        { user === true && <Home /> }
      </Router>
    </div>
  );
}

export default App;
