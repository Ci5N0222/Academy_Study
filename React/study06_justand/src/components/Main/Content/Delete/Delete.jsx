import styles from './Delete.module.css'
import {useNavigate} from "react-router-dom";
import {useBoardStore, useCafeStore, useMemberStore} from "../../../../store/store";

export const Delete = () => {

  const navi = useNavigate();

  const {} = useMemberStore();
  const {} = useCafeStore();
  const {} = useBoardStore();

  return (
    <div>

    </div>
  );
}