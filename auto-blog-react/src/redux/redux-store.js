import {combineReducers, createStore} from "redux"
import autoEventReducer from "./auto-event-reducer";

let store = createStore(combineReducers({
  autoEvents: autoEventReducer,
}));

export default store;