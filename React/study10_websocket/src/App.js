import './App.css';
import {useEffect, useState} from "react";
import {host} from './config/config.js';
import axios from "axios";
function App() {

  const [messages, setMessages] = useState([]);
  const [message, setMessage] = useState('');
  const [socket, setSocket] = useState(null);


  const handleChange = (e) =>{
    setMessage(e.target.value)
  }

  const handleSend = () =>{
    socket.send(message);
    setMessage('')
  }

  const handleLogin = async () =>{
    const res = await axios.post(`http://${host}/socket`, {id:'abc', pw:'abc'});
    console.log(JSON.stringify(res.data));
  }



  useEffect(()=>{
    const ws = new WebSocket(`ws://${host}/chat`);
    ws.onmessage = (e) => {
      //console.log(e); //내가 보낸 메시지를 그대로 확인할 수 있다
      setMessages(prev => [...prev, e.data])
    }
    setSocket(ws);
  },[]);


  return (
    <div className="App">
      <h1>WebSocket 메세지 연습</h1>
      <input type="text" placeholder="Input message" name="message" onChange={handleChange} value={message}/>
      <button onClick={handleSend}>전송</button>
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default App;
