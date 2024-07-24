import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Index } from './components/Index/Index';
import { SignUp } from './components/SignUp/SignUp';
import { useAuthStore } from './store/store';
import React, {useEffect, useState} from 'react';
import {Loading} from "./commons/Loading/Loading";
import {Mypage} from "./components/Index/Mypage/Mypage";
import axios from "axios";

// axios가 요청을 보낼 때 쿠키 값을 요청해서 전송하는 설정
axios.defaults.withCredentials = true;

function App() {
  const userId = sessionStorage.getItem("sessionID");
  const { loginID, setLoginID } = useAuthStore();
  const [ isLoading, setIsLoading ] = useState(true);

  // 마운팅 되는 시점, 언마운팅 되는 시점 그리고 개발자가 정하는 특정 시점에만 실행되는 코드를 작성
  useEffect(() => {
    // 마운팅 되는 시점에 실행하고 싶은 코드 입력
    setLoginID(userId);

    return () => {
      // 언마운팅 되는 시점에 실행하고 싶은 코드 입력
    }
  }, []);

  useEffect(() => {
    setIsLoading(false);

  }, [loginID]);

  if(isLoading){
    return <Loading />
  } else {
    return (
      <div className="container">
        <Router>
          <Routes>
            <Route path="/" element={<Index />} />
            <Route path='/member/signup' element={<SignUp />} />
            <Route path="/mypage/*" element={ <Mypage /> }/>
          </Routes>
        </Router>
      </div>
    );
  }


}

export default App;
