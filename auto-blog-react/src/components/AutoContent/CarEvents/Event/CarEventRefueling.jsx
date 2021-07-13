import React from "react";
import s from "./CarEvent.module.css"

const CarEventRefueling = (props) => {
  let carEvent = props.carEvent
  return (
    <div className={s.carEvent}>
        <h3>Заправка</h3>
        <span>
          <div className={s.eventDate}>{carEvent.eventDate}</div>
          <div className={s.mileage}>{carEvent.mileage} км</div>
        </span>
        <span>
          /\
        </span>
        <span>
          <div className={s.pscPrice}>{carEvent.pscPrice} р./л.</div>
          <div className={s.value}>{carEvent.value} л.</div>
        </span>
        <span>
          /\
        </span>
        <span>
          <div className={s.price}>{carEvent.price} р.</div>
          <div className={s.arrageValue}>{carEvent.arrageValue} л./100 км.</div>
          <div>Полный бак <input name="isFull" type="checkbox" checked={carEvent.isFull}></input></div>
        </span>
        <span>
          <button>delete</button>
          <button>edit</button>
        </span>
      </div>
  )
}

export default CarEventRefueling;