import styles from './Main.module.css'
import {SideMenu} from "./SideMenu/SideMenu";
import {Content} from "./Content/Content";
import {Route, Routes} from "react-router-dom";
import {Default} from "./Default/Default";

export const Main = () => {
  
  return (
    <div className={styles.main}>
      <SideMenu />
      <Routes>
        <Route path="/" element={ <Default /> } />
        <Route path="/member/*" element={ <Content type={"member"} /> } />
        <Route path="/cafe/*" element={ <Content type={"cafe"} /> } />
        <Route path="/board/*" element={ <Content type={"board"} /> } />
      </Routes>
    </div>
  );
}