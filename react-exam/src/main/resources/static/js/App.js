var App = React.createClass({
  render: function() {
    return (
    <div>
        <Header />

        {this.props.children}

        <Footer />
    </div>
    );
  }
});

window.App = App;
