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

var ProductCardComponent = React.createClass({
    render: function() {
        return (
            <div className="col-sm-6 col-md-4">
                <div className="thumbnail" style={styles.thumbnail}>
                    <div className="caption">
                        <h3>{this.props.title}</h3>
                        <p>{this.props.author}</p>
                        <p>{this.props.id} </p>
                        <p><button className="btn btn-primary" role="button">Details</button></p>
                    </div>
                </div>
            </div>
        );
    }
});

ProductCardComponent.propTypes = {

    title: PropTypes.string.isRequired,
    author: PropTypes.string.isRequired,
    id: PropTypes.number.isRequired,
};

window.ProductCardComponent = ProductCardComponent;