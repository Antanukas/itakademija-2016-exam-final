var PropTypes = React.PropTypes;

var BookAdministrationComponent = function(props) {
  var title;

  if (props.id) {
    title = 'Update: ' + props.id;
  } else {
    title = 'Create new';
    //saveButton = <button className="btn btn-success" style={{ marginRight: '20px' }} onClick={props.onSaveClick}>Save</button>
  }
  return (
    <div>
      <h2>{title}</h2>
      <form>
        <div className="form-group">
          <label>Title: </label>
          <input className="form-control" value={props.title} onChange={props.onTitleChange} />
        </div>
        <div className="form-group">
          <label>Author: </label>
          <input className="form-control" value={props.author} onChange={props.onAuthorChange} />
        </div>
        <div className="form-group">
          <label>Published at: </label>
          <input className="form-control" value={props.publishedAt} onChange={props.onPublishedAtChange}/>
        </div>
        <div className="form-group"> <label>ISBN code: </label> <input className="form-control" value={props.isbn} onChange={props.onIsbnChange} />
        </div>
        <div className="form-group">
          <label>Quantity</label>
          <input
            className="form-control"
            value={props.quantity}
            onChange={props.onQuantityChange}
          />
        </div>
        <p><button className="btn btn-primary" role="button" Onclick={this.handleClickCreate()}>Create new</button></p>
      	<p><button className="btn btn-primary" role="button" Onclick={this.handleCancael()}>Update</button></p>
      </form>
    </div>
  );
};

BookAdministrationComponent.propTypes = {

  id: React.PropTypes.any,
  author: React.PropTypes.string.isRequired,
  title: React.PropTypes.string.isRequired,
  publishedAt: React.PropTypes.date.isRequired,
  isbn: React.PropTypes.string.isRequired,
  quantity: React.PropTypes.number.isRequired,

  onAuthorChange: React.PropTypes.func.isRequired,
  onTitleChange: React.PropTypes.func.isRequired,
  onPublishedAtChange: React.PropTypes.func.isRequired,
  onIsbnChange: React.PropTypes.func.isRequired,
  onQuantityChange: React.PropTypes.func.isRequired,
  onSaveClick: React.PropTypes.func.isRequired,
  onCancelClick: React.PropTypes.func.isRequired,
};

window.BookAdministrationComponent = BookAdministrationComponent;
