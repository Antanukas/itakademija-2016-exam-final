var BookListContainer = React.createClass({

  getInitialState: function () {
    return {
      books: []
    };
  },

  componentDidMount: function () {
    var self = this;
    axios.get('/api/books').then(function(response) {
      self.setState({books: response.data})
    });
  },

  handleDetailsClick: function (bookId) {
    var self = this;
    return function () {
      self.context.router.push('/books/'+bookId);
    };
  },

  render: function () {
    return (
      <book_list_component
        books = {this.state.books}
        onDetailsClick = {this.handleDetailsClick}
        />);
  }
});
BookListContainer.contextTypes = {
  router: React.PropTypes.object.isRequired,
};
window.BookListContainer = BookListContainer;
