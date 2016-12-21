var Link = ReactRouter.Link;

var HomePageContainer = React.createClass({
  render: function() {
    return (
      <div className="container" style={{ marginTop: '8vh' }}>

          <div className="row">
              <div className="col-lg-12">
                  <h1 className="page-header">Books collection &nbsp;
                      <Link to="admin/books/new" className="btn btn-primary btn-lg">New Book</Link>
                  </h1>
              </div>
          </div>

          <ProductsListContainer />
          
      </div>

    );
  }
})

window.HomePageContainer = HomePageContainer;
