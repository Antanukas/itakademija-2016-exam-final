var BookEditContainer = React.createClass({
    getInitialState: function() {
        return {
            "book": {
                "id": "",
                "title": "", 
                "author": "",
                "quantity": 0,
                "isbn": "",
                "publishedAt": null
            }
        }
    },
    componentDidMount: function() {
        var bookId = this.props.params.id;
        if (bookId != "new") {
            axios.get('http://localhost:8080/api/books/' + bookId)
                .then(function (response) {
                    this.setState({"book": response.data})
                }.bind(this))
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    handleChangeField: function(fieldName) {
        return function(e) {
            var book = this.state.book;
            var value = e.target.value;
            if (fieldName === 'quantity') {
                value = parseInt(value)
            }
            book[fieldName] = value;
            this.setState({book: book})
        }.bind(this)
    },
    handleSubmit: function() {
            axios.post(BASE_URL + 'api/books/', this.state.book)
           .then(function (response) {
                this.setState({"book": response.data})
                this.context.router.push('/books');
            }.bind(this))
            .catch(function (error) {
                console.log(error);
                this.context.router.push('/books');
            });
    },
    handleCancel: function() {
        this.context.router.push('/books');
    },
    render: function() {
        return (
            <BookEditComponent 
                title={this.state.book.title}
                author={this.state.book.author}
                quantity={this.state.book.quantity}
                isbn={this.state.book.isbn}
                publishedAt={this.state.book.publishedAt}
                onChangeField={this.handleChangeField} 
                onSubmit={this.handleSubmit}
                onCancel={this.handleCancel}
            />

        );
    }
});

BookEditContainer.contextTypes = {
    router: React.PropTypes.object.isRequired,
};

window.BookEditContainer = BookEditContainer;