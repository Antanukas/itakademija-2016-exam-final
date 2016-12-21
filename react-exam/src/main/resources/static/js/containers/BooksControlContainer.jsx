var BooksControlContainer = React.createClass({
    getInitialState: function() {
    return {
      id: this.props.params.id,
      title: '',
      author: '',
      quantity: 0,
      isbn: ''
      };
  },

  handleSaveClick: function(e) {
    var self = this;
    var body = {
      title: this.state.title,
      author: this.state.author,
      quantity: this.state.quantity,
      isbn: this.state.isbn
      }
    axios.post('http://localhost:8080/api/books', body)
      .then(function (response) {
        var resp = response.data;
        self.setState({
          id: resp.id,
          title: resp.title,
          author: resp.author,
          quantity: resp.quantity,
          isbn: resp.isbn
      });
      self.props.router.push('/api/books/' + b.id);
    });
    e.preventDefault();
  },

  handleTitleChange: function(e) {
    this.setState({ title: e.target.value });
  },
  handleAuthorChange: function(e) {
    this.setState({ author: e.target.value });
  },
  handleQuantityChange: function(e) {
    this.setState({ quantity: e.target.value });
  },
  handleIsbnChange: function(e) {
    this.setState({ isbn: e.target.value });
  },

  render: function() {
    return (
      <BooksControlComponent
        id={this.state.id}
        title={this.state.title}
        author={this.state.author}
        quantity={this.state.quantity}
        isbn={this.state.isbn}
        onTitleChange={this.handleTitleChange}
        onAuthorChange={this.handleAuthorChange}
        onQuantityChange={this.handleQuantityChange}
        onIsbnChange={this.handleIsbnChange}
        onSaveClick={this.handleSaveClick}
      />
    );
  }
});

window.BooksControlContainer = BooksControlContainer;
