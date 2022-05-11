import React, {useState} from 'react';

function For1(props) {
    const [fruitList] = useState(["딸기", "배", "사과", "포도", "수박", "망고", "오렌지"])
    //모던스트립트가 배열에 forEach, map, reduce 함수를 추가하고 
    //forEach 배열의 요소마다 출력과 관계된 함수를 매개변수로 전달 
    //map 은 매개변수로 콜백함수 - 반환값이 있는 콜백함수 

    /*
    <table>
        <tr>
            <td>딸기</td>
        </tr>
        <tr>
            <td>재</td>
        </tr>
    </table/>
    */
    return (
        <div>
            <h1>과일목록</h1>
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

export default For1