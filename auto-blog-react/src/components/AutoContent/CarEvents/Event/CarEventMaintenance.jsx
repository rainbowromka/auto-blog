import React from "react";
import s from "./CarEvent.module.css"

const CarEventMaintenance = (props) => {
  let carEvent = props.carEvent
  return (
    <div className={s.carEvent}>
        <h3>Техническое обслуживание</h3>
        <span>
          <div className={s.eventDate}>{carEvent.eventDate}</div>
          <div className={s.mileage}>{carEvent.mileage} км</div>
        </span>
        <span>
          /\
        </span>
        <span>
          <div className={s.price}>{carEvent.price} р.</div>
          <div>{carEvent.comment}</div>
        </span>
        <span>
          <button>delete</button>
          <button>edit</button>
        </span>
      </div>
  )
}

export default CarEventMaintenance;