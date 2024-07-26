import { useRef } from 'react';
import './App.css';
import { TableBox } from './components/TableBox/TableBox';
import { UlBox } from './components/UlBox/UlBox';

/**
 * let은 값이 변할 수 있는 변수, const는 한번 값을 대입하면 변경이 불가능한 상수
 * const TableBox = function(){} // <-- ECMA6 이전 style
 * 아래와 같이 UI를 만들어 변환하는 함수를 Funtional Component라고 한다.
 * UI를 Funtional Component로 구성할 경우, 함수처럼 재사용성을 가질 수 있음 ( 유지보수 비용 절감 )
 * 
 * React Hooks 사용 빈도순 → useState / useEffect / useNavigate / useStore / useRef / useLocation
 * useRef 
 * → 리렌더링을 유발하지 않음
 * → 직접 도큐먼트 엘리멘트에 직접 접근해야 할 경우 사용
 * → document.getElementById("id")
 * → 외부 라이브러리에서 강요하는 경우 사용해야하기 때문에 알아두면 좋다~
 * → UI의 영향을 주지 않는 값을 사용하는 경우
 * → document.getElementById 처럼 대상의 주소(Ref)가 필요한 경우 - focus, 라이브러리 사용할 때 종종 발생
 * → 리렌더링에도 변경되지 않는 값 이 필요한 경우 사용
 * → 리렌더링을 유발하지 ㅇ낳고 리렝더링에도 변경되지 않는 값이 필요한 경우 
 */

const App = () => {
  const inputRef = useRef(null);

  const handleTest = () => {
    document.getElementById("input")
    // useRef는 .current로 사용
    inputRef.current.value="";
  }

  return (
    <div>
      <TableBox />
      <UlBox />
      <input ref={ inputRef } type="text" value="Hello" />
      <button onClick={ handleTest }>테스트</button>
    </div>
  );
}

export default App