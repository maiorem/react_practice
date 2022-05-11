import React, { useState } from 'react';

//props : 함수를 호출하는 쪽에서 매개변수를 주면 매개변수를 받아오는 객체이다. 
//약속이다. 
//useState: state훅 
//props : 부모로부터 자식컴포넌트한테 값을 부여하고자할때 props객체를 사용한다 
//state : 자신의 상태값을 저장하고 있다. 변수들
//      : 클래스기반 컴포넌트 클래스내부에 공통변수를 만들 수 있다. 

function Counter(props) {
    //공통변수 
    //변수와 변수의 값을 바꿀 수 있는 함수 두개를 짝궁으로 
    //useState 를 통해서 변수초기화 state객체에 값을 저장할 수 있게 지원한다 
    const [count, setCount] = useState(10);
    //count : 변수 - 값을 저장한다 
    //setCount : count  변수값을 전환할 수 있는 함수이다.
    //함수는 중간에 가로채서 interrupt 어떤 상황이 발생했는지 확인가능
    //그래서 변수값을 어떤경우에도 직접 바꾸지 않고 set이라는 이름지어진 함수를 통해서 
    //바꿔야 한다  
    //count = count + 1 

    //함수의 주소를 저장하는 변수를 만든다. 
    //내부에서 사용될 이벤트 함수는 무조건 화살표 함수로 만들자 
    // function increase(){} 
    // increase=function(){}
    // increase = ()=>{} :화살표함수, 람다중에 
      
    const increase = ()=>{
        setCount( count+1 );
    }

    const decrease = ()=>{
        setCount( count-1 );
    }


    let titleSTyle={
        fontSize:"23pt",
        color:"red"
    }

    //템플릿 - 디자인부분 태그들과 
    //트리구조 - root 태그가 존재하고 그 안에 태그가 존재해야 한다 
    return (
        <div>
            <h1 style={titleSTyle}>This is counter</h1>
            <h1 style={{color:"magenta", backgroundColor:"cyan"}}>This is counter2</h1>
            <h1>현재 카운트 : {count}</h1>
            <button type="button" onClick={increase}>증가</button>
            <button type="button" onClick={decrease}>감소</button>
        </div>
    );
}

export default Counter; //반드시 내보내야 한다