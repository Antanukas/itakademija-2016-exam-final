var styles = {
    notfound: {
        textAlign: 'center',
        marginLeft: 'auto',
        marginRight: 'auto',
        fontSize: 200
    }};

var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var hashHistory = ReactRouter.hashHistory;
var IndexLink = ReactRouter.IndexLink;
var Link = ReactRouter.Link;


const BooksListPage = function () {
    return <ProductListContainer />
};

const NoPage= React.createClass({
    render: function() {
        return (

            <div style={styles.notfound}>404</div>

        );
    }
});

const App = React.createClass({
    render: function(props) {
        return (
            <div className="col-sm-12 col-md-12">
                <h1>Biblioteka</h1>
                <ul className="header">
                    <li><IndexLink to="/" activeClassName="active">Knygu sarasas</IndexLink></li>
                    <li><Link to="/new-book" activeClassName="active">Sukurti nauja knyga</Link></li>
                </ul>
                <div className="content">
                    {this.props.children}
                </div>
            </div>
        )
    }
});


