

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

        var title;
        if ( this.props.params.id ) {
            title = 'Atnaujinamas produktas ' + this.props.params.id;
        } else {
            title = 'Kuriamas naujas produktas';
        }
        
        
        return (
            <div>
                <h4><b>{title}</b></h4>
                <form className="form-horizontal" onSubmit={this.handleSubmit}>

                    <div className="form-group">
                        <label htmlFor="exampleInputName2" className="col-sm-2 control-label">Title</label>
                        <div className="col-sm-10">
                            <input type="text" className="form-control" id="title" placeholder="Enter book title here" onChange={this.handleTitleChange} />
                        </div>
                    </div>

                    <div className="form-group">
                        <label htmlFor="exampleInputName2" className="col-sm-2 control-label">Author</label>
                        <div className="col-sm-10">
                            <input type="text" className="form-control" id="author" placeholder="Book author input place" onChange={this.handleImageUrlChange} />
                        </div>
                    </div>

                    <div className="form-group">
                        <div className="col-sm-offset-2 col-sm-10">
                            <button type="submit" className="btn btn-success btn-md">Išsaugoti</button>
                        </div>
                    </div>
                    <div className="form-group">
                        <div className="col-sm-offset-2 col-sm-10">
                            <button type="cancel" className="btn btn-danger btn-md">Atšaukti</button>
                        </div>
                    </div>


                </form>
            </div>
        );
    },


})


window.BookAdministration = BookAdministration;
