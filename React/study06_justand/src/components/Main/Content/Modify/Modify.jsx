import styles from './Modify.module.css'
import {useNavigate} from "react-router-dom";
import {useBoardStore, useCafeStore, useMemberStore} from "../../../../store/store";
import {useState} from "react";

export const Modify = ({type}) => {

  const navi = useNavigate();

  const { member, modMember, memberKeys } = useMemberStore();
  const { menu, modMenu, menuKeys } = useCafeStore();
  const { board, modBoard, boardKeys } = useBoardStore();

  let result = {};

  switch (type) {
    case "member" :
      result = { data: member, mod: modMember, keys: memberKeys };
      break;
    case "cafe" :
      result = { data: menu, mod: modMenu, keys: menuKeys };
      break;
    case "board" :
      result = { data: board, mod: modBoard, keys: boardKeys };
      break;
  }

  const [ modData, setModData ] = useState(result.data);

  const handleData = (e) => {
    let { name, value } = e.target;
    setModData( prev => ({ ...prev, [name]: value }));
  }

  const handleUpdate = () => {
    modMenu(modData);
    navi(`/${type}/list`);
  }

  return (
    <div className={styles.container}>
      <div className={styles.form}>
        <div>{type} 수정</div>
        {
          result.keys.map(item => {
            return (
              <div>
                <input type="text" name={item} onChange={handleData} placeholder={item + " 입력"}/>
              </div>
            );
          })
        }
      </div>
      <div className={styles.btn_box}>
        <button onClick={handleUpdate}>추가</button>
        <button onClick={() => navi(`/${type}/list`)}>취소</button>
      </div>
    </div>
  );
}