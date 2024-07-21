import styles from './Content.module.css'
import {Navigate, Route, Routes, useNavigate} from "react-router-dom";
import {Add} from './Add/Add';
import {List} from "./List/List";
import {Delete} from "./Delete/Delete";
import {Modify} from "./Modify/Modify";

export const Content = ({ type }) => {

  const navi = useNavigate();

  return (
    <div className={styles.container}>
      <div className={styles.tabs}>
        <div className={styles.tab} onClick={() => navi("list")}>List</div>
        <div className={styles.tab} onClick={() => navi("add")}>Add</div>
        <div className={styles.tab} onClick={() => navi("modify")}>Modify</div>
        <div className={styles.tab} onClick={() => navi("delete")}>Delete</div>
      </div>
      <div className={styles.content}>
        <Routes>
          <Route path="" element={<Navigate to="list" />}/>
          <Route path="list" element={<List type={type} />}/>
          <Route path="add" element={<Add type={type} />}/>
          <Route path="modify" element={<Modify type={type} />}/>
          <Route path="delete" element={<Delete type={type} />}/>
        </Routes>
      </div>
    </div>
  );
}