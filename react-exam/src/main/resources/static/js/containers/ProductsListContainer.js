var ProductsListContainer = React.createClass({
	getInitialState: function() {
		return ({ data: [] });
	},
	componentDidMount: function() {
		var _this = this;
		axios.get('http://localhost:9090/api/products')
      .then(function(resp) {
        console.log(resp);
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
                      title={details.title}
                      description={details.description}
                    />);
    });
  },
	render: function() {
		return <ProductsListComponent products={this.prepareCollection()} />
	}
});

window.ProductsListContainer = ProductsListContainer;