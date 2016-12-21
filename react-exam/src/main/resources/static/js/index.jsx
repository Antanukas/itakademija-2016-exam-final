var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var hashHistory = ReactRouter.hashHistory;

var App = React.createClass({
  render: function() {
    return (
      <div style={{ paddingTop: '20px' }}>
        {this.props.children}
      </div>
    );
  }
});

var NoMatch = function(props) {
    return (<div>Route did not match</div>)
};

var routes = (
    <Router history={hashHistory}>
        <Route path="/" component={App}>
            <IndexRoute component={BookListContainer}/>
            <Route path="/books" component={BookListContainer}/>
            <Route path="/books/:id" component={BookEditContainer}/>
            <Route path="*" component={NoMatch}/>
        </Route>
    </Router>
);

ReactDOM.render(
    routes, 
    document.getElementById('root')
);
