var PropTypes = React.PropTypes;

var BookAdministrationContainer = React.createClass({

  getInitialState: function() {

      return {
      id: this.props.params.id,
      title: '',
      author: '',
      isbn: '',
      quantity: 0
      }

    },

  handleSaveClick: function(e) {
    var self = this;
    var body = {
      title: this.state.title,
      author: this.state.author,
      isbn: this.state.isbn,
      quantity: this.state.quantity
    }
    axios.post('http://localhost:8080/api/books', body)
      .then(function (response) {
        var p = response.data;
        self.setState({
          id: p.id,
          title: p.title,
          authors: p.author,
          isbn: p.isbn,
          quantity: p.quantity
      });
      self.props.router.push('/api/books' + p.id);
    });
    e.preventDefault();
  },
  handleCancelClick:function(){
    this.context.router.push('/');
  },

  handleTitleChange: function(e) {
    this.setState({ title: e.target.value });
  },


  handleAuthorsChange: function(e) {
    this.setState({ author: e.target.value });
  },

  handleIsbnChange: function(e) {
    this.setState({ isbn: e.target.value });
  },

  handleQuantityChange: function(e) {
    this.setState({ quantity: e.target.value });
  },

  render: function() {
    // console.log("These are my props":);

    console.log("admin_comp this.state:");
    console.log(this.state);
    return (
      <BookAdministrationComponent
        id={this.state.id}
        title={this.state.title}
        author={this.state.author}
        isbn={this.state.isbn}
        quantity={this.state.quantity}
        onTitleChange={this.handleTitleChange}
        onAuthorsChange={this.handleAuthorsChange}
        onIsbnChange={this.handleIsbnChange}
        onQuantityChange={this.handleQuantityChange}
        onSaveClick={this.handleSaveClick}
        onCancelCLick={this.handleCancelClick}
      />
    );
  }
});

window.BookAdministrationContainer = BookAdministrationContainer;
