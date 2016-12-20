var ProductsListContainer = React.createClass({
	getInitialState: function() {
		return ({ data: [] });
	},
	componentDidMount: function() {
		var _this = this;
		axios.get('http://localhost:9090/api/books')
      .then(function(resp) {
        _this.setState({ data: resp.data });
      })
      .catch(function(err) {
        console.log(err);
      })
	},
	prepareCollection: function() {
	    var products = [];
	    this.state.data.forEach(details => {
	      products.push(<ProductCardComponent 
	                      key={details.isbn}
	      				  id={details.id}
					      isbn={details.isbn}
					      title={details.title}
					      author={details.author}
					      quantity={details.quantity}
					      publishedAt={details.publishedAt}
	                    />);
	    });
	    return products;
	},
	render: function() {
		return <ProductsListComponent products={this.prepareCollection()} />
	}
});

window.ProductsListContainer = ProductsListContainer;