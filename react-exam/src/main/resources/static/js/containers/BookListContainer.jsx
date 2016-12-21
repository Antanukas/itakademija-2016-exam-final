var Link = ReactRouter.Link;

var BookListContainer = React.createClass({
    getInitialState() {
        return {
            "books": []
        }
    },
    componentDidMount: function() {
        axios.get('http://localhost:8080/api/books')
       .then(function (response) {
            this.setState({"books": response.data})
        }.bind(this))
        .catch(function (error) {
            console.log(error);
        });
    },
    render: function() {
        return <BookListComponent books={this.state.books}/>
    }
});

window.BookListContainer = BookListContainer;