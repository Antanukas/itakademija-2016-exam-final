var BookListComponent = function (props) {
	var BookCards = props.books.map(function(book, index){
		return (
			<BookCardComponent
				key = {index}
				id = {Book.id}
				isbn = {Book.isbn}
				title = {Book.title}
				author = {Book.author}
				quantity = {Book.quantity}
				publishedAt = {Book.publishedAt}
				/>
		);
	});
	return(<div className = "row">{BookCards}</div>);
};
BookListComponent.propTypes = {
	products: React.propTypes.array.isRequired,
	onDetailsClick: React.propTypes.func.isRequired,
};
window.BookListComponent = BookListComponent;
