package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam04 {

	public static void main(String[] args) throws Exception {
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kedu";
		String dbPW = "kedu";
		
		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
		Statement stat = con.createStatement();
		String sql = "select * from cafe";
		
		// ResultSet은 쿼리 전달 후 발생한 결과의 주소를 가지는 인스턴스
		ResultSet rs = stat.executeQuery(sql);
		
		System.out.println("======================");
		
		// .next() 화살표를 하나씩 내려주는 메서드(다음 행의 쿼리로 이동)
		// .next() 의 리턴 값은 boolean 타입이기 때문에 next 값이 없다면 false를 반환하므로 while문 이탈
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int price = rs.getInt("price");
			
			System.out.println("id : " + id);
			System.out.println("name : " + name);
			System.out.println("price : " + price);
			System.out.println("======================");
		}
		
		con.close();
		
		
	}

}
