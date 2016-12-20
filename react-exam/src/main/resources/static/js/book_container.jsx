var PropTypes = React.PropTypes;

var BookContainer = React.createClass({

  getInitialState: function() {
    return { products: [] };
  },

  componentWillMount: function() {
    var self = this;
    axios.get('http://localhost:8080/api/books')
      .then(function (response) {
        self.setState({ products: response.data });
      })
  },

  render: function() {
    // console.log("inside list:")
    // console.log(this);
    return <BookComponent products={this.state.products} />

  }
});

window.BookContainer = BookContainer;
