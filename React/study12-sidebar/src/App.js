import './App.css';
import React, {useState} from "react"
import { HiMenuAlt3 } from 'react-icons/hi';
import { MdOutlineDashboard } from "react-icons/md";
import {RiSettings4Line} from "react-icons/ri";
import {AiOutlineHeart, AiOutlineUser} from "react-icons/ai";
import {FiFolder, FiMessageSquare, FiShoppingCart} from "react-icons/fi";
import {TbReportAnalytics} from "react-icons/tb";

function App() {

  const menus = [
    {name: "dashboard", link: "/", icon: MdOutlineDashboard},
    {name: "User", link: "/", icon: AiOutlineUser},
    {name: "Messages", link: "/", icon: FiMessageSquare},
    {name: "Analytics", link: "/", icon: TbReportAnalytics, margin: true},
    {name: "File Manager", link: "/", icon: FiFolder},
    {name: "Cart", link: "/", icon: FiShoppingCart},
    {name: "Saved", link: "/", icon: AiOutlineHeart, margin: true},
    {name: "Setting", link: "/", icon: RiSettings4Line},
  ]

  const [open, setOpen] = useState(true);

  return (
    <div className="container">
      <div className={ open ? "side-full" : "side-short"}>
        <div className="toggle">
          <HiMenuAlt3 size={30} className="icons" onClick={() => setOpen(!open)} />
        </div>
        <div className="menus">
          {
            menus.map((menu, i) => {
              return (
                <a href={menu?.link} key={i} className="menu-link">
                  <div>
                    {React.createElement(menu?.icon, {size: "30"})}
                  </div>
                  <h3 className={open ? "menu-title" : "menu-title-action"}>{menu?.name}</h3>
                </a>
              );
            })
          }
        </div>
      </div>
      <div className="heder">
        React Side Bar
      </div>
    </div>
  );
}

export default App;
