var Link = ReactRouter.Link;

var BookListAdminstratorComponent = React.createClass({
  render: function () {

    var booksHtml = this.props.books.map(function(book, index){
      var url = '/admin/books' + book.id;
      return (
        <tr key = "index">
          <td>{index +1}</td>
          <td>title</td>
          <td>author</td>
        </tr>
      );
    });
    return(
      <div>
      <Link className = "btn btn-success" to = "/admin/books/new">Add new book</Link>
      <table className = "table">
        <thead>
          <tr>
            <th>#</th>
            <td>title</td>
            <td>author</td>
          </tr>
        </thead>
        <body>
          {booksHtml}
        </body>
      </table>
    </div>);
  }
});

BookListAdminstratorComponent.propTypes = {
  books: React.PropTypes.array.isRequired,
};
window.BookListAdminstratorComponent = BookListAdminstratorComponent;
