var AddBookComponent = React.createClass( {
    render: function() {
        return (
            <form>
                <h3>Add new book</h3>
                
                <label>Title:</label><br />
                <input className="form-control" type="text" value={this.props.book.title} onChange={this.props.onFieldChange('title')} /><br />
                <label>Author(s)</label><br />
                <input className="form-control" type="text" value={this.props.book.author} onChange={this.props.onFieldChange('author')} /><br /> 
                <label>ISBN</label><br />
                <input className="form-control" type="text" value={this.props.book.isbn} onChange={this.props.onFieldChange('isbn')} /><br />
                <label>Quantity:</label>
                <input className="form-control" type="number" value={this.props.book.quantity} onChange={this.props.onFieldChange('quantity')}/><br />
                <label>Date:</label><br />
                <input className="form-control" type="date" value={this.props.book.publishedAt} onChange={this.props.onFieldChange('publishedAt')} /><br /> 
                <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onSaveClick}  >Add</button>
                <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onCancelClick}  >Cancel</button>
            </form>
        )
    }
});

AddBookComponent.propTypes = {
    book: React.PropTypes.object.isRequired,
    onFieldChange: React.PropTypes.func.isRequired,
    onSaveClick: React.PropTypes.func.isRequired
};

window.AddBookComponent = AddBookComponent;