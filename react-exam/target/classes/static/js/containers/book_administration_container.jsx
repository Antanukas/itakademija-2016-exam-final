var BookAdministrationContainer = React.createClass({
  getInitialState: function() {
    return {
      id: this.props.params.id,
      author: '',
      title: '',
      publishedAt: '',
      isbn: 0,
      quantity: 0
    };
  },

  handleSaveClick: function(e) {
    var self = this;
    var body = {
      author: this.state.author,
      title: this.state.title,
      publishedAt: this.state.publishedAt,
      isbn: this.state.isbn,
      quantity: this.state.quantity
    }
    axios.post('http://localhost:8080/api/books', body)
      .then(function (response) {
        var p = response.data;
        self.setState({
          id: p.id,
          author: p.author,
          title: p.title,
          publishedAt: p.publishedAt,
          isbn: p.isbn,
          quantity: p.quantity
      });
      self.props.router.push('/new' + p.id);
    });
    e.preventDefault();
  },

  handleTitleChange: function(e) {
    this.setState({ title: e.target.value });
  },

  handleOnAuthorChange: function(e) {
    this.setState({ author: e.target.value });
  },

  handlePublishedAtChange: function(e) {
    this.setState({ publishedAt: e.target.value });
  },

  handleIsbnChange: function(e) {
    this.setState({ isbn: e.target.value });
  },

  handleQuantityChange: function(e) {
    this.setState({ quantity: e.target.value });
  },

  render: function() {
    return (
      <BookAdministrationComponent
        id={this.state.id}
        author={this.state.author}
        title={this.state.title}
        publishedAt={this.state.publishedAt}
        isbn={this.state.isbn}
        quantity={this.state.quantity}

        onAuthorChange={this.handleOnAuthorChange}
        onTitleChange={this.handleTitleChange}
        onPublishedAtChange={this.handlePublishedAtChange}
        onIsbnChange={this.handleIsbnChange}
        onQuantityChange={this.handleQuantityChange}
        onSaveClick={this.handleSaveClick}
      />
    );
  }
});

window.BookAdministrationContainer = BookAdministrationContainer;
