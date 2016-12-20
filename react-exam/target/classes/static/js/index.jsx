var App = React.createClass({
  render: function() {
    return (
      <div style={{ paddingTop: '20px' }}>
        <NavigationComponent />
        {this.props.children}
      </div>
    );
  }
});

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
  <Router history={hashHistory}>
    <Route path="/" component={App}>
      <IndexRoute component={BookListContainer} />
      <Route path="/books" component={BookListContainer} />
      <Route path="/admin" component={Admin}>
        <IndexRoute component = {BookListAdministrationContainer}/>
        <Route path="/admin/books" component = {bookListAdministrationComponent}/>
        <Route path="/admin/books/:bookId" component = {BookAdminstratorContainer}/>
      </Route>
    <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
