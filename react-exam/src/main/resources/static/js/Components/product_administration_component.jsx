var Link = ReactRouter.Link;

var PropTypes = React.PropTypes;

var ProductAdministrationComponent = function (props) {
    var title;
    var saveButton;
    if (props.id) {
        title = 'Updating product number : ' + props.id;

    } else {
        title = 'Creating new product';

    }
    return (
        <div>
            <h2>{title}</h2>
            <form>
                <div className="form-group">
                    <label>ISBN</label>
                    <input className="form-control" value={props.isbn} onChange={props.onIsbnChange}/>
                </div>
                <div className="form-group">
                    <label>Title</label>
                    <input className="form-control" value={props.title} onChange={props.onTitleChange}/>
                </div>
                <div className="form-group">
                    <label>Author</label>
                    <input className="form-control" value={props.author} onChange={props.onAuthorChange}/>
                </div>
                <div className="form-group">
                    <label>Quantity</label><input className="form-control" value={props.quantity}
                                                  onChange={props.onQuantityChange}/>
                </div>
                <Link to="/">
                    <button className="btn btn-success" style={{marginRight: '20px'}} onClick={props.onSaveClick}>Save
                    </button>
                </Link>
                <Link to="/">
                    <button className="btn btn-danger" style={{marginRight: '20px'}} role="button">Cancel</button>
                </Link>
            </form>
        </div>
    );
};

ProductAdministrationComponent.propTypes = {
    id: React.PropTypes.any,
    isbn: React.PropTypes.string.isRequired,
    title: React.PropTypes.string.isRequired,
    author: React.PropTypes.string.isRequired,
    quantity: React.PropTypes.any.isRequired,
    publishedAt: React.PropTypes.any.isRequired,

    onIdChange: React.PropTypes.func.isRequired,
    onIsbnChange: React.PropTypes.func.isRequired,
    onTitleChange: React.PropTypes.func.isRequired,
    onAuthorChange: React.PropTypes.func.isRequired,
    onQuantityChange: React.PropTypes.func.isRequired,
    onPublishedAtChange: React.PropTypes.func.isRequired,
};

window.ProductAdministrationComponent = ProductAdministrationComponent;