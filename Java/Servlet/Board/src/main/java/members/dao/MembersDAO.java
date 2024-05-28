package members.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import common.Sha512;
import members.dto.MembersDTO;
import oracle.jdbc.proxy.annotation.Pre;

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
	 * 중복체크 메서드
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
	
	
	/**
	 * 회원가입 메서드
	 * @param dto
	 * @return
	 * @throws Exception
	 */
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
			
			return pstat.executeUpdate();
		}
	}
	
	
	/**
	 * 회원 탈퇴 메서드
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int outMembers(String id) throws Exception {
		String sql = "delete from members where id = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			
			return pstat.executeUpdate();
		}
	}
	
	
	/**
	 * 로그인 메서드
	 * @param id
	 * @param pw
	 * @return
	 * @throws Exception
	 */
	public String signIn(String id, String pw) throws Exception {
		String sql = "select * from members where id = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			
			try(ResultSet rs = pstat.executeQuery()){
						
				if(rs.next()) {
					if(rs.getString("pw").equals(Sha512.getSHA512(pw))) return "success";
					else return "pw_fail";
					
				} else {
					return "id_fail";
				}
			}
		}
	}
	
	
	/**
	 * 마이페이지 메서드
	 * @param searchId
	 * @return
	 * @throws Exception
	 */
	public MembersDTO myPage(String searchId) throws Exception {
		String sql = "select * from members where id = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, searchId);
			
			 try(ResultSet rs = pstat.executeQuery()){
				 
				 if(rs.next()) {
					 String id = rs.getString("id");
					 String name = rs.getString("name");
					 String phone = rs.getString("phone");
					 String email = rs.getString("email");
					 String zipcode = rs.getString("zipcode");
					 String address1 = rs.getString("address1");
					 String address2 = rs.getString("address2");
					 Timestamp join_date = rs.getTimestamp("join_date");
					 
					 return new MembersDTO(id, null, name, phone, email, zipcode, address1, address2, join_date);
					 
				 } else {
					 return null;
				 }
			 }
		}	 
	}
	
	
	/**
	 * 회원 정보를 수정하는 메서드
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int updateMembers(MembersDTO dto) throws Exception {
		String sql = "update members set name = ?, phone = ?, email = ?, zipcode = ?, address1 = ?, address2= ? where id = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getPhone());
			pstat.setString(3, dto.getEmail());
			pstat.setString(4, dto.getZipcode());
			pstat.setString(5, dto.getAddress1());
			pstat.setString(6, dto.getAddress2());
			pstat.setString(7, dto.getId());
			
			return pstat.executeUpdate();
		}
	}
	
	
}
