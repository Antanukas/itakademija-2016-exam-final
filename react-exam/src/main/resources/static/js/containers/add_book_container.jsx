var AddBookContainer = React.createClass( {
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
        axios.post('/api/books', this.state.book).then(function () {
            self.context.router.push('/');
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
            <AddBookComponent
                book={this.state.book}
                onSaveClick={this.handleSaveClick}
                onCancelClick={this.handleCancelClick}
                onFieldChange={this.handleFieldChange}
                />
        );
    }

});

AddBookContainer.contextTypes = {
    router: React.PropTypes.object.isRequired,
};

window.AddBookContainer = AddBookContainer;