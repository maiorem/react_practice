import React, {useState} from 'react';

function For2(props) {
    const [fruitList, setFruitList] = useState(["딸기", "배", "사과", "포도", "수박", "망고", "오렌지"])
    const [fruit, setFruit]=useState("");

    const onChange= (e)=>{
        setFruit(e.target.value);
    }

    const goAppend=()=>{
        //push 자바스크립트가 새로 배열을 만들어서 추가시키고 원래거 삭제 시키는 방법 
        //state의 배열의 값을 바꾸면 안된다. 
        setFruitList( fruitList.concat( fruit ));
        setFruit("");
    }

    return (
        <div>
            <h1>과일목록</h1>

            <input type="text" onChange={onChange} value={fruit}/>
            <button type="button" onClick={goAppend}>추가하기</button>

            <hr/>
            <table>
            {
                fruitList.map ( (item, index)=>{
                       return (
                           <tr key={index}>
                               <td>{index}</td><td>{item}</td>
                          </tr>
                       ) 
                })
            } 
            </table>
        </div>
    );
}

export default For2