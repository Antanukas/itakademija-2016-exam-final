var BookCardComponent = React.createClass({
  render: function(){
    <div className="col-sm-6 col-md-4">
      <div className="caption">
        <h3>(this.props.id)</h3>
        <p>(this.props.title)</p>
        <p>(this.props.author)</p>
        <p><button className = "btn-primary" role = "button" onClick={this.props.onDetailsClick(this.props.id)}>Details</button></p>
    </div>
    </div>
  }
});

BookCardComponent.propTypes = {
  id: propTypes.number.isRequired,
  isbn: propTypes.string.isRequired,
  title: propTypes.string.isRequired,
  author: propTypes.string.isRequired,
  quantity: propTypes.number.isRequired,
  publishedAt: propTypes.Date.isRequired,
};

window.BookCardComponent = BookCardComponent;
