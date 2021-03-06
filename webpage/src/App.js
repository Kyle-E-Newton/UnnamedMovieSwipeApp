import logo from './logo.svg';
import React from 'react';
import './App.css';
import Button from 'react-bootstrap/Button';
import BootstrapNavbar from './topbar';
import BootstrapTab from './tabbedPanel';
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  const [modalShow, setModalShow] = React.useState(false);
  return (
    <div className="App">
      <BootstrapNavbar></BootstrapNavbar>
      <BootstrapTab></BootstrapTab>
    </div>
  );
}

export default App;
