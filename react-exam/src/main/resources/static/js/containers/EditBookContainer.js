var EditBookContainer = React.createClass({
	contextTypes: {
		router: React.PropTypes.object.isRequired
	},
	getInitialState: function() {
		return { title: '', author: '', quantity: 0, isbn: '' };
	},
	componentDidMount: function() {
		var _this = this;
		axios.get('http://localhost:9090/api/books/' + this.props.params.id)
			.then(function(resp) {
				_this.setState({
					title: resp.data.title,
					author: resp.data.author,
					quantity: resp.data.quantity,
					isbn: resp.data.isbn
				});
			})
			.catch(function(err) {
				consosle.log(err);
			});
	},
	handleSubmitUpdate: function(e) {
		e.preventDefault();
		var _this = this;
		var body = {
			id: this.props.params.id,
			title: this.state.title,
			author: this.state.author,
			quantity: this.state.quantity,
			isbn: this.state.isbn
		};
		axios.put('http://localhost:9090/api/books/' + this.props.params.id, body)
			.then(function(resp) {
				_this.context.router.push('/');
			})
			.catch(function(err) {
				console.log(err);
			});
	},
	handleCancelUpdate: function(e) {
		e.preventDefault();
		this.context.router.goBack();
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
			<BookFormComponent
				title={this.state.title}
				author={this.state.author}
				quantity={this.state.quantity}
				isbn={this.state.isbn}
				changeTitle={this.handleTitleChange}
				changeAuthor={this.handleAuthorChange}
				changeQuantity={this.handleQuantityChange}
				changeIsbn={this.handleIsbnChange}
				submit={this.handleSubmitUpdate}
				cancel={this.handleCancelUpdate}
				action="Update"
			/>	
		);
	}
});

window.EditBookContainer = EditBookContainer;