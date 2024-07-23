
import './App.css';
import { useEffect, useState } from'react';
import axios from 'axios';
import { Modal } from './components/Modal/Modal';


// 서버와 클라이언트는 데이터만 주고 받는다.
// 오로지 비동기 통신으로만 구성된다.
// CRUD
// C : Post
// R : Get
// U : Put
// D : Delete 방식


function App() {
  const resetObj = {id:0, title:'', singer:''};
  const [ modal, setModal ] = useState("detail");
  const [ music, setMusic ] = useState(resetObj);
  const [ musics, setMusics ] = useState([]);
  const [ modData, setModData ] = useState(resetObj);
  const [ detailData, setDetailData ] = useState(resetObj);

  const handleAddChange = (e) => {
    const {name, value} = e.target;
    setMusic(prev => ({ ...prev, [name]:value }));
  }

  const handleModChange = (e) => {
      const { name, value } = e.target;
      setModData(prev => ({ ...prev, [name]: value }));
  }
  
  /* Insert */
  const handleAdd = async() => {
    const res = await axios.post("http://192.168.1.7/music", music);
    if(res.status === 200) {
      await handleGetList();
      setMusic(resetObj);
      alert("입력됨!!");
    } else {
      alert("실패함 .. 다시 해주셈");
    }
  }
  
  /* List */
  const handleGetList = async() => {
    const res = await axios.get("http://192.168.1.7/music");
    setMusics(res.data);
  }
  
  /* Detail */
  const handleDetail = async(id) => {
    const res = await axios.get(`http://192.168.1.7/music/${id}`);
    setDetailData(res.data);
    openModal();
  }

  /* Update */
  const handleUpdate = async() => {
    const res = await axios.put("http://192.168.1.7/music", modData);
    if(res.status === 200) {
      await handleDetail(modData.id);
      await handleGetList();
      setModal("detail");
      setModData(resetObj);
      alert("수정됨!!");
    } else {
      alert("실패함... 다시 해주셈");
    }
  }

  /* Delete */
  const handleDelete = async(id) => {
    if(window.confirm("ㄹㅇ 삭제함?")){
      const res = await axios.delete(`http://192.168.1.7/music/${id}`);
      if(res.status === 200) {
        await handleGetList();
        alert("삭제 완료");
      }
    } else {
      alert("ㅇㅋ 안함");
    }
  }

  const handleSearch = async(e) => {
    const res = await axios.get(`http://192.168.1.7/music`, {
      params: {
        title: e.target.value
      }
    });
    setMusics(res.data);
  }

  useEffect(() => {
    handleGetList();
  }, []);

  const [ isModalOpen, setIsModalOpen ] = useState(false);
  const openModal = () => setIsModalOpen(true);
  const closeModal = () => {
    setIsModalOpen(false);
    setModal("detail");
  }

  return (
    <div className="container">
      <div className='form'>
        <div className='col'>
          [ Music Insert ] 
          <div>
            <input type="text" placeholder='Title' name="title" value={ music.title} onChange={handleAddChange}></input>
            <input type="text" placeholder='Singer' name="singer" value={ music.singer} onChange={handleAddChange}></input>
            <button onClick={handleAdd}> Add! </button>
          </div>
        </div>
      </div>
        
        <hr /><hr />
        <div className="list">
          [ Music List ] <br /><br />
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Singer</th>
                <th>[Delete]</th>
              </tr>
            </thead>
            <tbody>
              {
                musics.map((item, i) => {
                  return (
                    <tr key={ i }>
                        <td>{ item.id }</td>
                        <td><button onClick={()=>{ handleDetail(item.id) }}>{ item.title }</button></td>
                        <td>{ item.singer }</td>
                        <td><button onClick={ () => { handleDelete(item.id) } }>X</button></td>
                    </tr>
                  );
                })
              }
            </tbody>
          </table>
        </div>
        <br />
        <hr /><hr />
        
        <div className='search'>
          [ Music Search ] <br /><br />
          <input type="text" placeholder='Title' name="title" onChange={ handleSearch } />
        </div>
        
        {
          modal === "detail" &&
          <Modal isOpen={ isModalOpen } onClose={ closeModal }>
            <div className=''>
              [ Music Detail ]
              {/* 내용 작성 */}
              <p>Title : { detailData.title }</p>
              <p>Singer : { detailData.singer }</p>
              <button onClick={ () => { 
                setModal("update");
                setModData(detailData);
                }}> 수정하기 </button>
              <button onClick={ () => { closeModal() }}>취소</button>
            </div>
          </Modal>
        }
        {
          modal === "update" &&
          <Modal isOpen={ isModalOpen } onClose={ closeModal }>
            <div className=''>
              [ Music Update ]
              {/* 내용 작성 */}
              <input type="hidden" name="id" value={ modData.id } />
              <p>Title : <input type="text" name="title" onChange={ handleModChange } value={ modData.title } /></p>
              <p>Singer : <input type="text" name="singer" onChange={ handleModChange } value={ modData.singer } /></p>
              <button onClick={ handleUpdate }>완료</button>
              <button onClick={ ()=>{ setModal("detail"); } }>취소</button>
            </div>
          </Modal>
        }
        

    </div>
  );
}

export default App;
