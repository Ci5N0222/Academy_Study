package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.FilesDTO;

public class FilesDAO {
	
	/** Singleton Patten **/ 
	private static FilesDAO instance;
	public static FilesDAO getInstance() {
		if(instance == null) instance = new FilesDAO();
		return instance;
	}
	
	/** DB Connection **/
	private Connection dbConnect() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	
	/**
	 * 파일을 업로드하는 메서드
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int insert(FilesDTO dto) throws Exception {
		String sql = "insert into files values(files_seq.nextval, ?, ?, ?)";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getOriname());
			pstat.setString(2, dto.getSysname());
			pstat.setInt(3, dto.getParent_seq());
			
			return pstat.executeUpdate();
		}
		
	}
	
	public List<FilesDTO> fileList(int prentSeq) throws Exception {
		String sql = "select * from files where parent_seq = ? order by seq";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, prentSeq);
			
			List<FilesDTO> list = new ArrayList<>();
			
			try(ResultSet rs = pstat.executeQuery()){
				while(rs.next()) {
					int seq = rs.getInt("seq");
					String oriName = rs.getString("oriname");
					String sysName = rs.getString("sysname");
					
					
					list.add(new FilesDTO(seq, oriName, sysName, prentSeq));
				}
				
				return list;
			}
		}
	}
	
}
