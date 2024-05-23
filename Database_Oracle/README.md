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
