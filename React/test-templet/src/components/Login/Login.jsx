import styles from './Login.module.css';
import logo from '../../test_logo.png';
import {Modal} from "../Modal/Modal";
import { useState } from "react";

export const Login = ({ login }) => {

  const [ isModalOpen, setIsModalOpen ] = useState(false);
  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

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
        <button onClick={ () => login(true) }>로그인</button>
        <div className={ styles.sign_href }>
          <a href="#">회원가입</a>
          <a href="#">아이디 찾기</a>
          <a href="#">비밀번호 찾기</a>
        </div>
      </div>

      <Modal isOpen={ isModalOpen } onClose={ closeModal }>
        <div className=''>
          {/* 내용 작성 */}
          <button onClick={ closeModal }>Close</button>
        </div>
      </Modal>

    </div>
  );
}