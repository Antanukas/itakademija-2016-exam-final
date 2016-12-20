
var PropTypes = React.PropTypes;


var BookComponent = React.createClass({

  render: function() {
    // console.log("CardComponent:");
    // console.log(this.props.id);
    // var MyURL = "/admin/products/" + this.props.id;
    console.log(this.props);
    var BookURL = '/api/books/' + this.props.id;
    return (
      <div className="col-sm-6 col-md-4">
        <div className="">
            <div className="container-fluid caption">
              <h3 className="text-center">Book #{this.props.id}</h3>
              <p className="text-center"><strong>Title:</strong> {this.props.title}</p>
              <p className="text-center"><strong>Author:</strong> {this.props.authors}</p>
              <p><a href="/" className="btn btn-primary btn-lg pull-right" role="button">Edit</a></p>
            </div>
        </div>
      </div>

    );
  }

});

window.BookComponent = BookComponent;
