var App = React.createClass({
  render: function() {
    return (
      <div style={{ paddingTop: '10px' }}>
        <div className="jumbotron col-sm-16 col-sm-offset-1 text-center">
            <div className="col-sm-4">
              <Link to='/'>
              <p><button className="homebtn btn btn-primary" role="button">Home</button></p>
              </Link>
            </div>
            <div className="col-sm-4">
              <Link to='/NewBook'>
                <p><button className="Addbtn btn btn-primary" role="button">Add New Book</button></p>
              </Link>
            </div>
            <div className="row">
                {this.props.children}
            </div>
        </div>
      </div>
    );
  }
});

var NoMatch = React.createClass({
  render: function() {
    return <div>Route did not match</div>;
  }
});
var Link = ReactRouter.Link;
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;
var hashHistory = ReactRouter.hashHistory;

ReactDOM.render((
  <Router history={hashHistory}>
    <Route path="/" component={App}>
      <IndexRoute component={BookListContainer} />
      <Route path="/hello-world" component={HelloWorldComponent} />
        <Route path='/NewBook' component={BooksControlContainer}/>
        <Route path='/Book/:id' component={BooksControlContainer}/>

      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
