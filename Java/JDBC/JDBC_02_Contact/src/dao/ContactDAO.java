package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dto.ContactDTO;

public class ContactDAO {

	// ======================================== 공통 메서드 ==============================================
	
	/** DB connect **/
	private Connection dbConnect() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "kedu2";
		String userPw = "kedu2";
		
		return DriverManager.getConnection(url, userId, userPw);
	}
	
	// =================================================================================================
	
	/** 멤버 추가 메서드 
	 * @throws Exception **/
	public int addNewMember(String name, String phone) throws Exception {
		String sql = "insert into contact values(contact_seq.nextval, ?, ?, sysdate)";
		
		Connection con = dbConnect();
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, name);
		pstat.setString(2, phone);
		
		return pstat.executeUpdate();
	}
	
	/** 멤버 목록 메서드 **/
	public List<ContactDTO> memberList() throws Exception {
		String sql = "select * from contact order by 1";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();){
			
			List<ContactDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				Timestamp timestamp = rs.getTimestamp("reg_date");
				ContactDTO dto = new ContactDTO(id, name, phone, timestamp);
				
				list.add(dto);
			}
			
			return list;
		}
	}
	
	/** 멤버 삭제 메서드 **/
	public int deleteMember(int id) throws Exception {
		String sql = "delete from contact where id = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			
			return pstat.executeUpdate(); 
		}
	}

	/** 멤버 수정 메서드 **/
	public int updateMember(int id, String name, String phone) throws Exception {
		String sql = "update contact set name = ?, phone = ?, reg_date = sysdate where id = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, name);
			pstat.setString(2, phone);
			pstat.setInt(3, id);
					
			return pstat.executeUpdate();
		}
	}
	
	/** 검색된 멤버 목록 메서드 **/
	public List<ContactDTO> searchMemberList(String search) throws Exception {
		String sql = "select * from contact where name like ? order by 1";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			
			pstat.setString(1, "%" + search + "%");
			
			try(ResultSet rs = pstat.executeQuery();){
				List<ContactDTO> list = new ArrayList<>();
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					Timestamp timestamp = rs.getTimestamp("reg_date");
					ContactDTO dto = new ContactDTO(id, name, phone, timestamp);
					
					list.add(dto);
				}
				
				rs.close();
				
				return list;
			}
		}
	}
	
	/** id를 검색하는 메서드 **/
	public int searchById(int id) throws Exception {
		String sql = "select * from contact where id = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			
			return pstat.executeUpdate();
		}
	}
	
}
