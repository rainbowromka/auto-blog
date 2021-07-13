import React from "react";
import s from "./Header.module.css";

const Header = () => {
  return (<div className={s.header}>
      <img src="content\Logo.png"/>
      {/*<div>menu</div>*/}
    </div>
  )
}

export default Header;