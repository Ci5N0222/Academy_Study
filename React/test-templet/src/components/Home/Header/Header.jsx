import styles from './Header.module.css'
import {useMemberStore} from "../../../store/store";

export const Header = () => {

  const { setSign, user } = useMemberStore();

  const handleSignOut = () => {
    sessionStorage.setItem("sessionId", "");
    sessionStorage.setItem("sessionName", "");
    setSign(false);
  }

  return (
    <div className={styles.container}>
      <div className={styles.form}>
        <div></div>
        <div className={styles.userInfo}>
          <button onClick={ handleSignOut }>Sign-Out</button>
          <p className={styles.userName}>{ user.name }</p>
          <div className={styles.userAvatar}>Noh</div>
        </div>
      </div>
    </div>
  );
}