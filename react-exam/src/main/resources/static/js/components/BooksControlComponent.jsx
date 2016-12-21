var PropTypes = React.PropTypes;
var Link = ReactRouter.Link;

var BooksControlComponent = function(props) {
  var title;
  var saveButton;
  var cancelButton;
  if (props.id) {
    title = 'Updating Book ' + props.id;
    saveButton = <button className="savebtn btn btn-success" style={{ marginRight: '20px' }} onClick={props.onSaveClick}>Update Book</button>
    cancelButton = <button className="cancelbtn btn btn-success" style={{ marginRight: '20px' }}>Cancel</button>
  } else {
    title = 'Adding New Book';
    saveButton = <button className="savebtn btn btn-success" style={{ marginRight: '20px' }} onClick={props.onSaveClick}>Save</button>
    cancelButton = <button className="cancelbtn btn btn-success" style={{ marginRight: '20px' }}>Cancel</button>
  }

  return (
    <div>
      <h2>{title}</h2>
      <form>
          <div className="form-group">
            <label>Title</label>
            <input className="form-control" value={props.title} onChange={props.onTitleChange} />
          </div>
          <div className="form-group">
            <label>Authors</label>
            <input
              className="form-control"
              value={props.author}
              onChange={props.onAuthorChange}
            />
          </div>
          <div className="form-group">
            <label>Quantity</label>
            <input className="form-control" value={props.quantity} onChange={props.onQuantityChange} />
          </div>
          <div className="form-group">
            <label>ISBN</label>
            <input className="form-control" value={props.isbn} onChange={props.onIsbnChange} />
          </div>
            <Link to='/'>
              {saveButton}
            </Link>
            <Link to='/'>
              {cancelButton}
            </Link>
      </form>
    </div>
  );
};

BooksControlComponent.propTypes = {
  id: React.PropTypes.any,
  title: React.PropTypes.string.isRequired,
  author: React.PropTypes.string.isRequired,
  quantity: React.PropTypes.number.isRequired,
  isbn: React.PropTypes.string.isRequired,

  onTitleChange: React.PropTypes.func.isRequired,
  onAuthorChange: React.PropTypes.func.isRequired,
  onSaveClick: React.PropTypes.func.isRequired,
  onQuantityChange: React.PropTypes.func.isRequired,
  onIsbnChange: React.PropTypes.func.isRequired
};

window.BooksControlComponent = BooksControlComponent;
