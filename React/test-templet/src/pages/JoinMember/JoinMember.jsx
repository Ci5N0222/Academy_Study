import { useState } from "react";
import styles from "./JoinMember.module.css";

export const JoinMember = () => {

  const [ exists, setExists ] = useState();

  return (
    <div className={styles.container}>
      <div className={styles.join_form}>
        <label for="id">ID </label>
        <input type="text" id="id" placeholder="아이디를 입력하세요" />
        <p> </p>
      </div>
    </div>
  );
};
