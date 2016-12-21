var Link = ReactRouter.Link;

var Buttons = React.createClass({
    render: function() {
        return (
            <div>
                <Link to="/">
                    <button className="btn btn-success" style={{ marginRight: '20px' }} > Home</button>
                </Link>
                <Link to="/admin/products/new">
                    <button className="btn btn-success" style={{ marginRight: '20px' }}>Insert new Book</button>
                </Link>
                <hr>
                </hr>
                {this.props.children}
            </div>
        );
    }
});

window.Buttons = Buttons;
