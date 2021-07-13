import React from "react";
import s from "./CarEvents.module.css"
import PostEventContainer from "./PostEvent/PostEventContainer";
import * as axios from 'axios'
import CarEventRefueling from "./Event/CarEventRefueling";
import CarEventMaintenance from "./Event/CarEventMaintenance";

const CarEvents = (store) => {
  let events = store.autoEvents;

  if (events.list.length === 0) {
    axios.get("http://localhost:8080/services/listEvents"
      // , {headers: {
      //     'Accept': 'application/json',
      //     'Content-Type': 'application/json',
      //     "Access-Control-Allow-Origin": "*",
      //    // "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
      //    // "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
        // },}
    ).then(response => {
      store.setEvents(response.data.content);
    })
    // store.setEvents([
    //   {
    //     eventDate: "05.02.2021",
    //     mileage: 230145,
    //     pscPrice: 45,
    //     value: 33.3,
    //     price: 1500,
    //     arrageValue: 15.5
    //   },
    //   {
    //     eventDate: "10.02.2021",
    //     mileage: 230679,
    //     pscPrice: 45.30,
    //     value: 12.0,
    //     price: 543.60,
    //     arrageValue: 21.0
    //   }
    // ])
  }

  let EventElements = events.list.map(item => {
    switch (item.autoEventType)
    {
      case "MAINTENANCE":
        return <CarEventMaintenance carEvent={item}/>
      case "REFUELING":
        return <CarEventRefueling carEvent={item}/>
    }

  });

  return <div className={s.carEvents}>
    <PostEventContainer/>
    {EventElements}
  </div>
}

export default CarEvents;