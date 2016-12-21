

var BookAdministration = React.createClass( {
    getInitialState: function() {
        return {
            title: '',
            author: '',
        };
    },

    handleSaveClick: function( e ) {
        console.log( this.state );
        e.preventDefault();
    },

    handleTitleChange: function( event ) {
        this.setState( { title: event.target.value });
    },

    onTitleChange: function( e ) {
        this.setState( { title: e.target.value });
    },

    onAuthorChange: function( e ) {
        this.setState( { author: e.target.value });
    },

    handleSubmit: function( event ) {   //ateityje handleSubmit paskirtis pakviesti serverį (REST Api) ir nusiųsti duomenis
        console.log( 'title: ' + this.state.title );
        console.log( 'author: ' + this.state.author );
        this.setState( { title: '' });
        this.setState( { author: '' });
    },

    render: function() {

        return (
            <div>
                <form className="form-horizontal" onSubmit={this.handleSubmit}>

                    <div className="form-group">
                        <label htmlFor="exampleInputName2" className="col-sm-2 control-label">Title</label>
                        <div className="col-sm-10">
                            <input type="text" className="form-control" id="title" placeholder="Title" onChange={this.handleTitleChange} />
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="exampleInputName2" className="col-sm-2 control-label">Author</label>
                        <div className="col-sm-10">
                            <input type="text" className="form-control" id="author" placeholder="Author" onChange={this.handleImageUrlChange} />
                        </div>
                    </div>


                </form>
            </div>
        );
    },


})


window.BookAdministration = BookAdministration;
