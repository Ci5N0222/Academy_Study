package members.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import members.dto.MembersDTO;

public class MembersDAO {

private MembersDAO() {}
	
	/** Singleton Patten **/ 
	public static MembersDAO instance;
	public static MembersDAO getInstance() {
		if(instance == null) instance = new MembersDAO();
		return instance;
	}
	
	/** DB Connection **/
	private Connection dbConnect() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	
	/**
	 * DB에 해당 아이디의 중복을 체크하는 메서드
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int duplicateById(String id) throws Exception{
		int result = 0;
		String sql = "select count(*) from members where id=?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			try(ResultSet rs = pstat.executeQuery();){
				
				rs.next();
				result = rs.getInt(1);
				
			}
			
		}
		
		return result;
	}
	
	
	public int joinMembers(MembersDTO dto) throws Exception{
		int result = 0;
		String sql = "insert into members values(?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getEmail());
			pstat.setString(6, dto.getZipcode());
			pstat.setString(7, dto.getAddress1());
			pstat.setString(8, dto.getAddress2());
			
			result = pstat.executeUpdate();
		}
		
		return result;
	}
	
}
