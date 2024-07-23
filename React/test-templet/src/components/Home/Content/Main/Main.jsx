import styles from './Main.module.css'
import {useMemberStore} from "../../../../store/store";

export const Main = () => {

  const { user } = useMemberStore();

  return (
    <div className={styles.container}>
      <div className={styles.col}>
        <div className={styles.myInfo}>
          <div className={ styles.imgBox }>
            NOH
          </div>
          <div className={styles.userInfo}>
            <p>환영합니다 { user.name }님</p>
            <button>정보 수정</button>
          </div>
        </div>
        <div className={styles.attendance}>근태</div>
        <div className={styles.todo}>Todo List</div>
      </div>
      <div className={styles.col}>
        <div className={styles.review}>
          뭐 넣지?
        </div>
      </div>
    </div>
  );
}