import styles from './Navigator.module.css';

export const Navigator = () => {
  return (
    <div className={ styles.navgation }>
      <img src="/images/logo.png" alt="logo" />
      <button>Home</button>
      <button>Mail</button>
      <button>Address</button>
      <button>Community</button>
      <button>Calendar</button>
    </div>
  )
}