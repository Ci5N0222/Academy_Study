## JDBC
### Java + DBMS → JDBC ( Java Database Connectivity )
- 자바와 데이터베이스를 연결하는 기술

### OJDBC : Oracle + Java ( Library )
1. Connection : 로그인과 접속
2. Statement : 쿼리 전송
3. close : DBMS 세션 정리

``` bash
String url = "oracle:jdbc:thin:@localhost:1521:xe";
String userId = "user";
String userPw = "userpw";
Connection con = DriverManager.getConnection(userId, userPw, url);
Statement stat = con.createStatement();
stat.executeUpdate("insert into ...");
con.close();

executeUpdate ( return type: int ): Insert, Update, Delete 기능에 사용
executeQuery ( return type: ResultSet ): Select 조회 기능에 사용
```

### PreparedStatment
- 보안성, 성능, 편의성
- 변수를 placehoder 하여 편의성 업그레이드
``` bash
String sql = "insert into values(cafe_seq.nextval, ?, ?)";
Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);

// prepareStatement sql을 미리 컴파일 하기 때문에 성능적인 측면에서 업그레이드
PreparedStatement pstat = con.prepareStatement(sql);

// 문자열을 셋팅할 때 자동으로 쿼테이션('')을 붙여준다.
pstat.setString(1, name);
pstat.setInt(2, price);

int result = pstat.executeUpdate();
```

### PreparedStatment 사용시 주의 사항
1.  select 쿼리를 사용하는데 (parameter)가 필요한 경우 try with resource를 2중으로 사용해야 함
2. like 구문을 사용하는 경우 pstat.set 위치에 %%를 셋팅해야 한다.


### DBCP ( Database Connection Pool )
- 서비스에 Connection을 요구하는 동시접속자가 과포화 되었을 때, DBMS의 Down을 방지하는 기술
- 미리 생성된 인스턴스의 대여 및 반환 기법으로, 접속자 대기 시간은 발생할 수 있으나, DBMS는 정상 운행 됨


### try ( 예외처리 )
- try-catch
- try-finally
- try-with-resource
- 등등...
```bash
// try ~ with ~ resource
try( 무조건 close를 해야하는 요소 작성 )

try(Connection con = dbConnect();
    Statement stat = con.createStatement();) {
    
    result = stat.executeUpdate(sql);
    con.close();
}
```