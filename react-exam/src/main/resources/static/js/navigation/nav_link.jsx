var Link = ReactRouter.Link;

var NavLink = React.createClass({
  render() {
    return <Link {...this.props} activeClassName="active" />
  }
})

window.NavLink = NavLink;
