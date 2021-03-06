import React from 'react'
import { Navbar, Nav, Form, FormControl, Button, NavDropdown } from 'react-bootstrap';
import BootstrapSignUpModal from './signUpModal';
import BootstrapSignInModal from './signInModal';


class BootstrapNavbar extends React.Component{
    
    render(){
        return(
            <div>
                <Navbar bg="dark" variant="dark" expand="lg" sticky="top">
                    <Navbar.Brand href="#home">Coug and Chill</Navbar.Brand>
                        <Nav.Item className="ml-auto" style={{paddingRight: "5px"}}>
                            <BootstrapSignInModal></BootstrapSignInModal>
                        </Nav.Item>
                        <Nav.Item>
                            <BootstrapSignUpModal></BootstrapSignUpModal> 
                        </Nav.Item>
                    </Navbar>
            </div>
        )
    }
}
export default BootstrapNavbar;