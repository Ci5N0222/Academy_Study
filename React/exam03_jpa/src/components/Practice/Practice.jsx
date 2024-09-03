import {useEffect, useState} from "react";
import axios from "axios";

export const Practice = () => {
  const [messages, setMessages] = useState([]);

  const handleGet = () => {
    axios.get(`http://localhost/messages`).then(res => {
      console.log(res);
      setMessages(res.data);
    })
  }

  const [message, setMessage] = useState({writer:"", message: ""});
  const handleData = (e) => {
    const {name, value} = e.target;
    setMessage(prev => ({...prev, [name]: value}));
  }

  const handlePost = () => {
    axios.post(`http://localhost/messages`, message).then(res => {
      console.log(res);
      handleGet();
    })
  }

  const [modifyMessage, setModifyMessage] = useState({seq:"", writer:"", message: ""})

  const handleModifyChange = (e) => {
    const {name , value} = e.target;
    setModifyMessage(prev => ({...prev, [name]: value}));
  }

  const handlePut = () => {
    axios.put(`http://localhost/messages/${modifyMessage.seq}`, modifyMessage).then(res => {
      console.log(res);
      handleGet();
    });
  }

  const handleDelete = (seq) => {
    axios.delete(`http://localhost/messages/${seq}`).then(res => {
      console.log(res);
      // handleGet();
      setMessages(prev => {
        return prev.filter(item => item.seq !== seq);
      })
    });
  }

  useEffect(() => {
    handleGet();
  }, []);
  return (
    <div>
      <input type="text" name="writer" onChange={handleData}/>
      <input type="text" name="message" onChange={handleData}/>
      <button onClick={handlePost}>POST</button>
      <br/>
      <button onClick={handleGet}>GET</button>
      <fieldset>
        <legend>Messages</legend>
        {
          messages.map(item => {
            return (
              <div key={item.seq} style={{border: "1px solid black"}}>
                <p>글번호 : {item.seq}</p>
                <p>작성자 : {item.writer}</p>
                <p>내용 : {item.message}</p>
                <p>작성일 : {item.writeDate}</p>
                <button>수정</button>
                <button onClick={() => handleDelete(item.seq)}>삭제</button>
              </div>
            );
          })
        }
      </fieldset>
      수정 : <input type="text" name="seq" onChange={handleModifyChange}/>
      <input type="text" name="writer" onChange={handleModifyChange}/>
      <input type="text" name="message" onChange={handleModifyChange}/>
      <button onClick={handlePut}>Update</button>
    </div>
  );
}