import React from "react";
import s from "./Navbar.module.css";
import {NavLink} from "react-router-dom";

const Navbar = () => {
  return (
    <div className={s.nav}>
      <div className={s.item}>
        <NavLink to="/events" className={s.item} activeClassName={s.active}>cars</NavLink>
      </div>
      <div className={s.item}>
        <NavLink to="/settings" className={s.item} activeClassName={s.active}>settings</NavLink>
      </div>
    </div>
  )
}

export default Navbar;