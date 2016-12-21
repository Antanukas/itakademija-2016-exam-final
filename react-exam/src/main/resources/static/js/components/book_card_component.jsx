var PropTypes = React.PropTypes;

var BookCardComponent = React.createClass({
    render: function() {
        return (
                <div className="col-sm-6 col-md-4">
                <div className="thumbnail" >
                  <div className="caption">
                    <p>{this.props.id}</p>
                    <p>{this.props.title}</p>
                    <p>{this.props.author}</p>
                    <p>{moment(this.props.publishedAt).format("YYYY-MM-DD")}</p>
                  </div>
                </div>
              </div>    
        );
    }
});


BookCardComponent.propTypes = {
        id: PropTypes.number.isRequired,
        title: PropTypes.string.isRequired,
        author: PropTypes.string.isRequired,
       
};

window.BookCardComponent = BookCardComponent;