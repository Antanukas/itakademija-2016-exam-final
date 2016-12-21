var AdminContainer = React.createClass({
    getInitialState: function () {
        return {
            id: this.props.params.id,
            title: '',
            author: '',
            quantity: 0,
            isbn: 0,
            publisheAt: 0
       
        };
    },
    
    handleTitleChange: function(e) {
        this.setState({ title: e.target.value});
    },
    
    handleAuthorChange: function(e) {
        this.setState({ author: e.target.value});
    },
    
    handleQuantityChange: function(e) {
        this.setState({ quantity: e.target.value});
    },
    
    handleISBNChange: function(e) {
        this.setState({ isbn: e.target.value});
    },
    
    handlePublishChange: function(e) {
        this.setState({ publishedAt: e.target.value});
    },
    
    handleSaveClick: function(e) {
        var self = this;
        var body = {
              title: this.state.title,
              author: this.state.author,
              quantity: this.state.quantity,
              isbn: this.state.isbn,
              publishedAt: this.state.publishedAt
        }
        axios.post('http://localhost:8080/api/books', body)
            .then(function (response) {
                var p = response.data;
                    self.setState({
                        id: p.id,
                        title: p.title,
                        author: p.author,
                        isbn: p.isbn,
                        publishedAt: p.publishedAt
                    });
                    self.props.history.replaceState(null, "/");
                });
                e.preventDefault();
    },
    
    handleCancelClick: function() {
        this.props.history.replaceState(null, "/");
    },
    
 
    
    render: function () {
        return (
          <AdminComponent
             id={this.state.id}
             title={this.state.title}
             author={this.state.author}
             quantity={this.state.quantity}
             isbn={this.state.isbn}
             publishedAt={this.state.publishedAt}
             onTitleChange={this.handleTitleChange}
             onAuthorChange={this.handleAuthorChange}
             onQuantityChange={this.handleQuantityChange}
             onISBNChange ={this.handleISBNChange}
             onSaveClick={this.handleSaveClick}
             onCancelClick={this.handleCancelClick}
             onPublishChange={this.handlePublishChange}
          />
        );
    }
});


window.AdminContainer = AdminContainer;