var BookListComponent = function(props) {
  var bookList = props.data.map(function (book, index) {
    return (
      <BookComponent
        key={index}
        id={book.id}
        title={book.title}
        author={book.author}
        isbn={book.isbn}
        quntity={book.quantity}
        publishedAt={book.publishedAt}
      />
    );
  });
  return (
    <div className="row" >
      {bookList}
    </div>);
};

window.BookListComponent = BookListComponent;
