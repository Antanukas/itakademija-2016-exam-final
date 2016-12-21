var BookAdminstratorContainer = React.createClass( {
    getInitialState: function() {
        return {
            book: {
                title: '',
                author: '',
                isbn: '',
                quantity: '',
                publishedAt: ''
            }
        };
    },

    handleSaveClick: function( e ) {
        e.preventDefault();
        var bookId = this.props.params.bookId;
        var self = this;
        if ( bookId === 'new' ) {
            axios.post( '/api/books', this.state.book ), then( function() {
                self.context.router.push( '/admin/books' );
            });
        
            axios.put( '/api/books/' + this.state.book.id, this.state.book ).then( function() {
                self.context.router.push( '/admin/books' );
            });
        }
    },
    componentDidMount: function() {
        var self = this;
        var bookId = this.props.parms.bookId;

        if ( bookId !== 'new') {
            axios.get('/api/books/' + bookId ).then( function( response ) {
                self.setState( { book: response.data });
            });
        }
    },
        
handleFieldChange: function(fieldName ) {
    var self = this;
    return function( e ) {
        var book = self.state.book;
        book[fieldName] = e.target.value;
        self.setState( { book: book });
    };
},

render: function() {
    return (
      <ProductAdministrationComponent
        product={this.state.product}
        onSaveClick={this.handleSaveClick}
        onFieldChange={this.handleFieldChange}
      />
    );
  }
});

BookAdministrationContainer.contextTypes = {
    router: React.PropTypes.object.isRequired,
};

window.BookAdministrationContainer = BookAdministrationContainer;
