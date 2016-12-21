var Navigation = React.createClass({
  render: function() {
    return (
      <div>
        <nav className="navbar navbar-default" role="navigation">
          <div className="collapse navbar-collapse">
            <ul className="nav navbar-nav">
              <li><NavLink to="/">Home</NavLink></li>
              <li><NavLink to="/form">Form</NavLink></li>
            </ul>
          </div>
        </nav>
        {this.props.children}
      </div>
    );
  }
});

window.Navigation = Navigation;
