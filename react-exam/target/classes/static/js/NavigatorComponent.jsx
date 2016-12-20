var Link = window.ReactRouter.Link;

var NavLink = function (props, context) {
  var isActive = context.router.isActive(props.to);
  var className = isActive ? 'active' : '';

  return (
    <li className = {className}>
      <Link {...props}>
        {props.children}
      </Link>
    </li>
  );
};

NavLink.contextTypes = {
  router: React.PropTypes.object,
};
NavLink.propTypes = {
  children: React.PropTypes.node.isRequired,
  to: React.PropTypes.string.isRequired,
};
var NavigationComponent = React.createClass({
  render: function () {
    return (
      <nav className = "navnar navbar-default">
        <div className = "coontainer-fluid">
          <ul className = "navbar navbar-nav">
            <NavLink to = "/books" onlyActiveOnIndex>Home</NavLink>
            <NavLink to = "/admin">admin</NavLink>
        </ul>
        </div>
      </nav>
    );
  }
});

window.NavigationComponent = NavigationComponent;
