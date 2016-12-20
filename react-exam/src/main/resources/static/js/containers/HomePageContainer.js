var HomePageContainer = React.createClass({
  render: function() {
    return (
      <div className="container">

          <div className="row">
              <div className="col-lg-12">
                  <h1 className="page-header">Page Heading
                      <small>Secondary Text</small>
                  </h1>
              </div>
          </div>

          <ProductsListContainer />
          
      </div>

    );
  }
})

window.HomePageContainer = HomePageContainer;
