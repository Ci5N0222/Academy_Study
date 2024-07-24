import './App.css';
import { useState, useEffect } from 'react';

const CompB = () => {
  // useEffect : 코드 실행 타이밍을 지정하는 함수

  // 컴포넌트가 마운트 될 때 실행 할 함수 지정
  // 컴포넌트가 언마운트 될 때 할 함수 지정
  // 의존성 배열 내의 값이 변경될 때 실행
  useEffect(() => {
    console.log("컴포넌트 B가 마운트 될 때 및 의존성 배열이 변경될 때 실행 됨")

    return () => {
      console.log("컴포넌트 B가 언마운트 될 때 및 의존성 배열이 변경될 때 실행 됨")
    }
  }, []);

  return(
    <div>
      CompB
    </div>
  );
}

const CompA = () => {

  useEffect(() => {
    console.log("컴포넌트 A가 마운트 될 때 및 의존성 배열이 변경될 때 실행 됨")

    // Clean up 함수 (정리 함수)
    return () => {
      console.log("컴포넌트 A가 언마운트 될 때 및 의존성 배열이 변경될 때 실행 됨")
    }
  }, []);

  return (
    <div>
      CompA
    </div>
  );
}

// function App() {
//
//   const [ comp, setComp ] = useState("A");
//
//   const handleChange = () => {
//     comp === "A" ? setComp("B") : setComp("A");
//   }
//
//   return (
//     <div className="container">
//       { comp === "A" ?
//         <CompA />
//         :
//         <CompB />
//       }
//       <button onClick={ handleChange }> Comp 변경 </button>
//     </div>
//   );
// }

const App = () => {
  const [ count, setCount ] = useState(10);

  // useEffect에 두번째 파라미터
  // 비워둘 시 : 일반 코드와 같이 useEffect 콜백을 Re-rendering 시점에도 실행 함
  // [] (빈 배열) : useEffect 콜백을 마운트 될 때만 실행함
  // [ count ] : 해당 상태값이 변경될 때 마다 실행 할 수 있도록 설정

  console.log("useEffect 외부 코드");

  useEffect(() => {
    console.log("useEffect 마운트 될 때만 실행");
  }, []);

  useEffect(() => {
    console.log("useEffect Count 값이 변할 때마다 실행");
  }, [count]);

    return (
      <div className="container">
        <button onClick={()=>{setCount(count+1)}} >카운트 변경</button>
      </div>
    );
}



export default App;
