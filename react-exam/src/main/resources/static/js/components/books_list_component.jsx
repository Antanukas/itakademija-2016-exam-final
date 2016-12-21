var BooksListComponent = React.createClass({
    render: function() {
        var self = this;
        var booksHtml = this.props.books.map(function(book, index) {
          return (
              <tr key={index}>
                  <td>{book.id}</td>
                  <td>{book.author}</td>
                  <td>{book.title}</td>
                  <td><button className="btn btn-primary btn-xs" onClick={self.props.onEditItem(book)}>Edit</button></td>
              </tr>
          );
        });
        return (
                <div className="container">
                  <table className="table">     
                  <thead>  
  	                  <tr>
  	                      <th>#</th>
  	                      <th>Author</th>
  	                      <th>Title</th>
  	                      <th>Edit</th>
  	                  </tr>
                   </thead>
                   <tbody>
                      {booksHtml}
                   </tbody> 
                  </table>
                  <hr/>
                      <button className="btn btn-primary btn-sm" onClick={this.props.onAddClick}>Add new book</button>
                </div>
            )
      }
    });

BooksListComponent.propTypes = {
    books: React.PropTypes.array.isRequired,
    onAddClick: React.PropTypes.func.isRequired
};

window.BooksListComponent = BooksListComponent;