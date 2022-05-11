import React, {useState} from 'react';
import axios from 'axios';

function PersonWrite(props) {
    const [name,  setName]=useState("");
    const [phone, setPhone]=useState("");

    const onChangeName=(e)=>{
        setName( e.target.value );
    }

    const onChangePhone=(e)=>{
        setPhone( e.target.value );
    }

    const onSubmit=(e)=>{
        e.preventDefault(); //기본 서브밋을 막아서 서버로 가는걸 차단. axios를 통해서만
        //jquery ajax는 특별히 말 안하면 데이터를 String으로 전환시켜 보낸다 
        //axios는 그냥 json으로 보내기 때문에 벡엔드 처리방식이 다르다  
        console.log("submit")
        axios.post("http://127.0.0.1:9999/write", {"name":name, "phone":phone})
        .then( (result)=>{
            alert("등록되었습니다");
        })
        .catch((error)=>{
            console.log(error);
        })
    }


    return (
        <div>
            <form name="myform" onSubmit={onSubmit} >
                이름 : <input type="text" name='name' value={name}
                           onChange={onChangeName}/><br/>

                전화번호 : <input type="text" name='phone' value={phone}
                           onChange={onChangePhone}/><br/>
           
                <button>등록</button> 
            </form>
        </div>
    );
}

export default PersonWrite;