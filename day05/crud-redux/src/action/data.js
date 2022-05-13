import { ADD_POST, DELETE_POST, FETCH_POST } from './types';
import axios from 'axios';

const apiUrl = 'http://localhost:9000/mongo';

/*
export const createPost = ( data) => {

     return (dispatch) => {
    return axios.post(apiUrl+'/save', data)
      .then(response => {
        //console.log("Eeee", response.data);
        dispatch(createPostSuccess(response.data))
      })
      .catch(error => {
        throw(error);
      });
  };
};
*/
export const createPost = ({ name, description }) => {
  return (dispatch) => {
    return axios.post(`${apiUrl}/save`, {name, description})
      .then(response => {
        dispatch(createPostSuccess(response.data))
      })
      .catch(error => {
        throw(error);
      });
  };
};


//성공후 보낼 액션
export const createPostSuccess =  (data) => {
  return {
    type: ADD_POST,
    data: {
      id: data.id,
      name: data.name,
      description: data.description
    }
  }
};

export const deletePostSuccess = id => {
  return {
    type: DELETE_POST,
    data: {
      id
    }
  }
}

export const deletePost = id => {
  return (dispatch) => {
    return axios.get(`${apiUrl}/delete/${id}`)
      .then(response => {
        dispatch(deletePostSuccess(response.data))
      })
      .catch(error => {
        throw(error);
      });
  };
};

//데이터 목록 가져오기 
export const fetchPosts = (posts) => {
  return {
    type: FETCH_POST,
    posts
  }
};

export const fetchAllPosts = () => {
  return (dispatch) => {
    return axios.get(apiUrl+"/list")
      .then(response => {
        dispatch(fetchPosts(response.data))
      })
      .catch(error => {
        throw(error);
      });
  };
};