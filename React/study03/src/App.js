import React, { useState } from 'react';


const App = () => {
  const [data, setData] = useState([
    {seq: 1, writer: 'Tom', message: "Hello React"},
    {seq: 2, writer: 'Sara', message: "React State Practice"},
    {seq: 3, writer: 'Jack', message: "Object Array"},
  ]);


  const [ dataArr, setDataArr ] = useState({});

  const handlerSeq = (e) => {
    setDataArr((prev) => {
      return {...prev, seq:e.target.value};
    });
  }

  const handlerWriter = (e) => {
    setDataArr((prev) => {
      return {...prev, writer:e.target.value};
    });
  }

  const handlerMessage = (e) => {
    setDataArr((prev) => {
      return {...prev, message:e.target.value};
    });
  }

  const handlerSave = () => {
    setData((prev) => {
      return [...prev, dataArr]
    });
    setDataArr({seq:"", writer: "", message: ""});
  }

  return(
    <div className='container'>
      <table className='messages'>
        <tr>
          <th>글번호</th>
          <th>작성자</th>
          <th>메세지</th>
        </tr>
        {
          data.map( ({seq, writer, message}, i) => {
            return (
              <tr key={ i }>
                <td>{ seq }</td>
                <td>{ writer }</td>
                <td>{ message }</td>
              </tr>
            );
          })
        }
        <tr>
          <td colSpan={ 3 }>
            <input type="text" onChange={ handlerSeq } value={ dataArr.seq } laceholder='글 번호'/>
            <input type="text" onChange={ handlerWriter } value={ dataArr.writer } placeholder='작성자' />
            <input type="text" onChange={ handlerMessage } value={ dataArr.message } placeholder='글 내용' />
            <br />
            <button onClick={ handlerSave }>추가</button>
          </td>
        </tr>
      </table>
    </div>
  );
}

export default App;
