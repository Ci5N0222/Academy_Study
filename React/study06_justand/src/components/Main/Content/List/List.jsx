import styles from './List.module.css'
import {useBoardStore, useCafeStore, useMemberStore} from "../../../../store/store";

export const List = ({ type }) => {

  const { members, memberKeys } = useMemberStore();
  const { menus, menuKeys} = useCafeStore();
  const { boards, boardKeys } = useBoardStore();

  let result = {};

  switch (type) {
    case "member" :
      result = { datas: members, keys: memberKeys };
      break;
    case "cafe" :
      result = { datas: menus, keys: menuKeys };
      break;
    case "board" :
      result = { datas: boards, keys: boardKeys };
      break;
  }

  return (
      <div className={ styles.container }>
        <table>
            <tr>
              {
                result.keys.map( (item, i) => {
                  return (
                    <th key={i}>{ item }</th>
                  );
                })
              }
            </tr>
          {
            result.datas.map((item, i) => {
              return (
                <tr key={ i }>
                  { result.keys.map( key => <td>{item[key]}</td> ) }
                </tr>
              );
            })
          }
        </table>
      </div>
  );
}