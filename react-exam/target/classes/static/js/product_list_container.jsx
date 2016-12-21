var ProductListContainer = React.createClass({
  getInitialState: function() {
    return { products: [] };
  },

handleClickCreate: function(){
	window.location = '/notImplemented';
},
handleClickUpdate: function(){
	window.location = '/notImplemented';
},

  componentWillMount: function() {
    var self = this;
    axios.get('/api/books')
      .then(function (response) {
        self.setState({ products: response.data });
      })
  },

  render: function() {
    return (
<div>
<ProductListComponent products={this.state.products} />
	<p><button className="btn btn-primary" role="button" Onclick={this.handleClickCreate()}>Create new</button></p>
	<p><button className="btn btn-primary" role="button" Onclick={this.handleClickUpdate()}>Update</button></p>
<div/>
)
  }
});

window.ProductListContainer = ProductListContainer;
