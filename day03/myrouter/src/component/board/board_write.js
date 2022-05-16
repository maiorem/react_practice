import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Axios from "axios";

function BoardWrite() {
  let history = useNavigate();

  const [inputs, setInputs] = useState({
    title: "",
    writer: "",
    contents: "",
    filename: "",
  });

  const { title, writer, contents, filename } = inputs;

  const onChange = (e) => {
    const { value, name } = e.target; // 우선 e.target 에서 name 과 value 를 추출
    console.log(value, name);
    setInputs({
      ...inputs, // 기존의 input 객체를 복사한 뒤
      [name]: value, // name 키를 가진 값을 value 로 설정
    });
  };

  const onReset = () => {
    setInputs({
      title: "",
      writer: "",
      contents: "",
      filename: "",
    });
  };

  const onSubmit = (e) => {
    e.preventDefault();

    // Axios.post('http://localhost:9090/mongo/update/', obj)
    //      .then(res => console.log(res.data));
    var frmData = new FormData();
    frmData.append("title", inputs.title);
    frmData.append("writer", inputs.writer);
    frmData.append("contents", inputs.contents);

    frmData.append("file", document.myform.filename.files[0]);
    Axios.post("http://localhost:9090/board/insert/", frmData).then((res) => {
      console.log(res.data);
      alert("등록되었습니다.");
      history("/board");
    });
  };

  return (
    <div>
      <form name="myform" onSubmit={onSubmit} encType="multipart/form-data">
        <div className="form-group">
          <label>제목: </label>
          <input
            type="text"
            className="form-control"
            name="title"
            value={title}
            onChange={onChange}
          />
        </div>
        <div className="form-group">
          <label>이름: </label>
          <input
            type="text"
            className="form-control"
            name="writer"
            value={writer}
            onChange={onChange}
          />
        </div>
        <div className="form-group">
          <label>내용: </label>
          <input
            type="text"
            name="contents"
            className="form-control"
            value={contents}
            onChange={onChange}
          />
        </div>
        <div className="form-group">
          <label>파일: </label>
          <input
            type="file"
            name="filename"
            className="form-control"
            value={filename}
            onChange={onChange}
          />
        </div>
        <div className="form-group">
          <input type="submit" value="등록 " className="btn btn-primary" />
        </div>
      </form>

      <div style={{ marginTop: 20 }}>
        <b>값: </b>
        {title} <br />
        {writer} <br />
        {contents} <br />
      </div>
    </div>
  );
}

export default BoardWrite;
