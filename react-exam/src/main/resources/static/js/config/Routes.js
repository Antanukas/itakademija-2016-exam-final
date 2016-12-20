var Router = window.ReactRouter.Router;
var Route = window.ReactRouter.Route;
var IndexRoute = window.ReactRouter.IndexRoute;
var hashHistory = window.ReactRouter.hashHistory;

var Routes = (
	<Router history={hashHistory}>
	    <Route path="/" component={App}>
	      <IndexRoute component={HomePageContainer} />
	      <Route path="*" component={NoMatch}/>
	    </Route>
	</Router>
);

window.Routes = Routes;
