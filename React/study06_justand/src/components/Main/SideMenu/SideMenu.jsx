import styles from './SideMenu.module.css'
import {useNavigate} from "react-router-dom";

export const SideMenu = () => {

  const navi = useNavigate();

   return (
     <div className={styles.sidemenu}>
       <div className={styles.menu} onClick={ () => navi("member") } >회원 관리</div>
       <div className={styles.menu} onClick={ () => navi("cafe") } >카페메뉴 관리</div>
       <div className={styles.menu} onClick={ () => navi("board") } >게시글</div>
     </div>
   );
}