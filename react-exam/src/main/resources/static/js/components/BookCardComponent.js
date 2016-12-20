var Link = ReactRouter.Link;

function ProductCardComponent(props) {
	var editPath = "admin/books/" + props.id + "/edit";
	return (
		<div className="col-md-4 portfolio-item">
			<h5 style={{ display: 'inline-block' }}>Book ID: {props.id}</h5> &nbsp;
			<Link to={editPath} className="btn btn-warning btn-sm">Edit book</Link>
			<a href="#">
        		<img className="img-responsive" src="http://placehold.it/700x400" alt="" />
        	</a>
        	<h4>Author:</h4>
        	<h5>{props.author}</h5>
        	<h3><a href="#">{props.title}</a></h3>
        </div>			
	);
}

window.ProductCardComponent = ProductCardComponent;