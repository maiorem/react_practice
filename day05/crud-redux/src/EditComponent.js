import React, { Component } from 'react';
import { connect } from 'react-redux';


class EditComponent extends Component {
    handleEdit = (e) => {
      e.preventDefault();
      const newName = this.getName.value;
      const newDescription = this.getDescription.value;
      const data = {
        newName,
        newDescription
      }
      this.props.dispatch({ type: 'UPDATE', id: this.props.post.id, data: data })
    }
    render() {
      return (
        <div className="post">
          <form className="form" onSubmit={this.handleEdit}>
            <input required type="text" ref={(input) => this.getName = input}
            defaultValue={this.props.post.name} placeholder="Enter Post Title" /><br /><br />
            <textarea required rows="5" 
              ref={(input) => this.getDescription = input}
            defaultValue={this.props.post.description} cols="28" placeholder="Enter Post" /><br /><br />
            <button>Update</button>
          </form>
        </div>
      );
  }
}
export default connect()(EditComponent);