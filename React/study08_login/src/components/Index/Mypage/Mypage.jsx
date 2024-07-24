import styles from './Mypage.module.css'
import {useAuthStore} from "../../../store/store";
import {useNavigate} from "react-router-dom";
import {useEffect} from "react";
import axios from "axios";

export const Mypage = () => {

  const navi = useNavigate();

  const { loginID, userInfo, setUserInfo } = useAuthStore();

  const handleChangeInfo = () => {
    // 업데이트 폼으로 변경
  }

  const handleMyInfo = async () =>{
    const res = await axios.get(`http://192.168.1.7/member/${loginID}`);
    setUserInfo(res.data)
  }
  
  useEffect(() => {
    handleMyInfo();
  }, []);
  
  return (
    <div className={styles.container}>
      <p> 마 이 페 이 지 </p>
      id : { userInfo.id } <br />
      name : { userInfo.name } <br />
      <div>
        <button onClick={handleChangeInfo}>수정</button>
        <button onClick={ ()=>{ navi("/")} }>취소</button>
      </div>
    </div>
  );
}