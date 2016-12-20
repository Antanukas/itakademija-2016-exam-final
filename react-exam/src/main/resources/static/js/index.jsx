
var App = React.createClass({
    render: function() {
        return (
            <div>
                <h1>Simple SPA</h1>
                <ul className="header">
                    <li>Home</li>
                    <li>Stuff</li>
                    <li>Contact</li>
                </ul>
                <div className="content">

                </div>
            </div>
        )
    }
});








/*var PropTypes = window.React.PropTypes;
var React = window.React;

//**************Custom CSS styles*************************************************
var styles = {
    thumbnail: {
        maxWidth: '242px',
        textAlign: 'center',
        marginLeft: 'auto',
        marginRight: 'auto'
    },
    image: { width: '100%', height: '200px', display: 'block'}
};
//**************PRODUKTO KORTELE*************************************************
var ProductCardComponent = React.createClass({
    render: function() {
        return (
            <div className="col-sm-6 col-md-4">
                <div className="thumbnail" style={styles.thumbnail}>
                    <img src={this.props.image} style={styles.image} alt="..."/>
                    <div className="caption">
                        <h3>{this.props.title}</h3>
                        <p>{this.props.description}</p>
                        <p>{this.props.price} Eur</p>
                        <p><button className="btn btn-primary" role="button">Details</button></p>
                    </div>
                </div>
            </div>
        );
    }
});

ProductCardComponent.propTypes = {
    id: PropTypes.number.isRequired,
    image: PropTypes.string.isRequired,
    title: PropTypes.string.isRequired,
    description: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
};



//*************PRODUKTU SARASAS***********************************************************
var ProductListContainer = React.createClass({
    getInitialState: function() {
        return { books: [] };
    },

    componentWillMount: function() {
        var self = this;
        axios.get('/api/books')
            .then(function (response) {
                self.setState({ books: response.data });
            })
    },

    render: function() {
        return <ProductListComponent books={this.state.books} />
    }
});

ProductListComponent.propTypes = {
    books: React.PropTypes.array.isRequired,
};
//************************************************************************ //pakeiciau visus produucts i books

var App = React.createClass({
  render: function() {
    return (
      <div style={{ paddingTop: '20px' }}>
        {this.props.children}
      </div>
    );
  }
});

var ProductListPage = function () {
    return <ProductListContainer />
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
      <IndexRoute component={HelloWorldComponent} />
      <Route path="/hello-world" component={HelloWorldComponent} />
      <Route path="*" component={NoMatch}/>
    </Route>
  </Router>
), document.getElementById('container'));
*/