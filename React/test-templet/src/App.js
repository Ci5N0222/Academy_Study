import './App.css';
import { Login } from './pages/Login/Login';
import {SideMenu} from "./components/SideMenu/SideMenu";
import {Home} from "./components/Home/Home";
import {BrowserRouter as Router} from "react-router-dom";

function App() {
  const user = true;
  return (
    <div className="container">
      <Router>
        { user === false && <Login /> }
        { user === true && <SideMenu />  }
        { user === true && <Home /> }
      </Router>
    </div>
  );
}

export default App;
