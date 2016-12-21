var PropTypes = window.React.PropTypes;
var React = window.React;

var BookComponent = React.createClass( {
    render: function() {
        return (

            <div>
                <div>{this.props.id} test0</div>
                <div>{this.props.title} test1</div>
                <div>{this.props.author} test2</div>
            </div>

        );
    }
});

BookComponent.propTypes = {
    id: PropTypes.number.isRequired,
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
        var self = this;
        console.log( "noriu responso.." );
        axios.get( 'http://localhost:8080/api/books' )
            .then( function( response ) {
                self.setState( { books: response.data });
                console.log( response.data );
                console.log("response?");
            })

    },
    render: function() {
        return <BookListComponent books={this.state.product} />
    }
});

BookListComponent.propTypes = {
        books: React.PropTypes.array.isRequired,
}



window.BookListContainer = BookListContainer;
