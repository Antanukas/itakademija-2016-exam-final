var Link = ReactRouter.Link;

function Header(props) {
	return (
		<nav className="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div className="container">
        <div className="navbar-header">
          <button type="button" className="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span className="sr-only">Toggle navigation</span>
            <span className="icon-bar"></span>
            <span className="icon-bar"></span>
            <span className="icon-bar"></span>
          </button>
          <a className="navbar-brand" href="#">IT Akademija</a>
        </div>
        <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul className="nav navbar-nav">
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/admin/books/new">Add book</Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
	);
}

window.Header = Header;