import { useNavigate } from "react-router-dom";
import styles from "./Index.module.css";
import { useState } from "react";
import axios from "axios";
import { useAuthStore } from "../../store/store";

export const Index = () => {

  const navi = useNavigate();
  const { loginID, setLoginID } = useAuthStore();

  const defaultData = { id: "", pw: "" };
  const [ signData, setSignData ] = useState(defaultData);

  const handleData = (e) => {
    const { name, value } = e.target;
    setSignData(prev => ({ ...prev, [name]: value }));
  }

  const handleSignIn = async() => {
    try{
      const res = await axios.post("http://192.168.1.7/auth", signData);
      if(res.status === 200 && res.data !== ""){

        // 상태관리 라이브러리로 데이터를 보관할 경우 페이지가 새로고침되면 초기화 된다.
        setLoginID(res.data);

        // 새로고침 시에도 세션 데이터를 갖고 있기 위해 session storage 사용
        sessionStorage.setItem("sessionID", res.data);

        alert("로그인 성공");
      } else {
        alert("로그인 실패");
      }
    } catch(e) {
        console.log("Error : ", e);
        alert("로그인 실패");
    }
  }

  return (
    <div className={styles.container}>
      {
        loginID === "" ?
        <table>
          <thead>
            <tr>
              <th>로그인</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><input type="text" name="id" onChange={ handleData } placeholder="Input ID" /></td>
            </tr>
            <tr>
              <td><input type="text" name="pw" onChange={ handleData } placeholder="Input Password" /></td>
            </tr>
            <tr>
              <td>
                <button onClick={ handleSignIn }>로그인</button>
                <button onClick={ () => navi("/member/signup") }>회원가입</button>
              </td>
            </tr>
          </tbody>
        </table>
        :
        <div>
          <h2> { loginID }님 환영합니다</h2>
          <button onClick={ () => setLoginID("")}>로그아웃</button>
        </div>
      }
    </div>
  );
};
