function ProductsListComponent(props) {
	//console.log(props.products);
	return (
    <div className="row">
      {props.products}
    </div>
  );	
}

window.ProductsListComponent = ProductsListComponent;