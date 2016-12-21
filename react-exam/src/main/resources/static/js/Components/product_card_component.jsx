var Link = ReactRouter.Link;

var PropTypes = React.PropTypes;


var styles = {
    thumbnail: {
        maxWidth: '250px',
        textAlign: 'center',
        marginLeft: 'auto',
        marginRight: 'auto'
    },
};

var ProductCardComponent = React.createClass({
    render: function () {
        var linkTo = "/admin/products/" + this.props.id;
        return (
            <div className="col-sm-6 col-md-4">
                <div className="thumbnail" style={styles.thumbnail}>
                    <div className="caption" style={{height: 275, weight: 150} }>
                        <h3>{this.props.title}</h3>
                        <p>{this.props.author}</p>
                        <p>{this.props.id} </p>
                        <p>{moment(this.props.publishedAt).format('MM/DD/YYYY')}</p>
                    </div>
                    <Link to={linkTo}>UPDATE</Link>
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