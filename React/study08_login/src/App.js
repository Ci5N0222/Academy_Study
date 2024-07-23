import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Index } from './components/Index/Index';
import { SignUp } from './components/SignUp/SignUp';
import { useAuthStore } from './store/store';
import { useEffect } from 'react';




function App() {
  const user = sessionStorage.getItem("sessionID");
  const { setLoginID } = useAuthStore();

  // 마운팅 되는 시점, 언마운팅 되는 시점 그리고 개발자가 정하는 특정 시점에만 실행되는 코드를 작성
  useEffect(() => {
    // 마운팅 되는 시점에 실행하고 싶은 코드 입력
    setLoginID(user);

    return () => {
      // 언마운팅 되는 시점에 실행하고 싶은 코드 입력
    }
  }, []);

  return (
    <div className="container">
      <Router>
        <Routes>
          <Route path="/" element={<Index />} />
          <Route path='/member/signup' element={<SignUp />} />
        </Routes>
      </Router>
    </div>  
  );
}

export default App;
