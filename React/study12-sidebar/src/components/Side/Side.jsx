import styles from './Side.module.css'
import {HiMenuAlt3} from "react-icons/hi";
import React from "react";
import {MdOutlineDashboard} from "react-icons/md";
import {AiOutlineHeart, AiOutlineUser} from "react-icons/ai";
import {FiFolder, FiMessageSquare, FiShoppingCart} from "react-icons/fi";
import {TbReportAnalytics} from "react-icons/tb";
import {RiSettings4Line} from "react-icons/ri";

export const Side = ({open, setOpen}) => {

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

    const handleSideTogle = () => {
        setOpen( prev => {
            const sideState = !prev
            if(sideState) localStorage.setItem("sidebar", "true");
            else localStorage.setItem("sidebar", "false");
            return sideState
        })

    }

    return (
        <div className={styles.container}>
            <div className={open ? styles.sideFull : styles.sideShort}>
                <div className={styles.toggle}>
                    <HiMenuAlt3 size={30} className="icons" onClick={handleSideTogle}/>
                </div>
                <div className={styles.menus}>
                    {
                        menus.map((menu, i) => {
                            return (
                                <a href={menu?.link} key={i} className={styles.menuLink}>
                                    <div>
                                        {React.createElement(menu?.icon, {size: "30"})}
                                    </div>
                                    <h3 className={open ? styles.menuTitle : styles.menuTitleAction }>{menu?.name}</h3>
                                </a>
                            );
                        })
                    }
                </div>
            </div>
        </div>
    );
}