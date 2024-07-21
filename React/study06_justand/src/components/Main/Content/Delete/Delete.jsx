import styles from './Delete.module.css'
import {useNavigate} from "react-router-dom";
import {useBoardStore, useCafeStore, useMemberStore} from "../../../../store/store";
import {useState} from "react";

export const Delete = ({type}) => {

  const navi = useNavigate();
  const { delMember } = useMemberStore();
  const { delMenu } = useCafeStore();
  const { delBoard } = useBoardStore();

  let result = {};
  switch (type) {
    case "member" :
      result = { del: delMember };
      break;
    case "cafe" :
      result = { del: delMenu };
      break;
    case "board" :
      result = { del: delBoard };
      break;
  }

  const [delData, setDelData] = useState(0);
  const handleData = (e) => {
    setDelData(parseInt(e.target.value));
  }

  const handleDelete = (id) => {
    result.del(id);
    navi(`/${type}/list`);
  }

  return (
    <div className={styles.container}>
      <div className={styles.form}>
        <div>{type} 삭제</div>
        <div>
          <input type="text" onChange={ handleData } placeholder="ID 입력"/>
        </div>
        <div className={styles.btn_box}>
          <button onClick={handleDelete}>삭제</button>
          <button onClick={() => navi(`/${type}/list`)}>취소</button>
        </div>
      </div>

    </div>
  );
}