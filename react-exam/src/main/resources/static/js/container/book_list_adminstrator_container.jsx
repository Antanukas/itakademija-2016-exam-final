var BookListAdministrationComponent = window.bookListAdministrationComponent;

var BookListAdministrationContainer = React.createClass({

  getInitialState: function() {
    return { books: [] };
  },

  componentDidMount: function() {
    var self = this;
    axios.get('/api/books').then(function (response) {
      self.setState({ books: response.data });
    });
  },

  render: function() {
    return (
        <bookListAdministrationComponent
          books={this.state.books}
        />
    );
  }
});

BookListAdministrationComponent.contextTypes = {
  router: React.PropTypes.object.isRequired,
};

window.BookListAdministrationContainer = BookListAdministrationContainer
