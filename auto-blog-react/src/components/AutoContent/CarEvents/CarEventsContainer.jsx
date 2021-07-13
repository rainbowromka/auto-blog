import {connect} from "react-redux";
import CarEvents from "./CarEvents";
import {acSetEvents} from "../../../redux/auto-event-reducer";

let mapSateToProps = (state) => ({
  autoEvents: state.autoEvents
})

let mapDispatchToProps = (dispatch) => {
  return {
    setEvents: (list) => {
      dispatch(acSetEvents(list))
    }
  }
}

const CarEventsContainer = connect(mapSateToProps, mapDispatchToProps)(CarEvents)

export default CarEventsContainer;