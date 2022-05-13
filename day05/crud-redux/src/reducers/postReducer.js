//postReducer.js
/*const postReducer = (state = [], action) => {

}
export default postReducer;
*/

const postReducer = (state = [], action) => {
    switch(action.type) {
      
        case 'ADD_POST':
            //return state.concat([action.data]);
            return [...state, action.data];
        case 'DELETE_POST':
            return state.filter((post)=>post.id !== action.id);
        case 'EDIT_POST':
            return state.map((post)=>post.id === action.id ?
             {...post, editing:!post.editing}:post)
        case 'UPDATE':
            return state.map((post)=>{
                if(post.id === action.id) {
                    return {
                        ...post,
                        name:action.data.newName,
                        description:action.data.newDescription,
                        editing: !post.editing
                    }
                } 
                else return post;
            })
        case 'FETCH_POST':
            state = action.posts;
            return state;
        default:
            console.log("###########################3");
            /*state=[
                {id:1, "name":"이순신1", "description":"222222", editing:false},
                {id:2, "name":"이순신2", "description":"222222", editing:false}
            ];*/
            
            return state;
    }
}
export default postReducer;
