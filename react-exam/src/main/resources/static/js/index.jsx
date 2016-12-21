var App = React.createClass({
  render: function() {
    return (
      <div>
         <Nav />
        {this.props.children}
      </div>
    );
  }
});

var BooksListPage = function () {
    return <BookListContainer />
}

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
      <IndexRoute component={BooksListPage} />
      <Route path="/new" component={AdminContainer} />
      <Route path="/update" component={AdminContainer} />
      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
