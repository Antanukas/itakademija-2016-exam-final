var BookListContainer = React.createClass({
    getInitialState: function() {
        return { books: [] };
      },
    
     componentWillMount: function() {
          var self = this;
          axios.get('/api/books')
              .then(function (response) {
              self.setState({ books: response.data });
          })
       },
          
       render: function() {
           return <BookListComponent books={this.state.books} />
         }
    
});

var BookListComponent = function(props) {
    var bookCards = props.books.map(function (book, index) {
      return (
        <BookCardComponent
          key={index}
          id={book.id}
          title={book.title}
          author={book.description}
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
  
  var BookCardComponent = React.createClass({
      render: function() {
        return (
          <div className="col-sm-6 col-md-4">
            <div className="thumbnail" style={styles.thumbnail}>
              <div className="caption">
                <h3>{this.props.title}</h3>
                <p>{this.props.author}</p>
               
                <p><button className="btn btn-primary" role="button">Details</button></p>
              </div>
            </div>
          </div>
        );
      }
    });
  
  BookCardComponent.propTypes = {
          id: PropTypes.number.isRequired,
          title: PropTypes.string.isRequired,
          author: PropTypes.string.isRequired,
        };