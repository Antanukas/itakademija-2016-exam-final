var PropTypes = React.PropTypes;

var bookListComponent = function(props) {
    var bookCards = props.products.map(function (product, index) {
        return (
            <ProductCardComponent
                key={index}
                id={product.id}
                title={product.title}
                author={product.author}
            />
        );
    });
    return (
        <div className="row">{bookCards}</div>
    );
};

ProductListComponent.propTypes = {
    products: React.PropTypes.array.isRequired,
};

window.ProductListComponent = ProductListComponent;