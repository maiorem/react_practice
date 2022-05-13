import React, { Component } from 'react';
//import PostForm from './PostForm';
import AllPost from './AllPost';
import CreatePost from './CreatePost';

class App extends Component {
  render() {
      return (
        <div className="App">
            <div className="navbar">
              <h2 className="center ">Post It</h2>
            </div>
            <CreatePost /> 
            <AllPost />
        </div>
      );
    }
  }
export default App;