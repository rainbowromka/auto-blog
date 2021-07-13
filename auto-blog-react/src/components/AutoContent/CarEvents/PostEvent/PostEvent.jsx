import react from 'react';
import s from './PostEvent.module.css';

const PostEvent = (props) => {
  let autoEvents = props.autoEvent;

  let eventMileageRef = react.createRef();
  let eventPscPriceRef = react.createRef();
  let eventValueRef = react.createRef();
  let eventPriceRef = react.createRef();

  let onAddAutoEvent = () => {
    props.addAutoEvent();
  }

  let onChangeMileage = () => {
    props.setMileage(eventMileageRef.current.value);
  }

  let onChangePscPrice = () => {
    props.setPscPrice(eventPscPriceRef.current.value);
  }

  let onChangeValue = () => {
    props.setValue(eventValueRef.current.value);
  }

  let onChangePrice = () => {
    props.setPrice(eventPriceRef.current.value);
  }

  return <div className={s.form}>
    <h4>Добавить новое событие</h4>
    <div>
      <label>Пробег</label>
      <input onChange={onChangeMileage} ref={eventMileageRef} placeholder="км" value={autoEvents.mileage}/>
    </div>
    <div>
      <label>Цена за литр</label>
      <input onChange={onChangePscPrice} ref={eventPscPriceRef} placeholder="руб" value={autoEvents.pscPrice}/>
    </div>
    <div>
      <label>Заправлено</label>
      <input onChange={onChangeValue} ref={eventValueRef} placeholder="литров" value={autoEvents.value}/>
    </div>
    <div>
      <label>Итого:</label>
      <input onChange={onChangePrice} ref={eventPriceRef} placeholder="руб" value={autoEvents.price}/>
    </div>
    <div>
      <button onClick={onAddAutoEvent}><b>Добавить событие</b></button>
    </div>
  </div>

}

export default PostEvent;