import styles from './Main.module.css'
import {SideMenu} from "./SideMenu/SideMenu";
import {Content} from "./Content/Content";
import {Route, Routes} from "react-router-dom";
import {useBoard, useCafe, useMember} from "../../store/store";

export const Main = () => {

  const { memberKeys, member, members, addMember } = useMember();
  const { menus } = useCafe();
  const { board } = useBoard();

  return (
    <div className={styles.main}>
      <SideMenu />
      <Routes>
        <Route path="/member/*" element={ <Content type={"member"} /> } />
        <Route path="/cafe/*" element={ <Content type={"cafe"} /> } />
        <Route path="/board/*" element={ <Content type={"board"} /> } />
      </Routes>

    </div>
  );
}