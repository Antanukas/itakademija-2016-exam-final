var NewBookContainer = React.createClass({
	contextTypes: {
		router: React.PropTypes.object.isRequired
	},
	getInitialState: function() {
		return { title: '', author: '', quantity: 0, isbn: '' };
	},
	handleSubmitCreate: function() {
		var _this = this;
		var body = {
			title: this.state.title,
			author: this.state.author,
			quantity: this.state.quantity,
			isbn: this.state.isbn
		};
		axios.post('http://localhost:9090/api/books', body)
			.then(function(resp) {
				_this.context.router.push('/');
			})
			.catch(function(err) {
				console.log(err);
			});
	},
	handleCancelCreate: function() {
		this.props.router.goBack();
	},
	handleTitleChange: function(event) {
		this.setState({ title: event.target.value });
	},
	handleAuthorChange: function(event) {
		this.setState({ author: event.target.value });
	},
	handleQuantityChange: function(event) {
		this.setState({ quantity: event.target.value });
	},
	handleIsbnChange: function(event) {
		this.setState({ isbn: event.target.value });
	},
	render: function() {
		return (
			<NewBookComponent
				title={this.state.title}
				author={this.state.author}
				quantity={this.state.quantity}
				isbn={this.state.isbn}
				changeTitle={this.handleTitleChange}
				changeAuthor={this.handleAuthorChange}
				changeQuantity={this.handleQuantityChange}
				changeIsbn={this.handleIsbnChange}
				create={this.handleSubmitCreate}
				cancel={this.handleCancelCreate}
			/>	
		);
	}
});

window.NewBookContainer = NewBookContainer;