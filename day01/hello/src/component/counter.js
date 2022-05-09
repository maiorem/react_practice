import React, { useState } from "react";

//반드시 대문자.. 소문자는 인식을 못함
function Counter(props) {
  //공통변수
  //변수와 변수의 값을 바꿀 수 있는 함수 두개를 짝궁으로 만든다
  //useState를 통해서 변수 초기화
  const [count, setCount] = useState(10);

  //함수의 주소를 저장하는 변수를 만든다
  const increase = () => {
    setCount(count + 1);
  };

  const decrease = () => {
    setCount(count - 1);
  };

  let titleStyle = {
    fontSize: "23px",
    color: "red",
  };
  return (
    <div>
      <h1 style={titleStyle}>This is counter</h1>
      <h1
        style={{ fontSize: "23px", color: "magenta", backgroundColor: "cyan" }}
      >
        This is counter2
      </h1>
      <h1>현재 카운트 : {count}</h1>
      <button type="button" onClick={increase}>
        증가
      </button>
      <button type="button" onClick={decrease}>
        감소
      </button>
    </div>
  );
}

export default Counter;
