var React = window.React;
var HelloWorldComponent = React.createClass({
    getInitialState: function() {
        return {
            id: this.props.params.id,
            author: '',
            title: '',
            isbn: '',
            publishedAt: '',
            quantity: 0
        };
    },

    handleSaveClick: function(e) {
        var self = this;
        var body = {
            author: this.state.author,
            title: this.state.title,
            isbn: this.state.isbn,
            publishedAt: this.state.publishedAt,
            quantity: this.state.quantity
        }
        axios.post('http://localhost:8080/api/books', body)
            .then(function (response) {
                var p = response.data;
                self.setState({
                    id: p.id,
                    author: p.author,
                    title: p.title,
                    isbn: p.isbn,
                    publishedAt: p.publishedAt,
                    quantity: p.quantity
                });
                self.props.router.push('/api/books/' + p.id);
            });
        e.preventDefault();
    },

    handleTitleChange: function(e) {
        this.setState({ title: e.target.value });
    },

    handleAuthorChange: function(e) {
        this.setState({ author: e.target.value });
    },

    handleIsbnChange: function(e) {
        this.setState({ isbn: e.target.value });
    },

    handlePublishedAtChange: function(e) {
        this.setState({ publishedAt: e.target.value });
    },

    handleQuantityChange: function(e) {
        this.setState({ quantity: e.target.value });
    },

    render: function() {
        return (
            <HelloWorldComponent
                id={this.state.id}
                author={this.state.author}
                title={this.state.title}
                isbn={this.state.isbn}
                publishedAt={this.state.publishedAt}
                quantity={this.state.quantity}
                onAuthorChange={this.handleAuthorChange}
                onTitleChange={this.handleTitleChange}
                onIsbnChange={this.handleIsbnChange}
                onPublishedAtChange={this.handlePublishedAtChange}
                onQuantityChange={this.handleQuantityChange}
                onSaveClick={this.handleSaveClick}
            />
        );
    }
});


window.HelloWorldComponent = HelloWorldComponent;
