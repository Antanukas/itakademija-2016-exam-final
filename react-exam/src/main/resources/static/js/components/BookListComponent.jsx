var Link = ReactRouter.Link;

var BookListComponent = function(props) {
        var bookList = []
        props.books.map(function(book, idx) {
            bookList.push(
                <BookRowComponent 
                    id={book.id}
                    title={book.title}
                    author={book.author}
                    quantity={book.quantity}
                    isbn={book.isbn}
                    publishedAt={book.publishedAt}
                    key={idx}
                />
            )
        });
        return (
            <div>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>Id</td>
                            <td>Title</td>
                            <td>Author</td>
                            <td>Published At</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        {bookList}
                    </tbody>
                </table>
                <Link to="books/new">
                    <button type="button" className="btn btn-primary">Add new book</button>
                </Link>
            </div>
        );
};

BookListComponent.propTypes = {
    books: React.PropTypes.array.isRequired
}

window.BookListComponent = BookListComponent;