function ProductCardComponent(props) {
	return (
		<div className="col-md-4 portfolio-item">
			<a href="#">
        		<img className="img-responsive" src="http://placehold.it/700x400" alt="" />
        	</a>
	        <h3>
	        	<a href="#">{props.title}</a>
	        </h3>
	        <p>{props.description}</p>
        </div>			
	);
}

window.ProductCardComponent = ProductCardComponent;