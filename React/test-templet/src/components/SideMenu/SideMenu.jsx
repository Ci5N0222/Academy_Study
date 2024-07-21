import styles from './SideMenu.module.css';
import logo from '../../logo.svg'
import {useNavigate} from "react-router-dom";

export const SideMenu = () => {

  const navi = useNavigate();

  return (
    <div className={ styles.navgation }>
      <img src={logo} alt="logo" />
      <button onClick={()=>{navi("/")}}>Home</button>
      <button onClick={()=>{navi("mail")}}>Mail</button>
      <button onClick={()=>{navi("address")}}>Address</button>
      <button onClick={()=>{navi("community")}}>Community</button>
      <button onClick={()=>{navi("calendar")}}>Calendar</button>
    </div>
  )

}