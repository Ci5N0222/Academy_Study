import logo from './logo.svg';
import './App.css';
import { Content } from './components/Content/Content';
import { Main } from './components/Main/Main';
import { BrowserRouter as Router, Routes, Route, useNavigate, Link}  from 'react-router-dom';


function App() {
  return (
    <Router>
      <AppContent />
    </Router>
  );
}

const AppContent = () => {

  const navi = useNavigate();

  return (
    <div className="container">
        <div className="header">
          Header!
        </div>
        <div className="body">
          <div className="sidemenu">
            <div className='logo'>
              <Link to="/" ><img src={ logo } alt="" /></Link>
            </div>
            <div className='menu' onClick={ () => navi("member") } >회원 관리</div>
            <div className="menu" onClick={ () => navi("board") } >게시물 관리</div>
            <div className="menu" onClick={ () => navi("banner") } >광고 관리</div>
          </div>
          <div className="content">
          <Routes>
              <Route path='/' element={ <Main content={ "내용1" } /> } />
              <Route path='/member/*' element={ <Content content={ "내용2" } /> } />
              <Route path='/board/*' element={ <Content content={ "내용3" } /> } />
              <Route path='/banner/*' element={ <Content content={ "내용4" } /> } />
          </Routes> 
        </div>  
      </div>
  </div>
  );
}

export default App;
