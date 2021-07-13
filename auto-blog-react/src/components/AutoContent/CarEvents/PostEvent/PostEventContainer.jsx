import react from 'react';
import PostEvent from "./PostEvent";
import {connect} from "react-redux";
import {
  acAddPost,
  acSetMileage,
  acSetPrice,
  acSetPscPrice,
  acSetValue
} from "../../../../redux/auto-event-reducer";

let mapStateToProps = (state) => ({
  autoEvent: state.autoEvents,
});

let mapDispatchToProps = (dispatch) => {
  return {
    addAutoEvent: () => {
      dispatch(acAddPost());
    },
    setMileage: (mileage) => {
      dispatch(acSetMileage((mileage)));
    },
    setPscPrice: (pscPrice) => {
      dispatch(acSetPscPrice(pscPrice));
    },
    setValue: (value) => {
      dispatch(acSetValue(value));
    },
    setPrice: (price) => {
      dispatch(acSetPrice(price));
    },
  }
}

const PostEventContainer = connect(mapStateToProps, mapDispatchToProps)(PostEvent)

export default PostEventContainer;