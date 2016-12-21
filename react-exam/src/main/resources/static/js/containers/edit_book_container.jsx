var EditBookContainer = React.createClass( {
    getInitialState: function() {
        return {
            book: {
                title: '',
                author: '',
                isbn: '',
                quantity: ''
            }
        }
    },
    
    handleSaveClick: function(e) {
        e.preventDefault();
        var self = this;
        axios.put('/api/books/' + this.state.book.id, this.state.book).then(function() {
            self.context.router.push('/');
          });
    },
    
    componentDidMount: function() {
        var self = this;
        var bookId = this.props.params.bookId;
          axios.get('/api/books/' + bookId).then(function(response) {
            self.setState({ book: response.data });
           });
    },
    
    handleFieldChange: function(name) {
        var self = this;
        return function(e) {
          var book = self.state.book;
          book[name] = e.target.value;
          self.setState({ book: book });
        };
    },
    
    handleCancelClick() {
            this.context.router.push('/');
    },
      
    render: function() {
        return (
            <EditBookComponent
                book={this.state.book}
                onSaveClick={this.handleSaveClick}
                onCancelClick={this.handleCancelClick}
                onFieldChange={this.handleFieldChange}
            />
        );
    }

});

EditBookContainer.contextTypes = {
    router: React.PropTypes.object.isRequired,
};

window.EditBookContainer = EditBookContainer;