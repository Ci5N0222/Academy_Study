package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import common.Util;

public class MemberDAO {
	
	Util util = new Util();
	
	/** DB Connect **/
	private Connection dbConnect() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "kedu2";
		String userPw = "kedu2";
		
		return DriverManager.getConnection(url, userId, userPw);
	}
	
	/** 로그인 유효 검사 **/
	public String userExist(String id, String pw) throws Exception {
		String sql = "select * from members where id = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			
			try(ResultSet rs = pstat.executeQuery();) {
				
				if(rs.next()) {
					if(rs.getString(2).equals(util.getSHA512(pw))) {
						return "로그인 성공!!!";
					} else {
						return "패스워드가 틀렸습니다.";
					}
					
				} else {
					return "존재하지 않는 ID 입니다.";
				}
			}
		}
	}
	
	/** 회원가입 **/
	public int addMembers(String id, String pw, String name) throws Exception {
		String sql = "insert into members values('?, ?, ?')";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			pstat.setString(2, util.getSHA512(pw));
			pstat.setString(3, name);
			
			return pstat.executeUpdate();
		}
	}
	
}
