import React, { PureComponent } from 'react';
import { Button, Modal, Form, FormGroup, Col, ControlLabel, FormControl } from 'react-bootstrap';
import axios from 'axios';

const ulr = 'http://127.0.0.1:8080/api/books/';


class UpdateButtonComponent extends PureComponent{
    constructor(props){
        super(props);
        this.state={
            show: false,
            id: this.props.book.id,
            name:this.props.book.title,
            isbn:this.props.book.isbn,
            author:this.props.book.author,
            publishedAt:this.props.book.publishedAt
        };
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }
    handleChange(e){
        this.setState({[e.target.name]: e.target.value});
    }
    handleSubmit(e){
        e.preventDefault();
        axios.put(ulr + this.state.id, {
            isbn: this.state.isbn,
            title: this.state.name,
            author: this.state.author,
            publishedAt: this.state.publishedAt})
        .then(() =>(window.location="/")
        );
    }
    render() {
        let close = () => this.setState({ show: false});

        return (
            <div className="modal-container">
                <Button
                    bsStyle="warning"
                    onClick={() => this.setState({ show: true})}
                >
                    Keisti
                </Button>

                <Modal
                    show={this.state.show}
                    onHide={close}
                    container={this}
                    aria-labelledby="contained-modal-title"
                >
                    <Modal.Header closeButton>
                        <Modal.Title id="contained-modal-title">Contained Modal</Modal.Title>
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
                </Modal>
            </div>
        );
    }
}

export default UpdateButtonComponent;