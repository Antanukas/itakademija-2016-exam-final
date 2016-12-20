var PropTypes = React.PropTypes;

var BookAdministrationContainer = React.createClass({

  getInitialState: function() {
      return {
        id: this.props.params.id,
        title: '',
        authors: '',
        isbn: '',
        quantity: 0
      };
    },

  handleSaveClick: function(e) {
    var self = this;
    var body = {
      title: this.state.title,
      authors: this.state.authors,
      isbn: this.state.isbn,
      quantity: this.state.quantity
    }
    axios.post('http://localhost:8080/api/books', body)
      .then(function (response) {
        var p = response.data;
        self.setState({
          id: p.id,
          title: p.title,
          authors: p.authors,
          isbn: p.isbn,
          quantity: p.quantity
      });
      self.props.router.push('/admin/products/' + p.id);
    });
    e.preventDefault();
  },

  handleTitleChange: function(e) {
    this.setState({ title: e.target.value });
  },


  handleAuthorsChange: function(e) {
    this.setState({ authors: e.target.value });
  },

  handleIsbnChange: function(e) {
    this.setState({ isbn: e.target.value });
  },

  handleQuantityChange: function(e) {
    this.setState({ quantity: e.target.value });
  },

  render: function() {
    // console.log("These are my props":);
    // console.log(this.props);
    return (
      <BookAdministrationComponent
        id={this.state.id}
        title={this.state.title}
        authors={this.state.authors}
        isbn={this.state.isbn}
        quantity={this.state.quantity}
        onTitleChange={this.handleTitleChange}
        onAuthorsChange={this.handleAuthorsChange}
        onIsbnChange={this.handleIsbnChange}
        onQuantityChange={this.handleQuantityChange}
        onSaveClick={this.handleSaveClick}
      />
    );
  }
});

window.BookAdministrationContainer = BookAdministrationContainer;
