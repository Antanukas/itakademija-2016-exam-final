var BooksListContainer = React.createClass({
    getInitialState: function() {
        return {
          books: [] 
        };
    },
    
    componentWillMount: function() {
        var self = this;
        axios.get('/api/books').then(function(response) {
            self.setState({ 
                books: response.data 
            });
        });
    },
    
    handleAddBook() {
        this.context.router.push('/add-book');
    },
    
    handleBookEdit: function(book) {
        var self = this;
        return function() {
            self.context.router.push('/books/edit/' + book.id);
        }
    },
    
    render: function() {
        return <BooksListComponent books={this.state.books} onAddClick={this.handleAddBook} onEditItem={this.handleBookEdit}/>
    }
});

BooksListContainer.contextTypes = {
    router: React.PropTypes.object.isRequired
};

window.BooksListContainer = BooksListContainer;