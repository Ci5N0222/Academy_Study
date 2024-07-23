import styles from './Login.module.css';
import logo from '../../test_logo.png';
import {Modal} from "../Modal/Modal";
import { useState } from "react";
import {useMemberStore} from "../../store/store";
import { signInAPI } from '../../api/api';

export const Login = ({ login }) => {

  const { setSign, setUser } = useMemberStore();

  const [ modalState, setModalState ] = useState("");

  const [ isModalOpen, setIsModalOpen ] = useState(false);

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  const handleSignIn = async () => {
    const res = await signInAPI();
    if(res.status === 200 && res.data.id !== "") {
      sessionStorage.setItem("sessionId", res.data.id);
      sessionStorage.setItem("sessionName", res.data.name);
      setUser(res.data);
      console.log("data === ", JSON.stringify(res.data));
      setSign(true);
    } else {
      alert("로그인 실패");
    }
  }

  const handleSignUp =  async () => {
    setModalState("SignUp");
    openModal();
  }

  const handleFindId = () => {
    setModalState("FindId");
    openModal();
  }

  const handleFindPw = () => {
    setModalState("FindPw");
    openModal();
  }
  
  return (
    <div className={ styles.container }>
      <div className={ styles.signin_box }>
        <img src={ logo } alt="logo"/>
        <input type="text" placeholder='ID' />
        <input type="password" placeholder='Password' />
        <div className={ styles.check_box }>
          <input type="checkbox" id="id_svae"/>
          <label for="id_save"> 아이디 저장 </label>
        </div>
        <button onClick={ handleSignIn }>로그인</button>
        <div className={styles.sign_href}>
          <button onClick={handleSignUp}>회원가입</button>
          <button onClick={handleFindId}>아이디 찾기</button>
          <button onClick={handleFindPw}>비밀번호 찾기</button>
        </div>
      </div>
      {modalState === "SignUp" &&
        <Modal isOpen={ isModalOpen } onClose={ closeModal }>
          <div className={styles.modal_form}>
            {/* 내용 작성 */}
            회원가입 내용 넣어야됨
            <button onClick={ closeModal }>Close</button>
          </div>
        </Modal>
      }
      { modalState === "FindId" &&
        <Modal isOpen={ isModalOpen } onClose={ closeModal }>
          <div className={styles.modal_form}>
            {/* 내용 작성 */}
            아이디 찾기 내용 넣어야됨
            <button onClick={ closeModal }>Close</button>
          </div>
        </Modal>
      }
      { modalState === "FindPw" &&
        <Modal isOpen={ isModalOpen } onClose={ closeModal }>
          <div className={styles.modal_form}>
            {/* 내용 작성 */}
            비밀번호 찾기 찾기 내용 넣어야됨
            <button onClick={ closeModal }>Close</button>
          </div>
        </Modal>
      }


    </div>
  );
}