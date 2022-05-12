import logo from './logo.svg';
import './App.css';
//스프링의 RequestMapping(value="/list")=>호출될 함수 결정 
//node쪽에서는 라우터라고 한다 
import {Routes, Route} from 'react-router-dom';
import Home from './component/Home';
import Layout from './component/Layout';

import About from './component/About';
import Counter from './component/counter';
import Calculator from './component/Calculator';
import Hero from './component/Hero';
import Person from './component/Person';

// add?x=5&y=7  add/5/7 
function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Layout/>} >  
          <Route index element={<Home/>} />
          <Route path="about" element={<About/>} />
          <Route path="counter" element={<Counter/>} />
          <Route path="person" element={<Person/>} />
          <Route path="calculator/:x/:y" element={<Calculator/>} />
          <Route path="my/hero/list" element={<Hero/>} />
        </Route>
\
      </Routes>


    </div>
  );
}






export default App;










