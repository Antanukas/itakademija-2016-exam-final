
var HelloWorldComponent = React.createClass({
  render: function() {
    return (
      <div>Hello from React component</div>
    );
  }
});

var ProductCardComponent = React.createClass({
    render: function() {
        return (
            <div className="col-sm-6 col-md-4">
              <div>
                <img src={this.props.image} style={styles.image} alt="..."/>
                <div className="caption">
                  <h3>{this.props.title}</h3>
                  <p>{this.props.description}</p>
                  <p>{this.props.author} Eur</p>
                  <p><button className="btn btn-primary" role="button">Details</button></p>
                    <p><button className="btn btn-primary" role="button">Details</button></p>
                </div>
              </div>
            </div>
        );
    }
});

window.HelloWorldComponent = HelloWorldComponent;
