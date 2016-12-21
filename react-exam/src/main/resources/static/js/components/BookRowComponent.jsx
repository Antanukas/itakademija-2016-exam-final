var Link = ReactRouter.Link;

var BookRowComponent = function(props) {
    var date = props.publishedAt != null ? moment(props.publishedAt).format('YYYY-MM-DD') : ""
    return (
        <tr>
            <td>{props.id}</td>
            <td>{props.title}</td>
            <td>{props.author}</td>
            <td>{date}</td>
            <td>
                <Link to={"books/" + props.id} >
                    <button type="button" className="btn btn-primary">Edit</button>
                </Link>
            </td>
        </tr>
    );
}

BookRowComponent.propTypes = {
    id: React.PropTypes.number.isRequired,
    title: React.PropTypes.string.isRequired,
    author: React.PropTypes.string.isRequired,
    isbn: React.PropTypes.string.isRequired,
    quantity: React.PropTypes.number.isRequired,
    publishedAt: React.PropTypes.number
}

window.BookRowComponent = BookRowComponent;