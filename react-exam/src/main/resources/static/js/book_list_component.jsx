var BookListComponent = function(props) {
  var bookCards = props.books.map(function (book, index) {
    return (

      <BookComponent
        key={index}
        id={book.id}
        isbn={book.isbn}
        title={book.title}
        author={book.author}
        quantity={book.quantity}
        publishedAt={book.publishedAt}
      />
    );
  });
  return (
    <div className="col-sm-6">
      {bookCards}
    </div>);
};
BookListComponent.propTypes = {
  books: React.PropTypes.array.isRequired,
};
window.BookListComponent = BookListComponent;
