var PropTypes = React.PropTypes;




var AdminComponent = function(props) {
        return (
               <div>
                <h2>Admin</h2>
                <form >
                  <div className="form-group">
                    <label>Title</label>
                    <input className="form-control" value={props.title} onChange={props.onTitleChange} />
                  </div>
                  <div className="form-group">
                    <label>Authors</label>
                    <input className="form-control" value={props.author} onChange={props.onAuthorChange} />
                  </div>
                  <div className="form-group">
                    <label>Quantity</label>
                    <input className="form-control" value={props.quantity} onChange={props.onQuantityChange} />
                  </div>
                  <div className="form-group">
                    <label>ISBN</label>
                    <input className="form-control" value={props.isbn} onChange={props.onISBNChange}/>
                  </div>
                  <div className="form-group">
                    <label>Published:</label>
                    <input className="form-control" value={props.publishedAt} onChange={props.onPublishChange}/>
                  </div>
                  <button className="btn btn-success" onClick={props.onSaveClick}>Save</button>
                  <button className="btn btn-success" onClick={props.onCancelClick}>Cancel</button>
                </form>
              </div>  
            );  
    };  



AdminComponent.propTypes = {
        //id: React.PropTypes.number.isRequired,
        author: React.PropTypes.string.isRequired,
        quantity: React.PropTypes.number.isRequired,
        isbn: React.PropTypes.string.isRequired,
        
        
        onTitleChange: React.PropTypes.func.isRequired,
        onAuthorChange: React.PropTypes.func.isRequired,
        onQuantityChange: React.PropTypes.func.isRequired,
        onISBNChange: React.PropTypes.func.isRequired,
        onSaveClick: React.PropTypes.func.isRequired,
        onCancelClick: React.PropTypes.func.isRequired,
        
        onPublishChange: React.PropTypes.func.isRequired,
        
}

window.AdminComponent = AdminComponent;