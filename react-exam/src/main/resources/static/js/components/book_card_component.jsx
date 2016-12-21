var PropTypes = React.PropTypes;

var styles = {
  thumbnail: {
    maxWidth: '242px',
    textAlign: 'center',
    marginLeft: 'auto',
    marginRight: 'auto'
  },
  image: { width: '100%', height: '200px', display: 'block'}
};

var BookCardComponent = React.createClass({
  render: function() {
    return (
      <div className="col-sm-6 col-md-4">
        <div className="thumbnail" style={styles.thumbnail}>
          <img src={} style={styles.image} alt="..."/>
          <div className="caption">
            
            <p>{this.props.id}</p>
            <p>{this.props.isbn}</p>
            <p>{this.props.title}</p>
            <p>{this.props.author}</p>
            <p>{this.props.quantity}</p>
            <p>{this.props.publishedAt}</p>
            
            <p><button className="btn btn-primary" role="button">Details</button></p>
          </div>
        </div>
      </div>
    );
  }
});

BookCardComponent.propTypes = {
  id: PropTypes.number.isRequired,
  isbn: PropTypes.string.isRequired,
  title: PropTypes.string.isRequired,
  author: PropTypes.string.isRequired,
  quantity: PropTypes.number.isRequired,
  publishedAt: PropTypes.string.isRequired,
};

window.BookCardComponent = BookCardComponent;