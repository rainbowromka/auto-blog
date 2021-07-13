const ADD_AUTO_EVENT = "ADD_AUTO_EVENT";
const SET_MILEAGE = "SET_MILEAGE";
const SET_PSCPRICE = "SET_PSCPRICE";
const SET_VALUE = "SET_VALUE";
const SET_PRICE = "SET_PRICE";
const SET_EVENTS = "SET_EVENTS";

let initialState = {
  list: [],
    mileage: "",
    pscPrice: "",
    value: "",
    price: "",
}

const autoEventReducer = (state = initialState, action) => {
  switch (action.type) {
    case ADD_AUTO_EVENT: {
      let d = new Date();
      return {
        ...state, list: [...state.list, {
          eventDate: d.getFullYear() + "-" + ("0" + (d.getMonth() + 1)).slice(-2) + "-" + ("0" + d.getDate()).slice(-2),
          mileage: state.mileage,
          pscPrice: state.pscPrice,
          value: state.value,
          price: state.pscPrice * state.value,
          arrageValue: 15.7,
        }],
        mileage: "",
        pscPrice: "",
        value: "",
        price: ""
      };
    }
    case SET_MILEAGE: {
      return {
        ...state,
        mileage: action.value,
      };
    }
    case SET_PSCPRICE: {
      state.pscPrice = action.value;
      if (state.value) {
        state.price = state.pscPrice *
          state.value;
      }
      return {...state};
    }
    case SET_VALUE: {
      state.value = action.value;
      if (state.pscPrice) {
        state.price = state.pscPrice *
          state.value;
      }
      return {...state};
    }
    case SET_PRICE: {
      state.price = action.value;
      return {...state};
    }
    case SET_EVENTS: {
      return {...state, list: [...state.list, ...action.list]}
    }
    default:
      return state;
  }
}

export const acAddPost = () => ({type: ADD_AUTO_EVENT});

export const acSetMileage = (mileage) => ({type: SET_MILEAGE, value: mileage});

export const acSetPscPrice = (pscPrice) => ({type: SET_PSCPRICE,
  value: pscPrice});

export const acSetValue = (value) => ({type: SET_VALUE, value: value});

export const acSetPrice = (price) => ({type: SET_PRICE, value: price});

export const acSetEvents = (list) => ({type: SET_EVENTS, list})

export default autoEventReducer;