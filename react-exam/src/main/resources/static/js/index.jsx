var React = window.React;
var ReactDOM = window.ReactDOM;
var BookAdmin = window.BookAdmin;
var axios = window.axios;
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var hashHistory = ReactRouter.hashHistory;
var browserHistory = ReactRouter.browserHistory;
var Link = ReactRouter.Link;
var PropTypes = React.PropTypes;

var BookComponent = React.createClass({
    render: function() {
        return (
            <div className="col-sm-6 col-md-4">
                <div className="thumbnail">
                    <div className="caption">
                        <h3>{this.props.author}</h3>
                        <p>{this.props.title}</p>
                        <p>{this.props.isbn} Eur</p>
                        <p><button className="btn btn-primary" role="button">Details</button></p>
                    </div>
                </div>
            </div>
        );
    }
});

BookComponent.propTypes = {
    id: PropTypes.number.isRequired,
    author: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    isbn: PropTypes.string.isRequired,
    quantity: PropTypes.number.isRequired,
    publishedAt: PropTypes.string.isRequired
};
var BookAdministrationComponent = function(props) {
    var title;
    var saveButton;
    if (props.id) {
        title = 'Atnaujinamas produktas ' + props.id;
    } else {
        title = 'Kuriamas naujas produktas';
        saveButton = <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={props.onSaveClick}>Save</button>
    }
    return (
        <div>
            <h2>{title}</h2>
            <form>
                <div className="form-group">
                    <label>Author</label>
                    <input className="form-control" value={props.author} onChange={props.onAuthorChange} />
                </div>
                <div className="form-group">
                    <label>title</label>
                    <input className="form-control" value={props.title} onChange={props.onTitleChange} />
                </div>
                <div className="form-group">
                    <label>isbn</label>
                    <input className="form-control" value={props.author} onChange={props.onIsbnChange} />
                </div>
                <div className="form-group">
                    <label>publishedAt</label>
                    <input className="form-control" value={props.publishedAt} onChange={props.onPublishedAtChange} />
                </div>
                <div className="form-group">
                    <label>quantity</label>
                    <input className="form-control" value={props.quantity} onChange={props.onQuantityChange} />
                </div>


                {saveButton}
            </form>
        </div>
    );
};

BookAdministrationComponent.propTypes = {
    id: React.PropTypes.any,
    author: React.PropTypes.string.isRequired,
    title: React.PropTypes.string.isRequired,
    isbn: React.PropTypes.string.isRequired,
    quantity: React.PropTypes.any.isRequired,
    publishedAt: React.PropTypes.any.isRequired,

    onAuthorChange: React.PropTypes.func.isRequired,
    onTitleChange: React.PropTypes.func.isRequired,
    onIsbnChange: React.PropTypes.func.isRequired,
    onPublishedAtChange: React.PropTypes.func.isRequired,
    onQuantityChange: React.PropTypes.func.isRequired,
    onSaveClick: React.PropTypes.func.isRequired,
};
var SomePageComponent = function (props) {
    var goRoot = function (e) {
        props.router.push("/");
    }
    return (
        <div>
            At route: {props.router.getCurrentLocation().pathname}
            <button onClick={goRoot}>Go to Root route</button>
            <pre>
        {JSON.stringify(props, null, 2)}
      </pre>
        </div>
    );
};

var App = React.createClass({
    getInitialState: function () {
        return {
            books: []
        }
    },

    componentDidMount: function () {
        axios.get('http://localhost:8080/api/books').then(results => {
            this.setState({
                books: results.data
            })
        })
    },


    render: function () {

        return (

            <div>
                <h1>Knygos: </h1>
                {this.state.books.map(function (book, i) {
                    return (
                        <div key={book.id} style={{padding: 10}}>
                            <p><b>Autoriai:</b> {book.author}</p>
                            <p><b>Pavadinimas:</b> {book.title}</p>
                            <p><b>ID:</b> {book.id} </p>
                            <a href="knygos-atnaujinimas">
                                <button>Atnaujinti knyga</button>
                            </a>
                        </div>
                    )
                })}
                <Link to="/atnaujinimas">
                    <button>Kurti knyga</button>
                </Link>
                {this.props.children}
            </div>
        );
    }
});
var BookListComponent = function(props) {
    var productCards = props.products.map(function (product, index) {
        return (
            <BookCartComponent
                key={index}
                id={product.id}
                author={product.author}
                title={product.title}
                isbn={product.isbn}
                quantity={product.quantity}
            />
        );
    });
    return (
        <div className="row">
            {productCards}</div>
    );
};

BookListComponent.propTypes = {
    products: React.PropTypes.array.isRequired,
};
var HelloWorldComponent1 = React.createClass({
    render: function () {
        return (
            <div>
                <h1>hello</h1>

            </div>
        );
    }
});

var BookListContainer = React.createClass({
    getInitialState: function() {
        return { books: [] };
    },

    componentWillMount: function() {
        var self = this;
        axios.get('http://localhost:8080/api/books')
            .then(function (response) {
                self.setState({ products: response.data });
            })
    },

    render: function() {
        return <BookListContainer products={this.state.books} />
    }
});
var NoMatch = React.createClass({
    render: function () {
        return <div>Route did not match</div>;
    }
});


ReactDOM.render((
    <Router history={hashHistory}>
        <Route path="/" component={App}>
            <IndexRoute component={HelloWorldComponent1}/>
            <Route path="/atnaujinimas" component={HelloWorldComponent}/>
            <Route path="*" component={NoMatch}/>
        </Route>
    </Router>
), document.getElementById('root'));