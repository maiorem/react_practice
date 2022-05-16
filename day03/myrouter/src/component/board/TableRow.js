import React, { Component } from 'react';
import { Link, useNavigate  } from "react-router-dom";
import Axios from 'axios';

function TableRow(props){
  let history = useNavigate ();

  const refreshPage=()=>{ 
    window.location.reload(); 
  }

  const deleteItem = (e)=>{
      if(window.confirm("삭제하시겠습니까?"))
      {
        Axios.get('http://127.0.0.1:9090/board/delete/'+props.obj.id)
            .then(
              ()=>{
                console.log('Deleted');
                //history('/board');--안먹음
				refreshPage();
              }
            ).catch(err => console.log(err));
        
        console.log("delete");  
      }
  }
  
    return (
        <tr>
          <td>
            {props.totalCnt-props.obj.rnum+1}
          </td>
          <td>
            {props.obj.reply}{props.obj.title}
          </td>
          <td>
            {props.obj.writer}
          </td>
          <td>
          <Link to={"/board/view/"+props.obj.id} className="btn btn-primary">Edit</Link>
          </td>
          <td >
            <button  onClick={deleteItem} className="btn btn-danger">Delete</button>
          </td>
        </tr>
    );
  }
  

export default TableRow;