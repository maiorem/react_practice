import React, {useState} from 'react';

function Calculator(props) {
    const [xvalue, setXvalue]=useState(0);
    const [yvalue, setYvalue]=useState(0);
    const [result, setResult]=useState(0);
    
    const onChangeXValue=(e)=>{
        setXvalue(e.target.value);
    }

    const onChangeYValue=(e)=>{
        setYvalue(e.target.value);
    }

    const add = ()=>{
       console.log( parseInt(xvalue) + parseInt(yvalue));
       setResult(parseInt(xvalue) + parseInt(yvalue) );
    }

    const sub = ()=>{
        console.log( parseInt(xvalue) - parseInt(yvalue));
        setResult(parseInt(xvalue)- parseInt(yvalue) );
     }

     const mul = ()=>{
        console.log( parseInt(xvalue) * parseInt(yvalue));
        setResult(parseInt(xvalue) * parseInt(yvalue) );
     }

     const div = ()=>{
        console.log( parseInt(xvalue) / parseInt(yvalue));
        setResult(parseInt(xvalue) / parseInt(yvalue) );
     }
    return (
        <div>
            x : <input type="text" name={xvalue} value={xvalue} onChange={onChangeXValue}/><br/>
            y : <input type="text" name={yvalue}  value={yvalue} onChange={onChangeYValue}/><br/>
            result : <span id="result">{result}</span> 
            <br/>
            <button type="button" onClick={add}>더하기</button>
            <button type="button" onClick={sub}>빼기</button>
            <button type="button" onClick={mul}>곱하기</button>
            <button type="button" onClick={div}>나누기</button>
            

        </div>
    );
}

export default Calculator;