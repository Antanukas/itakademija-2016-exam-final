var App = React.createClass( {
    render: function() {
        return (
            <div style={{ paddingTop: '20px' }}>
                {this.props.children}
            </div>
        );
    }
});

var NoMatch = React.createClass( {
    render: function() {
        return <div>Route did not match</div>;
    }
});

var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var hashHistory = ReactRouter.hashHistory;

ReactDOM.render((
    <Router history={hashHistory}>
        <Route path="/" component={App}>
            <IndexRoute component={BookListContainer} />
            <Route path="/admin/products/new" component={book_administration_container.jsx} />
            <Route path="/admin/products/:id" component={book_administration_container.jsx} />
            <Route path="*" component={NoMatch} />
        </Route>
    </Router>
), document.getElementById( 'root' ) );
