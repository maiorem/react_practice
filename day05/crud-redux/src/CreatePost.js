import { connect } from 'react-redux';
import { createPost } from './action/data';
import PostForm from './PostForm';

const mapDispatchToProps = dispatch => {
  return {
    onAddPost: post => {
      dispatch(createPost(post));
    }
  };
};

export default connect(
  null,
  mapDispatchToProps
)(PostForm);