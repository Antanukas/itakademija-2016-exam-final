var PropTypes = React.PropTypes;

var styles = {
    thumbnail: {
        maxWidth: '242px',
        textAlign: 'center',
        marginLeft: 'auto',
        marginRight: 'auto',
    },
    image: { width: '100%', height: '200px', display: 'block' }
};

var BookCardComponent = React.createClass( {
    render: function() {
        return (
            <div className="col-sm-6 col-md-4">
                <div className="thumbnail" style={styles.thumbnail}>
                    <img src="http://placehold.it/200x150" style={styles.thumbnail} />
                    <div className="Caption">
                        <h3>{this.props.title}</h3>
                        <p>{this.props.author}</p>
                        <p>{this.props.id}</p>
                    </div>
                </div>
            </div>
        );
    }
});

BookCardComponent.propTypes = {
        id: PropTypes.number.isRequired,
        image: PropTypes.string.isRequired,
        title: PropTypes.string.isRequired,
        author: PropTypes.string.isRequired,
        isbn: PropTypes.string.isRequired,
        publishedAt: PropTypes.string.isRequired,
        quantity: PropTypes.number.isRequired
};

window.BookCardComponent = BookCardComponent;