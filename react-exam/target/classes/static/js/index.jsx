
var App = function(props) {
  return <div>{props.children}</div>;
};
var ProductListPage = function () {
  return <BookListContainer />
};
var NoMatch = function(props) {
  return <div>Error</div>;
};



var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;

ReactDOM.render((
  <Router history={ReactRouter.hashHistory}>
      <IndexRoute component={App} />
	 <Route path="/" component={App}>
      <Route path="/books" component={BooktListPage} />
      <Route path="/new" component={BookAdministrationContainer} />
      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
