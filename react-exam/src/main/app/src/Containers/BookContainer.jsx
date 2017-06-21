import React, { Component } from 'react';
import axios from 'axios';
import BookComponent from '../Components/BookComponent';
import UpdateButtonComponent from '../Components/UpdateButtonComponent';


const ulr = 'http://127.0.0.1:8080/api/books';

class BookContainer extends Component{
    constructor(props){
        super(props);
        this.state={
            books: []
        }
    }

    componentDidMount(){
        const self = this;
        axios.get(ulr)
            .then((response) => {
            self.setState({
                books: response.data
            });
            });
    }
    render(){
        return(
            <div>
                <BookComponent
                    books={this.state.books}
                />
            </div>
        );
    }
}

export default BookContainer;

