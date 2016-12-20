var PropTypes = React.PropTypes;

var BookAdministrationComponent = React.createClass({

  render: function() {

    var title;
    var submitButton;
    if (this.props.id) {
      title = 'Atnaujinama knyga # ' + this.props.id;
      submitButton =  <button className="btn btn-success" onClick={this.props.onSaveClick} href="#/books">Edit</button>

    } else {
      title = 'Pridedama nauja knyga';
      submitButton = <button className="btn btn-success" onClick={this.props.onSaveClick} href="#/">Submit</button>
    };
    console.log("ADMIN COMPONENT:");
    console.log(this);
    return (
      <div className='col-sm-4'>
        <h2>{title}</h2>
        <form className="form">
          <div className="form-group">
            <label>Title</label>
            <input
              type="text"
              className="form-control"
              value={this.props.title}
              onChange={this.props.onTitleChange}
              id="exampleInputName2"
              placeholder={this.props.title}
              />
          </div>
          <div className="form-group">
            <label>Authors</label>
            <input
              type="text"
              className="form-control"
              value={this.props.author}
              onChange={this.props.onAuthorsChange}
              id="exampleInputName2"
              placeholder={this.props.author}
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
              placeholder={this.props.isbn}
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

          {submitButton} <button onClick={this.props.onCancelCLick} href='/'>Cancel</button>
        </form>
      </div>
    );
  }

});

window.BookAdministrationComponent = BookAdministrationComponent;
