## React Hooks

### useState()
- 상태 값이 바뀌는 변수들은 state를 통해 관리한다.
- state의 변화는 component를 재 호출한다.
- 2개의 값을 가진 배열을 반환
    - 0번 인덱스 : 상태 값
    - 1번 인덱스 : 상태 값을 변경할 수 있는 Setter

### Re-Rendering
- state의 변화로 component가 Re-Rendering 됨
- state로 관리하는 변수가 아닌 일반 let,const로 선언할 변수들은 component가 Re-Rendering될 때 초기화 됨 ( Component가 Re-Rendering 된다는 것은 Functional component가 재호출 됨을 의미 )
- state 함수 관련 상태 값은 Re-Rendering에도 값이 초기화되지 않음

### Mount / UnMount
- mount : 최초의 Component가 처음으로 그려지는 경우
- unmount : component가 특정 명명에 의해 브라우저에서 아예 제거되는 상황
- 새로고침은 unmount → mount 기능과 같음
- 이 때, state로 관리되는 상태 값도 초기화 된다.

## Destructuring
- 구조 분해 할당 : 배열이나 객체같은 복잡한 구조를 분해하여 변수에 할당하는 기법
- const [count, setCount] = useState(0);
``` bash
    // 배열을 Destructuring
    const numbers = [1, 2, 3];
    const [a, b, c, d=10] = numbers;
    console.log(a, b, c, d);

    // 객체
    const person = { id: 1001, name:"Tom", age: 20};
    const {id, name, age} = person;
    console.log(`${id} ${name} ${age}`);

    // 함수
    const func = ([a, b, c]) => {
        console.log(a, b, c);
    }
    func(numbers);

    const func2 = ({id, name}) => {
        console.log(id, name);
    }
    func2(person);
```

## Map
forEach와 map은 배열 반복문이다.
- forEach : 반환 값이 없음
- map : 해당 배열 반복문을 돌면서 리턴 값을 저장한 배열을 반환
``` bash

// ============= 배열 반복문 =============
    const members = [1, 2, 3, 4, 5];

    members.forEach(item => {
        console.log("forEach === ", item);
    });

    let map = members.map(item => {
        console.log("map === ", item);
        return item * item;
    });

    console.log(map);

// ============= 객체 배열 반복문 =============
    const users = [
        { id : 1, name : "Tom", age : 20 },
        { id : 2, name : "Sara", age : 15 },
        { id : 3, name : "Jane", age : 30 }
    ];
    
    // Destructuring 기법을 사용
    let obj = users.map( ({name, age}) => ({ name, age }));

```

## Spread
- 배열, 오브젝트의 괄호를 벗기는 방법
- 배열에 새로운 요소를 추가할 때 사용
``` bash
    const arr1 = [1, 2, 3];
    const arr2 = [4, 5, 6];
    const arr3 = [0, ...arr1, ...arr2, 7, 9];

    // 객체 스프레드는 객체({}중괄호) 안에서만 가능
    const obj1 = { a: 1, b: 2 };
    const obj2 = { c: 3, d: 4 };
    const obj3 = { ...obj1, ...obj2, e: 5 }

```