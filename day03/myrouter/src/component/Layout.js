import {Link, Outlet} from 'react-router-dom';

//anchor - 화면에 리프레쉬, 그래서 가급적 사용하지 말고 Link태그를 사용해라
//Link 태그의 to가 href에 대응된다. router로 선언된것만 가능하다  

function Layout()
{
  return(
    <div>
      <nav> 
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/about">About</Link></li>
          <li><Link to={"/calculator/4/5"}>계산기</Link></li>
          <li><Link to="/counter">카운터</Link></li>
          <li><Link to="/my/hero/list">영웅목록</Link></li>
        </ul>  
      </nav>
      <hr/>

      <Outlet/> {/*메뉴를 선택하면 이 위치에 컴포넌트가 바뀐다.*/}
    </div>
  )
}

export default Layout;