
import './App.css';
import { useState } from'react';
import axios from 'axios';


// 서버와 클라이언트는 데이터만 주고 받는다.
// 오로지 비동기 통신으로만 구성된다.
// CRUD
// C : Post
// R : Get
// U : Put
// D : Delete 방식


function App() {

  const [music, setMusic] = useState({id:0, title:'', singer:''});

  const handleAddChange = (e) => {
    const {name, value} = e.target;
    setMusic(prev => ({...prev, [name]:value}));
  }

  const handleAdd = () => {
    axios.post("http://192.168.1.7/music", music);
  }

  return (
    <div className="Container">
        <input type="text" placeholder='ID' name="id" onChange={handleAddChange}></input><br></br>
        <input type="text" placeholder='Title' name="title" onChange={handleAddChange}></input><br></br>
        <input type="text" placeholder='Singer' name="singer" onChange={handleAddChange}></input><br></br>
        <button onClick={handleAdd}> Add New </button>
    </div>
  );
}

export default App;
