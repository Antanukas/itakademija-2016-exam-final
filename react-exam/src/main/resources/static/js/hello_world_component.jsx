var PropTypes = window.React.PropTypes;
var React = window.React;

var BookComponent = React.createClass( {
    render: function() {
        return (

            <div>
                <div>{this.props.title} test1</div>
                <div>{this.props.author} test2</div>
            </div>

        );
    }
});

BookComponent.propTypes = {
    title: PropTypes.string.isRequired,
    author: PropTypes.string.isRequired,
}

var BookListComponent = function( props ) {
    var bookItem = props.books.map( function( book, index ) {
        return (
            <BookComponent
                key={index}
                id={book.id}
                title={book.title}
                author={book.author}
                />
        );
    });
    return ( <div className="row">{bookItem}</div> );
};
var BookListContainer = React.createClass( {
    getInitialState: function() {
        return { books: [] };
    },
    componentWillMount: function() {
        console.log( "testas1" );
        var self = this;
        console.log( "testas1.5" );
        axios.get( 'http://localhost:8080/api/books' )
            .then( function( response ) {
                self.setState( { books: response.data });
                console.log( response.data );
            })
            .catch( function( error ) {
                console.log( error );
            })
    },
    render: function() {
        return <BookListComponent books={this.state.product} />
    }
});

/*BookListComponent.propTypes = {
        books: React.PropTypes.array.isRequired,
}*/

var ComponentList = React.createClass

window.BookListContainer = BookListContainer;
