var PropTypes = window.React.PropTypes;

var BookListContainer = React.createClass({
  getInitialState: function() {
    return { data: [] };
  },

  componentWillMount: function() {
    var self = this;
    axios.get('http://localhost:8080/api/books')
      .then(function (response) {
        self.setState({ data: response.data });
      })
  },

  render: function() {
    return <BookListComponent data={this.state.data} />
  }
});

BookListContainer.propTypes = {
  data: React.PropTypes.array.isRequired,
};

window.BookListContainer = BookListContainer;
