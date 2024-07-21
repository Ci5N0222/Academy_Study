import styles from './Content.module.css'
import {Main} from "./Main/Main";
import {Route, Routes} from "react-router-dom";
import {Calendar} from "./Calendar/Calendar";

export const Content = () => {

  return(
    <div className={styles.container}>
      <div className={styles.form}>
        <Routes>
          <Route path="/" element={ <Main /> } />
          <Route path="/calendar/*" element={ <Calendar /> } />
        </Routes>

      </div>
    </div>
  );
}