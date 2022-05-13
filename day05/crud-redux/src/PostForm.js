/*import React, { Component } from 'react';

class PostForm extends Component {
    render() {
        return (
        <div>
        <h1>Create Post</h1>
        <form>
        <input required type="text" placeholder="Enter Post Title" /><br /><br />
        <textarea required rows="5" cols="28" placeholder="Enter Post" /><br /><br />
        <button>Post</button>
        </form>
        </div>
        );
    }
}
export default PostForm;
*/
import React, { Component } from 'react';

class PostForm extends Component {

    //함수 추가하기 
    handleSubmit = (e) => {
        //본래 기능 막고 
        e.preventDefault();
        const name = this.getName.value;
        const description =  this.getDescription.value;
        
        const data = {
            id:'',
            name:name,
            description:description
        }

        //추가
        console.log(data)
        //this.props.dispatch({ type:'ADD_POST',  data});

        this.props.onAddPost(data);
        //console.log("333");

        this.getName.value = '';
        this.getDescription.value = '';


    }
    render() {
        return (

            <div className="post-container">
                <h1 className="post_heading">Create Post</h1>
                    <form  className="form" onSubmit={this.handleSubmit}>
                        <input required type="text" ref={(input)=>this.getName = input} 
                            placeholder="Enter Post Title"/>
                        <br /><br />
                        <textarea required rows="5" ref={(input)=>this.getDescription = input} cols="28" 
                            placeholder="Enter Post" />
                        <br /><br />
                        <button>Post</button>
                    </form>
            </div>
        );
    }
}
export default PostForm;

/*
const mapDispatchToProps = (dispatch)=> {
    return {
      onAddPost: data => {
        //createPost(data);
        dispatch(createPost(data));
      }
    };
};
  

export default connect(mapDispatchToProps)(PostForm);
*/

