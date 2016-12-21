var BookListContainer = React.createClass({
  getInitialState: function() {
    return { books: [] };
  },

handleClickCreate: function(){
	window.location = '/implementLater';
},
handleClickUpdate: function(){
	window.location = '/implementLater';
},

  componentWillMount: function() {
    var self = this;
    axios.get('http://localhost:8080/api/books')
      .then(function (response) {
        self.setState({ books: response.data });
      })
  },

  render: function() {
    return (
<div>
<BooktListComponent books={this.state.books} />
<div/>
)
  }
});

window.BookListContainer = BookListContainer;
