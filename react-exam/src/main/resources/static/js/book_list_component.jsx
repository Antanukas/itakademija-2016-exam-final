var BookListComponent = function(props) {
  var bookCards = props.books.map(function (book, index) {
    return (
      <BookComponent
        key={index}
        id={book.id}
        isbn={book.isbn}
        title={book.title}
        authors={book.authors}
        quantity={book.quantity}
        publishedAt={book.publishedAt}
      />
    );
  });
  return (
    <div className="row">
      {bookCards}
    </div>);
};
BookListComponent.propTypes = {
  books: React.PropTypes.array.isRequired,
};
window.BookListComponent = BookListComponent;
