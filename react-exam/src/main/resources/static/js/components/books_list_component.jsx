var BooksListComponent = React.createClass( {
    render: function() {
        var self = this;
        var booksList = this.props.books.map( function( book, index ) {

            // published date
            var d = new Date( book.publishedAt );
            var year = d.getFullYear();
            var month = d.getMonth() + 1;
            var date = d.getDate();
            // jei menuo vienzenklis sk tai prieki bus 0 pvz: 03
            if ( month < 10 ) {
                month = '0' + month;
            }
            if ( date < 10 ) {
                date = '0' + date;
            }
            var fullDate = year + '-' + month + '-' + date;

            return (
                <tr key={index}>
                    <td>{book.id}</td>
                    <td>{book.author}</td>
                    <td>{book.title}</td>
                    <td>{fullDate}</td>
                    <td>
                        <button type="button" className="btn btn-default" onClick={self.props.onEditItem( book )}>
                            <span className="glyphicon glyphicon-pencil"></span></button>
                    </td>
                </tr>
            );
        });
        return (
            <div className="container">
                <button className="btn btn-success" onClick={this.props.onAddClick}  >Mygtukas iterpti nauja knyga</button>
                <div className="panel panel-default">

                    <div className="panel-heading">THE BOOK LIST</div>
                    <table className="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>AUTHOR</th>
                                <th>TITLE</th>
                                <th>PUBLISHED</th>
                                <th>EDIT</th>

                            </tr>
                        </thead>
                        <tbody>
                            {booksList}
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
});

BooksListComponent.propTypes = {
    books: React.PropTypes.array.isRequired,
    onAddClick: React.PropTypes.func.isRequired
};

window.BooksListComponent = BooksListComponent;