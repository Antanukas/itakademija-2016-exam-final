var bookPropTypes = React.PropTypes;
var Link = ReactRouter.Link;

var BookCardComponent = React.createClass({
  render: function() {
    return (
        <div className="col-sm-4 col-md-4">
            <div className="AboutBook">
              <h3>{this.props.title}</h3>
              <p>{this.props.author}</p>
              <p>{this.props.id}</p>
              <Link to='/Book/:id'>
                <p><button className="Updatebtn btn btn-primary" role="button">Update Book</button></p>
              </Link>
            </div>
        </div>
    );
  }
});

BookCardComponent.bookPropTypes = {
  id: bookPropTypes.number.isRequired,
  title: bookPropTypes.string.isRequired,
  author: bookPropTypes.string.isRequired,

  };

window.BookCardComponent = BookCardComponent;
