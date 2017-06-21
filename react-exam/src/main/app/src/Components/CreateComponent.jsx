import React, { PureComponent } from 'react';
import { Modal, Button, Form, FormGroup, Col, ControlLabel, FormControl } from 'react-bootstrap';


    class CreateContainer extends PureComponent {
        constructor(props){
            super(props);
            this.state={
                    name:"",
                    isbn:"",
                    author:""
            };
            this.handleSubmit = this.handleSubmit.bind(this);
            this.handleChange = this.handleChange.bind(this);
        }
        handleChange(e){
            this.setState({[e.target.name]: e.target.value});
        }
        handleSubmit(e){
            e.preventDefault();
            this.props.onSubmit(this.state);
            // console.log(this.state);
        }
        render() {
            return(
            <div className="static-modal">
                <Modal.Dialog>
                    <Modal.Header>
                        <Modal.Title>Knygos kurimo forma</Modal.Title>
                    </Modal.Header>
                    <Form horizontal onSubmit={this.handleSubmit}>
                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={2}>
                                Knygos pavadinimas
                            </Col>
                            <Col sm={10}>
                                <FormControl type="name" placeholder="Pavadinimas" name="name" onChange={this.handleChange}
                                value={this.state.name}/>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={2}>
                                ISBN numeris
                            </Col>
                            <Col sm={10}>
                                <FormControl type="isbn" placeholder="Numeris" name="isbn" onChange={this.handleChange} value={this.state.isbn}/>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={2}>
                                Autorius
                            </Col>
                            <Col sm={10}>
                                <FormControl type="author" placeholder="Autorius" name="author" onChange={this.handleChange} value={this.state.author}/>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Col componentClass={ControlLabel} sm={2}>
                                Išleidimo data
                            </Col>
                            <Col sm={10}>
                                <FormControl type="publishedAt" placeholder="Išleidimo data" name="publishedAt" onChange={this.handleChange} value={this.state.publishedAt}/>
                            </Col>
                        </FormGroup>

                        <FormGroup>
                            <Modal.Footer>
                                <a href="/"><Button>Close</Button></a>
                                <Button bsStyle="primary" type="submit">Save changes</Button>
                            </Modal.Footer>
                        </FormGroup>
                    </Form>
                </Modal.Dialog>
            </div>
            );
        }
    }
export default CreateContainer;