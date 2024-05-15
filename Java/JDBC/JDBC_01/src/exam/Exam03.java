package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam03 {

	public static void main(String[] args) throws Exception {
		
		// Americano에 해당하는 항목을 id 기반으로 삭제
		
		
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kedu";
		String dbPW = "kedu";
		

		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
		
		Statement stat = con.createStatement();
		
		String sql = "delete from cafe where id=1001";
		
		int result = stat.executeUpdate(sql);
		
		if(result > 0) System.out.println("삭제 완료");
		
		con.close();
	}

}
