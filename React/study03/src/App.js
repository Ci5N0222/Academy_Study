import React, { useState } from 'react';

function App() {

  const [ movies, setMovies ] = useState([
    { id: 1, title: "Inception", genre: "Science Fiction", publish: "2010-07-16" },
    { id: 2, title: "The Dark Knight", genre: "Action", publish: "2008-07-18" },
    { id: 3, title: "Parasite", genre: "Thriller", publish: "2019-05-30" },
    { id: 4, title: "La La Land", genre: "Musical", publish: "2016-12-09" },
    { id: 5, title: "Avatar", genre: "Science Fiction", publish: "2009-12-18" }
  ]);


  /* Insert */
  const [ movie, setMovie ] = useState({ id: movies[movies.length-1].id + 1, title: "", genre: "", publish: "" });
  const handleInputData = (e) => {
    const { name, value } = e.target;
    setMovie( prev => ({...prev, [ name ]: value}));
  }

  const handleAddMovie = () => {
    setMovies( prev => {
      const updated = [...prev, movie];
      setSearch(updated);
      return updated;
    });

    setMovie({ id: movie.id +1, title: "", genre: "", publish: "" });
  }


  /* Delete */
  const handleDeleteMovie = (seq) => {
    if(window.confirm("삭제할거임?")){
      setMovies( prev => {
        const updated = prev.filter( item => item.id !== seq);
        setSearch(updated);
        return updated;
      });
    }
  }


  /* Update */
  const [ update, setUpdate ] = useState({ id: 0, title: "", genre: "", publish: "" });
  const handleUpdateData = (e) => {
    let { name, value } = e.target;
    if(name === "id") value = parseInt(value);
    setUpdate ( prev => ({ ...prev, [ name ]: value}) );
  }

  const handleUpdateMovie = () => {
    let exists = false;
    for(let movie of movies){
      if(movie.id === update.id) {
        exists = true;
        break;
      }
    }

    if(exists){
      setMovies( prev => {
        const updated = prev.map( item => item.id === update.id ? update : item )
        setSearch(updated);
        return updated;
      });
      setUpdate({ id: 0, title: "", genre: "", publish: "" });
    } else {
      alert("없는 글번호");
    }
  }


  /* Search */
  const [ search, setSearch ] = useState(movies);
  const handleSearch = (e) => { 
    setSearch( movies.filter( ({ title }) => title.includes(e.target.value)));
  }


  return (
    <div className="App">
      <table>
        <tr>
          <th>ID</th>
          <th>Title</th>
          <th>Genre</th>
          <th>Publish</th>
          <th>Del</th>
        </tr>
        {
          search.map( (item, i) => {
            return (
              <tr key={ i }>
                <td>{ item.id }</td>
                <td>{ item.title }</td>
                <td>{ item.genre }</td>
                <td>{ item.publish }</td>
                <td><button onClick={ () => handleDeleteMovie(item.id) } >삭제</button></td>
              </tr>
            );
          })
        } 
        <tr>
          <td colSpan={ 4 }>
            영화 추가　:　
            <input type="text" onChange={ handleInputData } name="id" value={ movie.id } readOnly/>
            <input type="text" onChange={ handleInputData } name="title" value={ movie.title } placeholder="Input Title"/>
            <input type="text" onChange={ handleInputData } name="genre" value={ movie.genre } placeholder="Input Genre"/>
            <input type="date" onChange={ handleInputData } name="publish" value={ movie.publish } placeholder="Input Publish"/>
          </td>
          <td>
            <button onClick={ handleAddMovie }>추가</button>
          </td>
        </tr>
        <tr>
          <td colSpan={ 4 }>
            영화 수정　:　
            <input type="text" onChange={ handleUpdateData } name="id" value={ update.id || '' } placeholder="Update ID"/>
            <input type="text" onChange={ handleUpdateData } name="title" value={ update.title } placeholder="Update Title"/>
            <input type="text" onChange={ handleUpdateData } name="genre" value={ update.genre } placeholder="Update Genre"/>
            <input type="date" onChange={ handleUpdateData } name="publish" value={ update.publish } placeholder="Update Publish"/>
          </td>
          <td>
            <button onClick={ handleUpdateMovie } >수정</button>
          </td>
        </tr>
        <tr>
          <td colSpan={ 5 }> 검색어 입력　:　<input type="text" onChange={ handleSearch }/></td>
        </tr>
      </table>
    </div>
  );
}

export default App;
