var BookEditComponent = function(props) {
    var date = props.publishedAt != null ? moment(props.publishedAt).format('YYYY-MM-DD') : ""
    return (
        <div className="col-sm-6">
            <form>
                <div className="form-group">
                    <label>Title:</label>
                    <input type="text" className="form-control" name="title" 
                            onChange={props.onChangeField('title')} value={props.title}/>
                </div>
                <div className="form-group">
                    <label>Author(s):</label>
                    <input type="text" className="form-control" name="author" 
                            onChange={props.onChangeField('author')} value={props.author}/>
                </div>
                <div className="form-group">
                    <label>Quantity</label>
                    <input type="number" className="form-control" name="quantity" 
                            onChange={props.onChangeField('quantity')} value={props.quantity}/>
                </div>
                <div className="form-group">
                    <label>ISBN</label>
                    <input type="text" className="form-control" name="isbn" 
                            onChange={props.onChangeField('isbn')} value={props.isbn}/>
                </div>
                <button onClick={props.onSubmit} type="button" className="btn btn-primary">Save</button>
                <button onClick={props.onCancel} type="button" className="btn btn-primary">Cancel</button>
            </form>
        </div>
    )
};

BookEditComponent.propTypes = {
    title: React.PropTypes.string.isRequired,
    author: React.PropTypes.string.isRequired,
    isbn: React.PropTypes.string.isRequired,
    quantity: React.PropTypes.number.isRequired,
    onChangeField: React.PropTypes.func.isRequired,
    onSubmit: React.PropTypes.func.isRequired,
    onCancel: React.PropTypes.func.isRequired
}

window.BookEditComponent = BookEditComponent;