import './App.css';
import {useEffect, useState} from "react";
import axios from "axios";
import {useAuthStore} from "./store/store";
import {jwtDecode} from "jwt-decode";
import {host, api} from "./config/config";


const Login = () => {
  const { login } = useAuthStore();

  const [user, setUser] = useState({id:"", pw:""})

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser(prev => ({ ...prev, [name] : value }));
  }

  const handleLogin = () => {
    axios.post(`${host}/user`, user).then(res => {
      const token = res.data;

      // token의 속성을 json 형식으로 파싱
      const decoded = jwtDecode(token)
      console.log("decoded ===== ", decoded);
      console.log("decoded.sub ===== ", decoded.sub);

      console.log("token ===== ", token);
      sessionStorage.setItem("token", token);
      login(token);
    }).catch(res => alert("Error : ", res));
  }

  return (
    <>
      <fieldset>
        <legend>
          Login
        </legend>
        <input type="text" name="empId" placeholder="ID를 입력하세요" onChange={handleChange}/><br/>
        <input type="text" name="empPw" placeholder="Password를 입력하세요" onChange={handleChange}/><br/>
        <button onClick={handleLogin}>Login</button>
      </fieldset>
    </>
  );
}

const Home = () => {
  const { token, logout } = useAuthStore();

  const handleLogout = () => {
    sessionStorage.removeItem("token");
    logout();
  }

  const handleGetMessage = () => {
    api.get(`/message`).then(res => {
      console.log("Result : ", res.data);
    }).catch(err => {
      console.log(err);
    });

  }

  return (
    <fieldset>
      <legend>
        Home
      </legend>
      <button onClick={handleLogout}>logout</button><br />
      <button onClick={handleGetMessage}>get message</button>
    </fieldset>
  );
}

function App() {
  const {login, isAuth} = useAuthStore();

  useEffect(() => {
    const token = sessionStorage.getItem("token");
    if (token !== null) {
      login(token);
    }
  }, []);

  return (
    <div className="App">
      {isAuth ? <Home /> : <Login />}
    </div>
  );
}

export default App;
