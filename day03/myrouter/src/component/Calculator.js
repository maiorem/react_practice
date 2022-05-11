
import React, {useState} from 'react';
import {useParams, Link} from 'react-router-dom'; //useParams가 react-router-dom이다. 
function Calculator(props) {

    let {x,y}=useParams(); //현재 최신버전  match  이거 안먹음 
   
    const [xvalue, setXvalue] = useState(x);
    const [yvalue, setYvalue] = useState(y);
    const [result, setResult] = useState(0);
    
    const add=()=>{
        console.log( xvalue ); 
        console.log( yvalue ); 
        
        setResult( parseInt(xvalue) + parseInt(yvalue));
    }

    const sub=()=>{
        console.log( xvalue ); 
        console.log( yvalue ); 
        
        setResult( parseInt(xvalue) - parseInt(yvalue));
    }

    const mul=()=>{
        console.log( xvalue ); 
        console.log( yvalue ); 
        
        setResult( parseInt(xvalue) * parseInt(yvalue));
    }

    const div=()=>{
        console.log( xvalue ); 
        console.log( yvalue ); 
        
        setResult( parseInt(xvalue) / parseInt(yvalue));
    }

    //onChage이벤트는 이벤트를 발생시킨 객체에 참조를 가지고 온다 
    //input 태그와 state에 저장된 변수를 연동하기 
    const onChangeXvalue=(e)=>{
        console.log( e.target.value);
        setXvalue(e.target.value);
    }

    const onChangeYvalue=(e)=>{
        console.log( e.target.value);
        setYvalue(e.target.value);
    }

    return (
        <div>
            <h1>사칙연산지</h1> 
            x : <input type="text" name="xvalue" value={xvalue} 
              onChange={onChangeXvalue} /><br/>
            y : <input type="text" name="yvalue" value={yvalue}
            onChange={onChangeYvalue} /><br/>
            <br/>
            result : <span id="result">{result}</span><br/><br/>

            <button type="button" onClick={add}>더히기</button>
            <button type="button" onClick={sub}>빼기</button>
            <button type="button" onClick={mul}>곱하기</button>
            <button type="button" onClick={div}>나누기</button>

            <br/><br/>

            <Link to="/counter">카운터</Link>
            <br/>
        </div>
    );
}

export default Calculator;