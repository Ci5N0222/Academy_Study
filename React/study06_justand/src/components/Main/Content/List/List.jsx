import styles from './List.module.css'
import {useBoard, useCafe, useMember} from "../../../../store/store";

export const List = ({ type }) => {

  const { members, memberKeys } = useMember();
  const { menus, menuKeys} = useCafe();
  const { board, boardKeys } = useBoard();

  let result = {}

  switch (type) {
    case "member" :
      result = { datas: members, keys: memberKeys };
      break;
    case "cafe" :
      result = { datas: menus, keys: menuKeys };
      break;
    case "board" :
      result = { datas: board, keys: boardKeys };
      break;
  }

  return (
      <div className={ styles.container }>
        <table>
            <tr>
              {
                result.keys.map( item => {
                  return (
                    <th>{ item }</th>
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