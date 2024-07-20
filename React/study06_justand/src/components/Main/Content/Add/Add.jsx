import styles from './Add.module.css'
import {useNavigate} from "react-router-dom";
import {useBoardStore, useCafeStore, useMemberStore} from "../../../../store/store";
import {useState} from "react";

export const Add = ({type}) => {
  const { member, addMember, memberKeys } = useMemberStore();
  const { menu, addMenu, menuKeys } = useCafeStore();
  const { board, addBoard, boardKeys } = useBoardStore();
  const navi = useNavigate();

  let result = {};

  switch (type) {
    case "member" :
      result = { data: member, add: addMember, keys: memberKeys };
      break;
    case "cafe" :
      result = { data: menu, add: addMenu, keys: menuKeys };
      break;
    case "board" :
      result = { data: board, add: addBoard, keys: boardKeys };
      break;
  }

  const [ save, setSave ] = useState(result.data);

  const handleData = (e) => {
    let { name, value } = e.target;
    setSave( prev => ({ ...prev, [name]: value }));
  }

  const handleAdd = () => {
    result.add(save);
    setSave(result.data);
    navi(`/${type}/list`);
  }

  return (
    <div className={styles.container}>
        <div className={styles.form}>
          <div>{type} 추가</div>
          {
            result.keys.map( item => {
              return (
                <div>
                  <input type="text" name={item} onChange={handleData} placeholder={item + " 입력"}/>
                </div>
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