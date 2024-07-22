
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

  const [music, setMusic] = useState(resetObj);
  const [ musics, setMusics ] = useState([]);
  const [ modData, setModData ] = useState(resetObj);
  const [ detailData, setDetailData ] = useState(resetObj);

  const handleAddChange = (e) => {
    const {name, value} = e.target;
    setMusic(prev => ({...prev, [name]:value}));
  }

  const handleModChange = (e) => {
      const { name, value } = e.target;
      setModData(prev => ({ ...prev, [name]: value }));
  }

  const handleAdd = async () => {
    await axios.post("http://192.168.1.7/music", music);
    setMusic(resetObj);
    await handleGetList();
  }

  const handleGetList = async() => {
    const res = await axios.get("http://192.168.1.7/music/list");
    setMusics(res.data);
  }

  const handleDetail = async(id) => {
    const res = await axios.get(`http://192.168.1.7/music/detail?id=${id}`);
    setDetailData(res.data);
    openModal();
  }

  const handleDelete = async (id) => {
    await axios.delete(`http://192.168.1.7/music/delete?id=${id}`);
    await handleGetList();
  }
  
  const handleUpdate = async() => {
    await axios.put("http://192.168.1.7/music/update", modData);
    await handleGetList();
  }

  useEffect(() => {
    handleGetList();
  }, []);

  const [ isModalOpen, setIsModalOpen ] = useState(false);
  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  return (
    <div className="container">
      <div className='form'>
        <div className='col'>
          [목록 추가 ] <br /><br />
          <input type="text" placeholder='Title' name="title" value={ music.title} onChange={handleAddChange}></input><br></br>
          <input type="text" placeholder='Singer' name="singer" value={ music.singer} onChange={handleAddChange}></input><br></br>
          <button onClick={handleAdd}> Add New </button>
        </div>
        <div className='col'>
          [목록 수정 ] <br /><br />
          <input type="text" placeholder='ID' name="id" value={ modData.id || ''} onChange={handleModChange}></input><br></br>
          <input type="text" placeholder='Title' name="title" value={ modData.title} onChange={handleModChange}></input><br></br>
          <input type="text" placeholder='Singer' name="singer" value={ modData.singer} onChange={handleModChange}></input><br></br>
          <button onClick={handleUpdate}> Modify </button>
        </div>
      </div>
        
        <hr /><hr />
        <Modal isOpen={ isModalOpen } onClose={ closeModal } data={ detailData }>
          <button onClick={ closeModal }>Close</button>
        </Modal>
        <div className="list">
          [ Music 목록 ] <br /><br />
          <table style={{ border: "1px solid black" }}>
            <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Singer</th>
                <th>[X]</th>
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
    </div>
  );
}

export default App;
