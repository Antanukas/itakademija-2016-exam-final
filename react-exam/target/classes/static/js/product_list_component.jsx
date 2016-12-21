var PropTypes = React.PropTypes;

var ProductListComponent = function(props) {
  var productCards = props.products.map(function (product, index) {
    return (
      <ProductCardComponent
        key={index}
        id={product.id}
        title={product.title}
        description={product.author}
      />
    );
  });
  return (
    <div className="row">
      {productCards}</div>
    );
};

ProductListComponent.propTypes = {
  products: React.PropTypes.array.isRequired,
};

window.ProductListComponent = ProductListComponent;