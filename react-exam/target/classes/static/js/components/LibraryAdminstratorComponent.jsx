var Link = ReactRouter.Link;

var LibraryAdministartorComponent = React.createClass({

  render: function() {
    return (
      <div>
        <form>
            
          <div className="form-group">
            <label>Title</label>
            <input className="form-control"
              value={this.props.book.title}
              onChange={this.props.onFieldChange('title')} />
          </div>
            
          <div className="form-group">
            <label>Author</label>
            <input className="form-control"
              value={this.props.book.author}
              onChange={this.props.onFieldChange('author')} />
          </div>
            
          <div className="form-group">
            <label>Isbn</label>
            <input
              className="form-control"
              value={this.props.book.Isbn}
              onChange={this.props.onFieldChange('Isbn')}
            />
        </div>
            
          <div className="form-group">
            <label>Quantity</label>
            <input
              className="form-control"
              value={this.props.book.quantity}
              onChange={this.props.onFieldChange('quantity')}
            />
          </div>
            
          <div className="form-group">
            <label>Published at</label>
            <innput
              className = 'form-control'
              value = {this.props.book.publishedAt} />
          </div>
            
          <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={this.props.onSaveClick}>Save</button>
          <Link to="re/admin/books" className="btn btn-default">Cancel</Link>
        </form>
      </div>);
  }
});

LibraryAdministrationComponent.propTypes = {
  book: React.PropTypes.object.isRequired,
  onSaveClick: React.PropTypes.func.isRequired,
  onFieldChange: React.PropTypes.func.isRequired
};

window.LibraryAdministartorComponent = LibraryAdministratorComponent;
