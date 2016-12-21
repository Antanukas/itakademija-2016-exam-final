var ProductAdministrationContainer = React.createClass({
    getInitialState: function() {
        return {
            id: this.props.params.id,
            isbn: '',
            title: '',
            author: '',
            quantity: '',
            publishedAt: ''
        };
    },

    handleSaveClick: function(e) {
        var self = this;
        var body = {
            id: this.state.id,
            isbn: this.state.isbn,
            title: this.state.title,
            author: this.state.author,
            quantity: this.state.quantity,
            publishedAt:this.state.publishedAt
        }
        axios.post('http://localhost:8080/api/books', body)
            .then(function (response) {
                var p = response.data;
                self.setState({
                    id: p.id,
                    isbn: p.isbn,
                    title: p.title,
                    author: p.author,
                    quantity: p.quantity,
                    publishedAt: p.publishedAt
                });
                self.props.router.push('/products');
            });
        e.preventDefault();
    },

    handleIdChange: function(e) {
        this.setState({ id: e.target.value });
    },

    handleIsbnChange: function(e) {
        this.setState({ isbn: e.target.value });
    },

    handleTitleChange: function(e) {
        this.setState({ title: e.target.value });
    },

    handleAuthorChange: function(e) {
        this.setState({ author: e.target.value });
    },

    handleQuantityChange: function(e) {
        this.setState({ quantity: e.target.value });
    },

    handlePublishedAtChange: function(e) {
        this.setState({ publishedAt: e.target.value });
    },

    render: function() {
        return (
            <ProductAdministrationComponent
                id={this.state.id}
                isbn={this.state.isbn}
                title={this.state.title}
                author={this.state.author}
                quantity={this.state.quantity}
                publishedAt={this.state.publishedAt}
                onIdChange={this.handleIdChange}
                onIsbnChange={this.handleIsbnChange}
                onTitleChange={this.handleTitleChange}
                onAuthorChange={this.handleAuthorChange}
                onQuantityChange={this.handleQuantityChange}
                onPublishedAtChange={this.handlePublishedAtChange}
                onSaveClick={this.handleSaveClick}
            />
        );
    }
});

window.ProductAdministrationContainer = ProductAdministrationContainer;
