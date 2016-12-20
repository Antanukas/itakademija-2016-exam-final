var PropTypes = React.PropTypes;

var BookAdministrationComponent = React.createClass({

  render: function() {
    var title;
    var submitButton;
    if (this.props.id) {
      title = 'Atnaujinamas produktas ' + this.props.id;
      submitButton =  <button className="btn btn-success" onClick={this.props.onSaveClick}>Edit</button>

    } else {
      title = 'Kuriamas naujas produktas';
      submitButton = <button className="btn btn-success" onClick={this.props.onSaveClick}>Submit</button>
    };
    return (
      <div className='col-sm-4'>
        <h2>Book admin comp</h2>
        <form className="form">
          <div className="form-group">
            <label>Title</label>
            <input
              type="text"
              className="form-control"
              value={this.props.title}
              onChange={this.props.onTitleChange}
              id="exampleInputName2"
              placeholder="The title of your book"
              />
          </div>
          <div className="form-group">
            <label>Authors</label>
            <input
              type="text"
              className="form-control"
              value={this.props.authors}
              onChange={this.props.onAuthorsChange}
              id="exampleInputName2"
              placeholder="Author or authors of the book"
              />
          </div>
          <div className="form-group">
            <label>ISBN</label>
            <input
              type="text"
              className="form-control"
              value={this.props.isbn}
              onChange={this.props.onIsbnChange}
              id="exampleInputName2"
              placeholder="ISBN"
              />
          </div>
          <div className="form-group">
            <label>Quantity</label>
            <input
              type="text"
              className="form-control"
              id="exampleInputName2"
              placeholder="Quantity"
              value={this.props.value}
              onChange={this.props.onQuantityChange}
              />
          </div>

          {submitButton} <button href="/">Cancel</button>
        </form>
      </div>
    );
  }

});

window.BookAdministrationComponent = BookAdministrationComponent;
