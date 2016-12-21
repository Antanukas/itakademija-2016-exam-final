var PropTypes = window.React.PropTypes;
var Link = ReactRouter.Link;

var BookComponent = React.createClass({
  render: function() {
    return (
      <div className="col-sm-6 col-md-4">
        <div className="well" style={{height: 300}}>
          <div className="caption">
            <h3>{this.props.title}</h3>
            <p>{this.props.author}</p>
            <p>{moment(this.props.publishedAt).format('MMMM Do YYYY, h:mm:ss a')}</p>
            <p>{this.props.id}</p>
            <p>
              <Link to="/form" >
                <button className="btn btn-primary" role="button">Atnaujinti</button>
              </Link>
            </p>
          </div>
        </div>
      </div>
    );
  }
});

BookComponent.propTypes = {
  id: PropTypes.number.isRequired,
  title: PropTypes.string.isRequired,
  author: PropTypes.string.isRequired,
};

window.BookComponent = BookComponent;
