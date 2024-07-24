import styles from './Loading.module.css'
import loading from '../../images/0004.gif';

export const Loading = () => {
  return (
    <div className={styles.container}>
      <img src={ loading } alt=""/>
    </div>
  );
}