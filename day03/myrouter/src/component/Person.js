import axios from 'axios';
import React, {useState, useEffect} from 'react'; 

function Person(props) {
    const [personList, setPersonList]=useState([]);
    const [loading, setLoading] =useState(false); //boolean 

    //백앤드 서버로부터 데이터를 읽어와야한다. 서버로부터 데이터를 읽어온 후 
    //화면에 있는 html 요소들과 연동작업을 시켜야하는데 이걸 마운트라고 한다 
    //react애서는 클래스콤퍼넌트기반일 경우 mount와 unmount 함수를 사용했는데 함수에서는 
    //useEffect라는 훅을 사용한다. useEffect는 마운트 언마운트 업데이트시 호출된다.
    //간단하게는 window.onload이벤트 발생처럼 생각하면된다. (내부적으로는 다르다)
    //맨처음에 콤포넌트가 메모리에 로딩될때 호출된다고 생각하면 된다. 
    useEffect(()=>{
        //여기서 서버의 데이터를 불러온다. 
        //axios는 Ajax전용 라이브러리이고 비동기 통신을 지원한다 
        axios.get("http://127.0.0.1:9999/list") //get함수는 비동기라 바로 리턴한다 
                                                //결과가 다 올때까지 기다리지 않는다 
            .then( (result)=>{
                //console.log(result);
                setPersonList(result.data);
                setLoading(true); //데이터 모두 수신되었다
            } )
            .catch((error)=>{
                 console.log(error);   
             } )
            
        //get이 비동기이므로  personList = axios.get(~~ 이런식으로 작성은 불가능하다) 
        //데이터 수신에 성공하면 then 구문을 호출하고 매개변수가 서버로 부터 받아온 데이터이다
        //catch는 서버로부터 데이터 수신 실패시 호출된다. 
        //자바스크립트 == 자동형전환  0 == false 다른언어에서는 false가 나오는데
        //자바스크립는 무시적형전환 그래서 true라는 결과가 나온다. 
        //모던스크립트에스 === 자동형전환 안된다.    
    }, []);  


    return (
        <div>
            <table>
                {
                    loading===true?(
                    personList.map( (person, i)=>{
                        return(
                            <tr>
                                <td>{person.name}</td>
                                <td>{person.phone}</td>
                            </tr>    
                        )
                    })
                    ):""
                }
            </table>
        </div>
    );
}

export default Person;