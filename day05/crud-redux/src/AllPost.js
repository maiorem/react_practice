/*import React, { Component } from 'react';

class AllPost extends Component {
  render() {
    return (
    <div>
      <h1>All Posts</h1>
    </div>
    );
   }
}

export default AllPost;
*/
import React, { Component } from 'react';

import { connect } from 'react-redux';
import Post from './post';

import EditComponent from './EditComponent';

class AllPost extends Component {
    
    render() {
        return (
            <div className="post_heading">
                <h1>All Posts</h1>

                {
                    this.props.posts.map((post) => (
                    <div key={post.id}>
                        {post.editing ? 
                            <EditComponent post={post} key={post.id} /> :
                            <Post key={post.id} post={post} />
                        }
                    </div>
                ) ) 
                }
                {console.log( this.props.posts)}

            </div>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        posts: state
    }
}


//export default AllPost;

export default connect(mapStateToProps)(AllPost);