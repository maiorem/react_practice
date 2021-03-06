import logo from './logo.svg';
import './App.css';
import './header.css';

import * as React from "react";
import { Routes, Route, Outlet, Link, NavLink } from "react-router-dom";

import About from './component/about';
import Home from './component/home';
import Dashboard from'./component/dashboard';
import Counter from'./component/counter';

import BoardList from'./component/board/board_list';
import BoardWrite from'./component/board/board_write';
import BoardView from'./component/board/board_view';

import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="container">
       <h1>Basic Example</h1>

        {/* Routes nest inside one another. Nested route paths build upon
              parent route paths, and nested route elements render inside
              parent route elements. See the note about <Outlet> below. */}
      <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />} />
            <Route path="about" element={<About />} />
            <Route path="dashboard" element={<Dashboard />} />
            <Route path="counter" element={<Counter />} />
            <Route path="board" element={<BoardList />} />
            <Route path="board/write" element={<BoardWrite/>}/>
            <Route path="board/view/:id" element={<BoardView/>}/>
            
            {/* Using path="*"" means "match anything", so this route
                  acts like a catch-all for URLs that we don't have explicit
                  routes for. */}
            <Route path="*" element={<NoMatch />} />
        </Route>
      </Routes>
    </div>
  );
}


function Layout() {
    const activeStyle = {
        color: 'green',
        fontSize: '2rem'
    };
  return (
    <div >
      {/* A "layout route" is a good place to put markup you want to
          share across all the pages on your site, like navigation. */}
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <div className="container-fluid">
          <ul className="navbar-nav mr-auto">
           <li className="nav-item">
                <NavLink  activeStyle={activeStyle} className="nav-link" to="/">Home</NavLink></li>
          <li className="nav-item"><NavLink activeStyle={activeStyle} className="nav-link" to="/about">About</NavLink></li>
          <li className="nav-item"><NavLink activeStyle={activeStyle} className="nav-link" to="/counter">Counter</NavLink></li>
          <li className="nav-item"><NavLink activeStyle={activeStyle} className="nav-link" to="/dashboard">Dashboard</NavLink></li>
          <li className="nav-item"><NavLink activeStyle={activeStyle} className="nav-link" to="/board">?????????</NavLink></li>
        </ul>
        </div>
      </nav>

      <hr />

      {/* An <Outlet> renders whatever child route is currently active,
          so you can think about this <Outlet> as a placeholder for
          the child routes we defined above. 
    
          NavLink - ???????????? ????????? ????????? ????????? ????????? ????????????
          <a href> ~</a> ??? ???????????? ?????? ???????????? ????????????????????? ???????????? ?????? 
          Link ??? NavLink??? ????????????
          Link ??????????????? ?????????????????????. ??? ??????????????? ???????????? ???????????? ?????? ??????????????? ??????,
    */}
      <Outlet />
    </div>
  );
}


function NoMatch() {
  return (
    <div>
      <h2>Nothing to see here!</h2>
      <p>
        <Link to="/">Go to the home page</Link>
      </p>
    </div>
  );
}


export default App;


/*
useHistory
useLocation
useRouteMatch
useParams

*/