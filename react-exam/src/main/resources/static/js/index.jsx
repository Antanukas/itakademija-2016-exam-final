
var App = React.createClass({

      render: function() {
        console.log("Index.jsx this.props");
        console.log(this.props);

        return (
          <div>
            <ul className="nav nav-tabs">
              <li className="active">
                <a href="/">Home</a>
              </li>
              <li><a href="/">Products</a></li>
              <li><a href="#/book/admin">Add book</a></li>
            </ul>
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
      <Route path="/book/admin/:id" component={BookAdministrationContainerEdit} />
      <Route path="/book/admin" component={BookAdministrationContainer} />
      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('root'));
