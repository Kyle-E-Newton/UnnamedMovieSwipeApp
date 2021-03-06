import React from 'react'
import { Button,Modal,Form } from 'react-bootstrap'

class BootstrapSignUpModal extends React.Component{

    constructor(){
        super();
        this.state = {
            showHide : false
        }
    }

    handleModalShowHide() {
        this.setState({ showHide: !this.state.showHide })
    }

    render(){
        return(
            <div>
                <Button variant="primary" onClick={() => this.handleModalShowHide()}>
                    Sign Up
                </Button>

                <Modal show={this.state.showHide}>
                    <Modal.Header closeButton onClick={() => this.handleModalShowHide()}>
                    <Modal.Title>Sign Up</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group controlId="formBasicEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control type="email" placeholder="Enter email" />
                                <Form.Text className="text-muted">
                                We'll never share your email with anyone else.
                                </Form.Text>
                            </Form.Group>

                            <Form.Group controlId="formBasicPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control type="password" placeholder="Password" />
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                    <Button variant="secondary" onClick={() => this.handleModalShowHide()}>
                        Close
                    </Button>
                    <Button variant="primary" type="submit" onClick={() => this.handleModalShowHide()}>
                        Submit
                    </Button>
                    </Modal.Footer>
                </Modal>

            </div>
        )
    }
    
}

export default BootstrapSignUpModal;