import styles from './Add.module.css'
import {useNavigate} from "react-router-dom";
import {useState} from "react";

export const Add = ({type}) => {

  const navi = useNavigate();

  const [ save, setSave ] = useState(data);

  const handleData = (e) => {
    let { name, value } = e.target;
  }

  const handleAdd = () => {
    addData()
  }

  return (
    <div className={styles.container}>
        <div className={styles.form}>
          <div>{type} 추가</div>
          {
            keys.map( item => {
              return (
                <input type="text" name={item} onChange={handleData} value={data[item] || ''} placeholder={item}/>
              );
            })
          }
        </div>
      <div className={styles.btn_box}>
        <button onClick={handleAdd}>추가</button>
        <button onClick={() => navi(`/${type}/list`)}>취소</button>
      </div>
    </div>
  );
}