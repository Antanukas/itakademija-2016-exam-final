var PropTypes = window.React.PropTypes;
var Link = ReactRouter.Link;

var FormComponent = function(props) {
  var title;
  if (props.id) {
    title = 'Atnaujinamas produktas ' + props.params.id;
  } else {
    title = 'Kuriamas naujas produktas';
  }

  return (
    <div>
      <h2>Atnaujinimo/išsaugojimo forma</h2>
      <form>
        <div className="form-group">
          <label>Title</label>
          <input className="form-control" value={props.title} onChange={props.onTitleChange} />
        </div>
        <div className="form-group">
          <label>Author</label>
          <input
            className="form-control"
            value={props.author}
            onChange={props.onAuthorChange}
          />
        </div>
        <div className="form-group">
          <label>Quantity</label>
          <input
            className="form-control"
            value={props.quantity}
            onChange={props.onQuantityChange}
          />
        </div>
        <div className="form-group">
          <label>ISBN</label>
          <input
            className="form-control"
            value={props.isbn}
            onChange={props.onIsbnChange}
          />
        </div>
        <Link to="/">
          <button className="btn btn-success" style={{ marginRight: '20px' }} role="button" onClick={props.onSaveClick}>
            Save
          </button>
        </Link>
        <Link to="/">
          <button className="btn btn-danger" style={{ marginRight: '20px' }} role="button">Atšaukti</button>
        </Link>
      </form>
    </div>
  );
};

FormComponent.propTypes = {
  id: React.PropTypes.string,
  title: React.PropTypes.string.isRequired,
  author: React.PropTypes.string.isRequired,
  isbn: React.PropTypes.any.isRequired,
  quantity: React.PropTypes.any.isRequired,

  onTitleChange: React.PropTypes.func.isRequired,
  onAuthorChange: React.PropTypes.func.isRequired,
  onIsbnChange: React.PropTypes.func.isRequired,
  onQuantityChange: React.PropTypes.func.isRequired,
  onSaveClick: React.PropTypes.func.isRequired,
};

window.FormComponent = FormComponent;
