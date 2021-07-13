import autoEventReducer from "./auto-event-reducer";

// const ADD_AUTO_EVENT = "ADD_AUTO_EVENT";
// const SET_MILEAGE = "SET_MILEAGE";
// const SET_PSCPRICE = "SET_PSCPRICE";
// const SET_VALUE = "SET_VALUE";
// const SET_PRICE = "SET_PRICE";

// let store = {
//   _autoEvents: {
//     list: [
//       {
//         eventDate: "05.02.2021",
//         mileage: 230145,
//         pscPrice: 45,
//         value: 33.3,
//         price: 1500,
//         arrageValue: 15.5
//       },
//       {
//         eventDate: "10.02.2021",
//         mileage: 230679,
//         pscPrice: 45.30,
//         value: 12.0,
//         price: 543.60,
//         arrageValue: 21.0
//       }
//     ],
//     mileage: "",
//     pscPrice: 0,
//     value: 0,
//     price: 0,
//   },
//   _renderEntireTree () {},
//   getAutoEventsState() {
//     return this._autoEvents;
//   },
//   subscribe(observer) {
//     this._renderEntireTree = observer;
//   },
//   dispatch(action) {
//     this._autoEvents = autoEventReducer(this._autoEvents, action);
//     this._renderEntireTree(this);
//   }
// };

// export default store;