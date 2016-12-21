

var BookListComponent = function(props) {
    var bookCards = props.books.map(function (book,index) {
        return (
             <BookCardComponent
               key={index}
               id={book.id}
               title={book.title}
               author={book.author}
               publishedAt={book.publishedAt}
                />
        );
    });
    
    return (
        <div className="row">
          {bookCards}
        </div>
        );
};



window.BookListComponent = BookListComponent;