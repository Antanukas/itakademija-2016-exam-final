
var PropTypes = React.PropTypes;


var BookComponent = React.createClass({

  render: function() {
    // console.log("CardComponent:");
    // console.log(this.props.id);
    // var MyURL = "/book/" + this.props.id;
    console.log("Props book_component:" + this.props.id);
    
    var BookURL = '#/book/admin/'+ this.props.id;
    return (
        <div className="col-sm-8 col-md-8">
            <div className="container-fluid">
              <div className="caption">
                <h3 className="text-center">Book #{this.props.id}</h3>
                <p className="text-center"><strong>Title:</strong> {this.props.title}</p>
                <p className="text-center"><strong>Author:</strong> {this.props.author}</p>
                </div>
            </div>
            <div>
              <a href={BookURL} className="btn btn-primary btn-lg pull-right" role="button">Edit</a>
            </div>
          </div>
    );
  }

});

window.BookComponent = BookComponent;
