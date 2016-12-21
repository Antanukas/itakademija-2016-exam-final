var App = React.createClass({
  render: function() {
    return (
      <div style={{ paddingTop: '20px' }}>
        <nav className="navbar navbar-default">
          <div className="container-fluid">
              <ul className="nav navbar-nav">
                <li><a href="#/">Home<span className="sr-only">(current)</span></a></li>
                <li><a href="#/create">Create Book<span className="sr-only">(current)</span></a></li>
              </ul>
          </div>
        </nav>
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
      <IndexRoute component={ProductListContainer} />
      <Route path="/create" component={CreateBookContainer} />
      <Route path="/update/:id" component={UpdateProductContainer} />
      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
