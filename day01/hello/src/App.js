import logo from './logo.svg';
import './App.css';
import Counter from './component/counter';
import Calculator from './component/Calculator';
import For1 from './component/For1';
import For2 from './component/For2';
import Hero from './component/Hero';
import Person from './component/Person';
import PersonWrite from './component/PersonWrite';
/*
class App extends React.Component{

}  2020년부터 함수 콤퍼넌트로 전화된다. 
   클래스안에 변수와 함수 템플릿(태그)을 하나로 두고 이걸 묶어서 
   컴포넌트 기반으로 템플릿기반의 컴포넌트 함수콤포넌트를 만들었는데 
   클래스 컴포넌트를 대체할만큼의 능력이 안돼서 
   react tutorial 사이트뿐만 아니라 교제도 나온지 된것들은 
   클래스 컴포넌트 기반으로 되어 있다. 
   클래스컴포넌트 기능 => 훅이라고 하는 기능으로 옮겨가면서 
   함수기반 콤퍼넌트 + 훅 => 클래스 컴포넌트를 대체한다.
   react-컴포넌트 만들때 rsf를 하면 함수기반 컴포넌트를 만들어준다 
*/
function App() {

  //tamplate - 디자인파트가 return 구문에 
  return (
    <div className="App">
      { /*<Counter/>*/}
      {/*<Calculator/>*/}
      {/*<For2/>*/}
      {/*<Hero/>*/}
      <Person/>
      <PersonWrite/>
    </div>
  );
}

export default App;
