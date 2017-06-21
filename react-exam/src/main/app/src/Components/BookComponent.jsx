import React from 'react';
import { Table, Button } from 'react-bootstrap';
import Moment from "react-moment";
import UpdateButtonComponent from '../Components/UpdateButtonComponent';


const BookMap = (props) => (
    props.books.map((book) => (
        <tr key={book.id}>
            <td>{book.id}</td>
            <td>{book.title}</td>
            <td>{book.author}</td>
            <td><Moment format="YYYY-MM-DD">{book.publishedAt}</Moment></td>
            <UpdateButtonComponent book={book}/>
        </tr>
    ))
);

const BookComponent = (props) => (
    <div>
        <Table bordered>
            <thead>
                <tr>
                    <td>Knygos id</td>
                    <td>Pavadinimas</td>
                    <td>Autorius</td>
                    <td>išleidimo data</td>
                    <td>Keisti</td>
                </tr>
            </thead>
            <tbody>
                {BookMap(props)}
            </tbody>
        </Table>
        <a href="/#/create">
        <Button bsStyle="danger" >Pridėti</Button>
        </a>
    </div>
);

export default BookComponent;


