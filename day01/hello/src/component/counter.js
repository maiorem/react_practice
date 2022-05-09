import React from "react";

//반드시 대문자.. 소문자는 인식을 못함
function Counter(props) {
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
    </div>
  );
}

export default Counter;
