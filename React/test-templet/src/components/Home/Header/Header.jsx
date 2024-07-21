import styles from './Header.module.css'

export const Header = () => {
  return (
    <div className={styles.container}>
      <div className={styles.form}>
        <div></div>
        <div className={styles.userInfo}>
          <p className={styles.userName}>노시온</p>
          <div className={styles.userAvatar}>Noh</div>
        </div>
      </div>
    </div>
  );
}