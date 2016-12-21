var PropTypes = window.React.PropTypes;

function ProductsListComponent(props) {
	//console.log(props.products);
	return (
    <div className="row">
      {props.products}
    </div>
  );	
}

ProductsListComponent.propTypes = {
	products: PropTypes.array.isRequired,
};

window.ProductsListComponent = ProductsListComponent;