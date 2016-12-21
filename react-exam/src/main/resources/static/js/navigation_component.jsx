var Link = ReactRouter.Link;
var IndexLink = ReactRouter.IndexLink;

var Nav = React.createClass({
    render: function () {
      return (
        <div>
            <nav className="navbar navbar-light bg-faded">
              <ul className="nav navbar-nav">
                  <li className="nav-item">
                        <IndexLink to="/" activeClassName="active" >Home</IndexLink>
                   </li>
                   <li className="nav-item"> 
                        <Link to="/new" activeClassName="active" >Add new book</Link>
                   </li>   
                   <li className="nav-item"> 
                        <Link to="/update" activeClassName="active" >Update book</Link>
                   </li>  
                   
                
                
              </ul>
            </nav>
        </div>
      );
    }
});

window.Nav = Nav;