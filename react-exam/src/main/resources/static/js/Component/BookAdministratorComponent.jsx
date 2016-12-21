var PropTypes = React.PropTypes;

var BookAdministratorComponent = function( props ) {
    var title;
    var save;
    if ( props.id ) {
        title = 'update book' + props.id;
        updateButton = <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={props.onSaveClick}>Update</button>
    } else {
        tite = 'new book'
        createButton = <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={props.onSaveClick}>Create</button>
    }

    return (
            <div>
            <h2>{title}</h2>
            <form>
                <div className="form-group">
                    <label>Id</label>
                    <input className="form-control" value={props.id} onChange={props.onIdChange} />
                </div>
                <div className="form-group">
                    <label>ISBN</label>
                    <input className="form-control" value={props.isbn} onChange={props.onIsbnChange} />
                </div>
                <div className="form-group">
                    <label>Title</label>
                    <input className="form-control" value={props.title} onChange={props.onTitleChange}/>
                </div>
                <div className="form-group">
                    <label>Author</label>
                    <input className="form-control" value={props.author} onChange={props.onAuthorChange} />
                </div>
                <div className="form-group">
                    <label>Quantity</label><input className="form-control" value={props.quantity}
                                                  onChange={props.onQuantityChange}/>
                </div>
                <div className="form-group">
                    <label>Published At</label>
                    <input className="form-control" value={props.publishedAt} onChange={props.onPublishedAtChange} />
                </div>
                {saveButton}
            </form>
        </div>
    );
};

ProductAdministrationComponent.propTypes = {
        id: React.PropTypes.number.isRequired,
        isbn: React.PropTypes.string.isRequired,
        title: React.PropTypes.string.isRequired,
        author: React.PropTypes.string.isRequired,
        quantity: React.PropTypes.number.isRequired,
        publishedAt: React.PropTypes.date.isRequired,

        onIdChange: React.PropTypes.func.isRequired,
        onIsbnChange: React.PropTypes.func.isRequired,
        onTitleChange: React.PropTypes.func.isRequired,
        onAuthorChange: React.PropTypes.func.isRequired,
        onQuantityChange: React.PropTypes.func.isRequired,
        onPublishedAtChange: React.PropTypes.func.isRequired,
    };

window.BookAdministratorComponent = BookAdministratorComponent;