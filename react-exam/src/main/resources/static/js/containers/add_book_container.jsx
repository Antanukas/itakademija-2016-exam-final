var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        var date = d.getDate();
        if (month < 10) {
            month = '0' + month;
        }
        if (date < 10) {
            date = '0' + date;
        }
        var fullDate = year + '-' + month + '-' + date;


var AddBookContainer = React.createClass( {
    getInitialState: function() {
        return {
            book: {
                publishedAt: fullDate,
                title: '',
                author: '',
                isbn: '',
                quantity: ''
            }
        }
    },
    
    handleSaveClick: function(e) {
        e.preventDefault();
        var self = this;
        axios.post('/api/books', this.state.book).then(function () {
            console.log('book added');
            self.context.router.push('/');
          });
    },
    
    handleFieldChange: function(fieldName) {
        var self = this;
        return function(e) {
          var book = self.state.book;
          book[fieldName] = e.target.value;
          self.setState({ book: book });
        };
    },
    
    handleCancelClick() {
        this.context.router.push('/');
    },
      
    render: function() {
        return (
            <AddBookComponent
                book={this.state.book}
                onSaveClick={this.handleSaveClick}
                onCancelClick={this.handleCancelClick}
                onFieldChange={this.handleFieldChange}
                />
        );
    }

});

AddBookContainer.contextTypes = {
        router: React.PropTypes.object.isRequired,
};

window.AddBookContainer = AddBookContainer;