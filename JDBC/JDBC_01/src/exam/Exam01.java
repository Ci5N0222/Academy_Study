package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) throws Exception {
		
		/**
		 *  Main / DTO / DAO
		 * 	DAO 내의 addCafe 기능의 내용이 DBMS로 데이터를 저장하는 코드로 변경되어야 함
		 * 	기존: ArrayList에 저장하고 있음
		 * 
		 *	실전 코드
		 *	DBMS ( localhost - 1521 ) 에 연결시도
		 *  OJDBC ( Oracle Java DataBase Connectivity ) 라이브러리
		 */
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴의 이름: ");
		String name = sc.nextLine();
		
		System.out.print("메뉴의 가격: ");
		int price = Integer.parseInt(sc.nextLine());
		
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kedu";
		String dbPW = "kedu";
		
		// DB connect ( DBMS에 접속 )
//		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
		
		// Query를 쓸 수 있는 편집기 객체 확보
//		Statement stat = con.createStatement();
		
		// → 보안성, 성능, 편의성
		// → PreparedStatement
		// 변수를 placeholder하여 편의성 업그레이드
		String sql = "insert into values(cafe_seq.nextval, ?, ?)";
		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
		// prepareStatement sql을 미리 컴파일 하기 때문에 성능적인 측면에서 업그레이드
		PreparedStatement pstat = con.prepareStatement(sql);
		// 문자열을 셋팅할 때 자동으로 쿼테이션(')을 붙여준다.
		pstat.setString(1, name);
		pstat.setInt(2, price);
		int result = pstat.executeUpdate();
		
		
		
		// stat.executeUpdate();	// Insert, Update, Delete ( 실제 DB에 영향을 주는 쿼리를 사용할 때 )
		// stat.executeQuery();		// Select ( DB에 영향을 주지 않는 조회 쿼리를 사용할 때 )
		
		// 데이터 인서트
//		String sql = "insert into cafe values(cafe_seq.nextval, '"+ name +"', "+ price +")";
//		int result = stat.executeUpdate(sql);
//		if(result > 0) System.out.println(result + "개 입력 성공!!!");
//		else System.out.println("입력 실패!!!");
		
		// 데이터 삭제
//		String updateSql = "delete from cafe where id=1003";
//		int result = stat.executeUpdate(updateSql);
		
		// 조회
//		String read = "select * from cafe";
//		ResultSet rs = stat.executeQuery(read);
//		while(rs.next()) {
//			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
//		}
		
		
//		rs.close();
//		stat.close();
//		// DB close
//		con.close();
		
	}

}
