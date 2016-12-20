var ProductDetailsContainer = React.createClass({
	getInitialState: function() {
		return { data: [] }
	},
	componentWillMount: function() {
		var _this = this;
		axios.get("http://localhost:9090/products/" + _this.props.params.id)
			.then(function(resp) {
				_this.setState({ data: resp.data })
			})
			.catch(function(err) {
				console.log(err);
			});
	},
	render: function() {
		return (
				<ProductDetailsComponent data={this.state.data} />
		);
	}
});

window.ProductDetailsContainer = ProductDetailsContainer;