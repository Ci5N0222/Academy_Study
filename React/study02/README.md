## React Module CSS
- 컴포넌트 별 폴더 구조에서 .css 파일을 같이 관리
- 이름을 글로벌 클래스 네임으로 지을 경우 최종적으로 배포할 때 문제가 생길 수 있음
    - TableBox에 클래스네임이 .table인 것과 UlBox에 클래스네임이 .table인 것이 같이 있다면 최종적으로 .table 클래스를 지정한 css가 두개 생김

* 로컬 스코핑 모듈 스타일
- 특정 파일 내에서만 사용할 수 있는 이름으로 자동 생성되는 기술
- 특정 컴포넌트 내에서 해당 컴포넌트를 사용할 수 있게 생성
    - 파일 생성 : 컴포넌트명.module.css
    - JSX 파일에 임포트 import styles from './Header.module.css';
    - 사용 : <div className={ styles.header }>
    - 브라우저 적용 : class="Header_header__be6Ra"


