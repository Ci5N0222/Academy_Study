import styles from './Main.module.css'
import {useMemberStore} from "../../../../store/store";
import image  from '../../../../images/logo.png';
import {Modal} from "../../../Modal/Modal";
import {useState} from "react";
export const Main = () => {

  const { user } = useMemberStore();

  const handleMypage = () => {
    openModal();
  }

  const [ isModalOpen, setIsModalOpen ] = useState(false);
  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  return (
    <div className={styles.container}>
      <div className={styles.col}>
        <div className={styles.myInfo}>
          <div className={ styles.imgBox }>
            <img src={ image } alt="avatar" />
          </div>
          <div className={styles.userInfo}>
            <p>환영합니다 { user.name }님</p>
            <button onClick={ handleMypage }>상세 정보</button>
          </div>
        </div>
        <div className={styles.attendance}>
          근태
        </div>
        <div className={styles.todo}>Todo List</div>
      </div>
      <div className={styles.col}>
        <div className={styles.review}>
          뭐 넣지?
        </div>
      </div>


      {/* 마이페이지 모달 */}
      <Modal isOpen={ isModalOpen } onClose={ closeModal }>
        <div className={styles.modal_form}>
          {/* 내용 작성 */}
          상세 정보 및 수정 가능한 내용 넣어야 됨
          <div className={styles.btnBox}>
            <button>정보 수정</button>
            <button onClick={closeModal}>취소</button>
          </div>
        </div>
      </Modal>

    </div>
  );
}