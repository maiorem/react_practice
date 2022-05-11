import { Outlet, Link } from "react-router-dom";

//anchor : 화면에 리프레쉬됨. 그래서 가급적 사용하지 말고 Link 태그를 사용할 것
//Link 태그의 to가 href에 대응된다. router로 선언된 것만 가능.
function Layout() {
  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
        </ul>
      </nav>
      <hr />
      <Outlet /> {/*메뉴를 선택하면 이 위치에 컴포넌트가 바뀐다. */}
    </div>
  );
}

export default Layout;
