import React, { Component } from 'react';
import axios from 'axios';
import CreateComponent from '../Components/CreateComponent';


const ulr = 'http://127.0.0.1:8080/api/books';


class CreateContainer extends Component{
    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    handleSubmit(response){
        axios.post(ulr, {
            isbn: response.isbn,
            title: response.name,
            author: response.author,
            publishedAt: response.publishedAt})
            .then(() =>(window.location="/")
        );
    }
    render(){
        return(
            <div>
                <CreateComponent
                    onSubmit={this.handleSubmit}
                />
            </div>
        );
    }
}

export default CreateContainer;