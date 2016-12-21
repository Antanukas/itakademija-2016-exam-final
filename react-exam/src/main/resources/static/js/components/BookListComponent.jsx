var PropTypes = React.PropTypes;

var BookListComponent = function(props) {
    var BookCard = props.books.map(function (book, index) {
    return (
      <BookCardComponent
        key={index}
        title={book.title}
        author={book.author}
        id={book.id}
        date={book.date}
        />
    );
  });
  return (
    <div className="row">
      {BookCard}</div>
    );
};

BookListComponent.propTypes = {
  books: React.PropTypes.array.isRequired,
};

window.BookListComponent = BookListComponent;
