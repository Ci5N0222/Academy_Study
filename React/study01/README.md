## React Study01

### MPA ( Multi Page Application )
- 여러 페이지로 앱을 구성하는 방식
- JSP / Servlet , Thymlead ...

### SPA ( Single Page Application )
- 한개의 페이지에서 형태를 변경해가며 모든 페이지를 전담
- React, Vue ... 

### SSR ( Server Side Rendering )
- 화면 구성을 서버가 진행하고 클라이언트에게 전달하는 방식

### CSR ( Client Side Rendering )
- 화면 구성을 프론트에서 전담하므로 서버의 부하를 줄일 수 있음
- 서버의 역할이 데이터 관리 및 전송 역할로 한정된다.
- RESTful 서비스로 구축 - JAVA의 @ResponseBody 통신

## React
- PureJS와 비교해서 상대적으로 고난이도 ( 러닝커브 높음 )
- JSX 기반의 자체 렌더링 매커니즘을 가짐
- ECMA6을 베이스로 사용하는 것이 일반적
- Functional Components 구성으로 UI 재사용성 확보

### Start
``` bash
// CRA 템플릿으로 시작
$ npx create-react-app [project-name]
```

### React Directory
** Page 기반 or Components 기반
- node_modules
    - 라이브러리 보관
- public
    - 정적 파일 보관
src
    - 코드 작성 공간
- package.json
    - 라이브러리 정보

## React Philosophy
- 상태가 UI를 만든다
- 모든 엘레멘트의 값은 리액트의 상태에 의해 변경되어야 한다.

