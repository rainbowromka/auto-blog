import React from "react";
import s from "./AutoContent.module.css"
import CarEventsContainer from "./CarEvents/CarEventsContainer";

const AutoContent = (props) => {
  return (
    <div className={s.autoContent}>
      <div className={s.cars}>
        <span>Ist</span>
        <span>Surf</span>
      </div>
      <CarEventsContainer/>
    </div>
  )
}

export default AutoContent;