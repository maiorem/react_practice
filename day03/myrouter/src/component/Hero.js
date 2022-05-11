import React ,{useState, useEffect} from 'react';
 
function Hero(props) {
    //json배열로 데이터 저장하기 
    const[heroState, setHeroState] = useState([
        {"id":"1", "name":"홍길동", "description":"율도국 세움"},
        {"id":"2", "name":"이순신", "description":"임지왜란으로부터 나라를 구함"},
        {"id":"3", "name":"감감찬", "description":"귀주대첩"},
        {"id":"4", "name":"을지문덕", "description":"살수대첩"},
        {"id":"5", "name":"세종대왕", "description":"한글창제"},
    ]);

    useEffect( ()=>{
        setHeroState( 
            heroState.concat(
                {"id":"6", "name":"김종서", "description":"사군육진"}, 
                {"id":"7", "name":"태종", "description":"사병혁파"}, 
                {"id":"8", "name":"광종", "description":"조세정리"}
            ));
    }, []);

    //백앤드 서버로부터(Restful API서버를 만들어서 )
    //fetch(리액트전ㅇ용) Axios(리액트만 사용하는게 아니라 다른 Vue 라이브러리에서도 같이 
    //사용한다.  Axios - Ajax통신을 담당한다 
    //비동기 모드, 별도의 라이브러리를 반드시 설치하고 사용법 따로 배워야 한다 
    //절대로 react나 vue, angular나 polymer... 프론트앤드라이브러리에서 디비와 
    //직접 연결하지 않는다. 
    //백앤드 서버, nodejs  프론트앤드(react, vue), 백앤드(express)
    //            jsp(spring boot), asp, php 
    //단 데이터를 json으로 주고 받아야 한다 
    //서로간에 백앤드와 프론트앤드간에 정보를 주고받을때 CORS정책 문제 발생
    //자바스크립트가 남의 아이피나 도메인 포트번호가 다를때 다른사이트로 인식되어서
    //서로 정보를 주고 받을 수 없다. 
    //1.클라이언트 쪽에 proxy를 만들어서 우회했었는데 보안상 못씀 
    //  proxy가 react script 5.0 이상부터 작동 안된다.
    
    /*
       3000    cors정책오류               4000
       react  ------------------->       express(데이터베이스는 express를 통해서민 ) 
       nodejs                            nodejs 
                                         spring tomcat 으로 해도 포트번호가 달라서 
                                         오류발생 
    
        1. 클라이언트쪽에서 proxy 라는 만들어서 서버로 접근( react-script 5.0부터 에러 X)
           ***** 못쓴다 

        2. 서버쪽에서 cors를 무력화시키는 라이브러리르 설치한다. 
          스프링의 경우는 어노테이션을 사용한다. 
          img 태그는 속성에 cors 무력화 속성을 안넣어주면 에러발생 
          서버에 있는 이미지가 안보이는 상태 오류가 발생함(브라우저 버전따라다르다) 

        img 태그나 video 태그에 
          crossorigin	anonymous
                        use-credentials

        <img crossorigin="anonymous" 
        src="/img/html/vangogh.jpg" alt="Van Gogh, self-portrait">

        https://www.dofactory.com/html/img/crossorigin

        

    */





    return (
        <div>
             <table>
                 {
                    heroState.map( (item, index)=>{
                        //item 은 json형태로 전달되낟. 
                        return (
                            <tr>
                                <td>{item.id}</td>
                                <td>{item["name"]}</td>
                                <td>{item.description}</td>
                            </tr>
                        )
                    })
                }
            </table>       
        </div>
    );
}

export default Hero;