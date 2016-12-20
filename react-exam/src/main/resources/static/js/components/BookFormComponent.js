function BookFormComponent(props) {
	return (
	<div style={{ marginTop: '10vh' }}>
		<h3>Book {props.action} Form</h3>
		<form onSubmit={props.submit}>
			<div className="form-group row">
			    <label htmlFor="inputTitle" className="col-sm-2 col-form-label">Title</label>
			    <div className="col-sm-10">
			      <input type="text" value={props.title} className="form-control" id="inputTitle" onChange={props.changeTitle} />
			    </div>
		    </div>
			<div className="form-group row">
				<label htmlFor="inputAuthor" className="col-sm-2 col-form-label">Author(s)</label>
				<div className="col-sm-10">
					<input type="text" value={props.author} className="form-control" id="inputAuthor" onChange={props.changeAuthor} />
				</div>
			</div>
			<div className="form-group row">
				<label htmlFor="inputQuantity" className="col-sm-2 col-form-label">Quantity</label>
				<div className="col-sm-10">
					<input type="number" value={props.quantity} className="form-control" id="inputPrice" step={1} min={1} onChange={props.changeQuantity} />
				</div>
			</div>
			<div className="form-group row">
				<label htmlFor="inputIsbn" className="col-sm-2 col-form-label">ISBN</label>
				<div className="col-sm-10">
					<input type="text" value={props.isbn} className="form-control" id="inputIsbn" onChange={props.changeIsbn} />
				</div>
			</div>
			<button type="submit" className="btn btn-primary btn-lg">{props.action}</button>&nbsp;
			<button type="submit" className="btn btn-warning btn-lg" onClick={props.cancel}>Cancel</button>
		</form>	
	</div>
	);
};

window.BookFormComponent = BookFormComponent;