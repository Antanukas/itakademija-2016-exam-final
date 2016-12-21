var PropTypes = React.PropTypes;

var BookListComponent = function(props) {
  var bookCards = props.books.map(function (book, index) {
    return (
      <BookCardComponent
        key={index}
        id={book.id}
        title={book .title}
        author={book.author}
      />
    );
  });
  return (
    <div className="row">
      {bookCards}</div>
    );
};

BookListComponent.propTypes = {
  books: React.PropTypes.array.isRequired,
};

window.BookListComponent = BookListComponent;
