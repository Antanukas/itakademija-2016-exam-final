

var NoMatch = React.createClass({
  render: function() {
    return <div>Route did not match</div>;
  }
});

var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var hashHistory = ReactRouter.hashHistory;

ReactDOM.render((
  <Router history={window.ReactRouter.hashHistory}>
    <Route path="/" component={Navigation}>
      <IndexRoute component={BookListContainer} />
      <Route path="/form" component={FormContainer} />
      <Route path="/form/:id" component={FormContainer} />
      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
