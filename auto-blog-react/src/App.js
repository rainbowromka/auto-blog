import './App.css';
import Header from "./components/Header/Header";
import Footer from "./components/Footer/Footer";
import Navbar from "./components/NavBar/Navbar";
import {BrowserRouter, Route} from "react-router-dom";
import AutoContent from "./components/AutoContent/AutoContent";
import Settings from "./components/Settings/Settings";


function App(props) {

  return (
    <div className="app-wrapper">
      <Header/>
      <Navbar/>
      <div className="autoContent">
        <Route path='/events' render={() =>
          <AutoContent/>}/>
        <Route path='/settings' render={() =>
          <Settings/>}/>
      </div>
      <Footer/>
    </div>
  );
}

export default App;
