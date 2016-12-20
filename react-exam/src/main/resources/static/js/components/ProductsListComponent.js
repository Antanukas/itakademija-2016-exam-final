function ProductsListComponent(props) {
	return (
    <div className="row">
      {props.products}
    </div>
  );	
}

window.ProductsListComponent = ProductsListComponent;