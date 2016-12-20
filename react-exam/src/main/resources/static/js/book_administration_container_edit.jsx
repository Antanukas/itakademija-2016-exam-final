var PropTypes = React.PropTypes;

var BookAdministrationContainerEdit = React.createClass({

  getInitialState: function() {

      return {
      id: this.props.params.id,
      title: this.props.title,
      author: this.props.author,
      isbn: this.props.isbn,
      quantity: this.props.quantity
      }

    },
  // componentDidMount: function(e){
  //   this.setState({
  //     title: this.props.title,
  //
  //   })
  // },
  componentWillMount: function() {
    var self = this;
    axios.get('http://localhost:8080/api/books')
      .then(function (response) {
        self.setState({ books: response.data });
      })
  },
  handleSaveClick: function(e) {
    var self = this;
    var body = {
      title: this.state.title,
      author: this.state.author,
      isbn: this.state.isbn,
      quantity: this.state.quantity
    }
    axios.post('http://localhost:8080/api/books/:id', body)
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
      console.log("This is response");
      console.log(response);
    });
    e.preventDefault();
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
    console.log("EDIT: These are my props");
    console.log(this.props);
    console.log("This is my state");
    console.log(this.state);



    return (
      <BookAdministrationComponent
        id={this.state.id}
        title={this.state.title}
        authors={this.state.author}
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

window.BookAdministrationContainerEdit = BookAdministrationContainerEdit;
