## Database
- 지금까지 실습하며 만들었던 프로그램의 데이터를 저장하는 장비는 RAM ( 휘발성 메모리 )
- 데이터를 반영구적으로 보관하기 위해 HDD(SSD) 장비를 이용할 필요
- 과거 HDD에 데이터를 저장하기 위해 단순 파일에 열거 방식의 저장방법을 사용함
    - 문제점
        1. 보안성: 해당 파일에 데이터가 보관된다는 것을 누군가 눈치 챈다면 쉽게 변조 및 탈취 가능
        2. 안정성 : 프로그램 오동작으로 깨진 데이터 발생시 해결을 위한 비용 발생 또는 데이터 손실이 발생함
        3. 성능 : 단순 데이터 열거 방식에 의해 데이터 검색 성능이 매우 저조함

#### DB를 사용하는 이유
- RAM은 휘발성 메모리로서 저장곤간에 역할을 하지 못함
- 데이터를 영구히 저장할 공간이 필요함

#### RAM ( 주기억 장치 )
- 휘발성 기억장치
- 데이터 기록 시 전기 신호로 저장함

### HDD ( 보조기억 장치 )
- 반영구적 기억장치
- 데이터 기록 시 자력으로 저장함

### DBMS ( Database Management System )

#### Oracle 특징
- 최초 설치 이후에 관리자 계정으로 system 계정을 제공 받으며 system 계정은 최초 관리자로 DBMS에 대한 모든 권한을 가진다.
- system 계정은 모든 작업을 수행할 수 있으나, 보편적으로 데이터 CRUD는 담당하지 않음
- 실제 데이터 CRUD는 system 계정으로 생성한 sub 계정들에 의해서 관리됨
- 생성된 서브 계정들은 자신의 고유 영역을 할당받아, 테이블 단위로 데이터를 CRUD 함
- 테이블은 행과 열로 구성되어 있으며, 데이터 저장 시 자료형을 맞추어야 함

#### DBMS는 SQL을 활용하여 시스템을 사용한다.
- SQL : Structured Query Language ( Query라고 불림 )
  - DDL ( Data Definition Language )
    - 객체에 대한 CRUD를 수행하는 쿼리문 집합
      - create : 객체 생성
      - alter : 객체 수정
      - drop : 객체 삭제
  - DML ( Data Manipulation Language )
    - 데이터에 대한 CRUD를 수행하는 쿼리문 집합
      - select : 데이터 조회
      - insert : 데이터 입력
      - update : 데이터 수정
      - delete : 데이터 삭제
  - DCL ( Data Control Language )
    - 계정에 대한 권한 부여 및 회수 쿼리문
      - grant : 권한 부여
      - revoke : 권한 회수
  - TCL ( Transaction Control Language )
    - 트랜잭션 관리 언어
      - commit
      - rollback
      - savepoint

## Query
#### Select
- where : 조건 문법
  - like, not like
  - is null, is not null
  - in
  - between A and B

- order by : 정렬 문법
  - acs ( default )
  - desc

### Select Query 동작순서
1. From : ~로 부터 ( 어디서 )
2. where : 그룹화 이전 데이터 전체에 대하여 적용될 조건
3. group by : 그룹화
4. having : group by로 이루어진 그룹들에게 적용될 조건
5. select : 조회
6. order by : 정렬

### DML
- group by
  - 그룹화 데이터를 생성하여 정보를 조회할 때 사용
    - 예 : 그룹에 속한 로우 하나의 정보를 select 할 수 없다.
  - 그룹화 된 정보만 select 할 수 있다.
  - 그룹안에 그룹을 만들 수 있다.
    - 예 : 부서별 직급으로 나눈 그룹

- having
  - group by로 그룹화된 그룹들의 조건을 부여할 때 사용

#### where에 그룹 함수를 사용할 수 없다.
#### 쿼리의 실행 순서상 where을 사용할 수 없다.

### Join
한개 이상의 테이블을 병합해 유의미한 데이터셋을 만들어내는 문법
- cross join : join의 동작 원리를 이해하기 쉬운 join 종류 ( 실전 개발에서는 쓰임이 드물다 )
  - join은 2중 for문을 생각하면 이해하기 쉽다.
  - Cartesian Product : 상징적일 뿐 의미 없음


- Inner join : 여러 테이블 간에 특정 조건을 기반으로 병합하는 문법 ( NULL 미포함 )
  - on dept_code = dept_id의 조건으로 2중 for문에 특정 조건(if)이 부합할 경우 찾아내는 것과 같다.
  - on에 컬럼명이 똑같을 수 있기 때문에 테이블에 별명을 붙여 어떤 테이블의 값을   모두 출력하게 처리하는 문법
  - inner는 생략할 수 있다.
``` bash
SELECT 
     e.emp_name,
     e.dept_code,
     d.dept_title
 FROM 
      employee e INNER JOIN department d ON e.dept_code = d.dept_id;
```
- outer join : 여러 테이블 간에 특정 조건을 기반으로 병합하는 문법 ( NULL 포함 )
  - left outer : join에 참여하는 테이블 중에 문법 상 왼쪽에 존재하는 테이블의 값을 모두 출력하게 처리하는 문법
  - right outer : join에 참여하는 테이블 중에 문법 상 오른쪽에 존재하는 테이블의 값을 모두 출력하게 처리하는 문법
  - full outer : 양쪽 테이블의 모든 값을 출력하게 처리하는 문법
  - outer는 생략 가능


- self join : 한개의 테이블을 join하는 문법 ( 특수한 경우에 간혹 사용 됨 )
``` bash
SELECT 
    e1.emp_id,
    e1.emp_name,
    e1.manager_id,
    e2.emp_name
FROM 
    employee e1 
    JOIN employee e2 ON e1.manager_id = e2.emp_id
ORDER BY
    3, 1;
```

- 다중 조인 : 3개 이상의 여러 테이블의 join

### Union