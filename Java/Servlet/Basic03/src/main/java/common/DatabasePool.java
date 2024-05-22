package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabasePool {

//	private static BasicDataSource bds = new BasicDataSource();
	
//	static {
//		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		bds.setUsername("servlet");
//		bds.setPassword("servlet");
//		bds.setInitialSize(10);
//	}
	
	/** DB connect ( DBCP ) **/
//	public Connection dbConnect() throws Exception {
//		return bds.getConnection();
//	}
	
	public Connection dbConnect() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "servlet";
		String userPw = "servlet";
		
		return DriverManager.getConnection(url, userId, userPw);
	}
	
}
