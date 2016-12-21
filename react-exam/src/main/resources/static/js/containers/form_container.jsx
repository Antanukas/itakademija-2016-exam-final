var FormContainer = React.createClass({

  getInitialState: function() {
    return {
      author: '',
      id: this.props.params.id,
      isbn: 0,
      publishedAt: new Date(),
      quantity: 0,
      title: ''
    };
  },

  handleSaveClick: function(e) {
    var self = this;
    var body = {
      author: this.state.author,
      isbn: this.state.isbn,
      publishedAt: this.state.publishedAt,
      quantity: this.state.quantity,
      title: this.state.title
    }
    axios.post('http://localhost:8080/api/books', body)
      .then(function (response) {
        var p = response.data;
        self.setState({
          author: p.author,
          isbn: p.isbn,
          publishedAt: new Date(),
          quantity: p.quantity,
          title: p.title
      });
      self.props.router.push('/');
    });
    
  },

  handleTitleChange: function(e) {
    this.setState({ title: e.target.value });
  },

  handleAuthorChange: function(e) {
    this.setState({ author: e.target.value });
  },

  handleIsbnChange: function(e) {
    this.setState({ isbn: e.target.value });
  },

  handleQuantityChange: function(e) {
    this.setState({ quantity: e.target.value });
  },

  render: function() {
    return (
      <FormComponent
        id={this.state.id}
        title={this.state.title}
        author={this.state.author}
        isbn={this.state.isbn}
        quantity={this.state.quantity}
        onTitleChange={this.handleTitleChange}
        onAuthorChange={this.handleAuthorChange}
        onIsbnChange={this.handleIsbnChange}
        onQuantityChange={this.handleQuantityChange}
        onSaveClick={this.handleSaveClick}
      />
    );
  }
});

window.FormContainer = FormContainer;
