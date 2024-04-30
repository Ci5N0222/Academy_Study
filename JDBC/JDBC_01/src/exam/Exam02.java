package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam02 {

	public static void main(String[] args) throws Exception {
		
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbID = "kedu";
		String dbPW = "kedu";
		
		
		// DB connect
		Connection con = DriverManager.getConnection(dbURL, dbID, dbPW);
		
		Statement stat = con.createStatement();
		
//		String sql = "update cafe set price = 3500 where id=1005";
//		stat.executeUpdate(sql);
		
		String select = "select * from cafe";
		ResultSet rs = stat.executeQuery(select);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
		}
		
		// DB close
		con.close();
		
	}

}
