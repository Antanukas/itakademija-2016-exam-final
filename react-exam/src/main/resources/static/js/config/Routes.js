var Router = window.ReactRouter.Router;
var Route = window.ReactRouter.Route;
var IndexRoute = window.ReactRouter.IndexRoute;
var hashHistory = window.ReactRouter.hashHistory;

var Routes = (
	<Router history={hashHistory}>
	    <Route path="/" component={App}>
	      <IndexRoute component={HomePageContainer} />
	      <Route path="admin/books">
	      	<IndexRoute component={NoMatch} />
	      	<Route path="new" component={NewBookContainer}/>
	      	<Route path=":id/edit" component={EditBookContainer}/>
	      </Route>
	      <Route path="*" component={NoMatch}/>
	    </Route>
	</Router>
);

window.Routes = Routes;
