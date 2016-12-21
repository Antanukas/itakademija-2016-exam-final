var PropTypes = React.PropTypes;

var BookListComponent = function(props) {
  var bookCards = props.books.map(function (book, index) {
    return (
      <BookCardComponent
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
    <div className="row">
      {bookCards}</div>
    );
};

BookListComponent.propTypes = {
  products: React.PropTypes.array.isRequired,
};

window.BookListComponent = BookListComponent;
