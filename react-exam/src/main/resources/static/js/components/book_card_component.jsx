var PropTypes = React.PropTypes;

var styles = {
  thumbnail: {
    maxWidth: '242px',
    textAlign: 'center',
    marginLeft: 'auto',
    marginRight: 'auto'
  }
};

var BookCardComponent = React.createClass({
  render: function() {
    return (
      <div className="col-sm-6 col-md-4">
        <div className="thumbnail" style={styles.thumbnail}>
          <div className="caption">
            <h3>{this.props.title}</h3>
            <p>{this.props.id}</p>
            <p>{this.props.author} </p>
            <p><button className="btn btn-primary" role="button">Create update</button></p>
          </div>
        </div>
      </div>
    );
  }
});

BookCardComponent.propTypes = {
  id: PropTypes.number.isRequired,
  title: PropTypes.string.isRequired,
  author: PropTypes.string.isRequired,
  isbn: PropTypes.string.isRequired,
  quantity: PropTypes.number.isRequired,
  publishedAt: PropTypes.date.isRequired,
};

window.BookCardComponent = BookCardComponent;
