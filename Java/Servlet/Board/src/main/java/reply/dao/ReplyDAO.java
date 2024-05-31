package reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import reply.dto.ReplyDTO;

public class ReplyDAO {
	
	/** Singleton Patten **/ 
	public static ReplyDAO instance;
	public static ReplyDAO getInstance() {
		if(instance == null) instance = new ReplyDAO();
		return instance;
	}
	
	/** DB Connection **/
	private Connection dbConnect() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	
	/**
	 * 댓글을 작성하는 메서드
	 * @param writer
	 * @param contents
	 * @param parentSeq
	 * @return
	 * @throws Exception
	 */
	public int insertReply(String writer, String contents, int parentSeq) throws Exception {
		String sql ="insert into reply values(reply_seq.nextval, ?, ?, sysdate, ?)";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, writer);
			pstat.setString(2, contents);
			pstat.setInt(3, parentSeq);
			
			return pstat.executeUpdate();
			
		}
	}
	
	
	/**
	 * 댓글 목록을 반환하는 메서드
	 * @param parentSeq
	 * @return
	 * @throws Exception
	 */
	public List<ReplyDTO> replyList(int parentSeq) throws Exception {
		String sql = "select * from reply where parent_seq = ? order by seq desc";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, parentSeq);
			
			List<ReplyDTO> list = new ArrayList<>();
			try(ResultSet rs = pstat.executeQuery()){
				while(rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String contents = rs.getString("contents");
					Timestamp write_date = rs.getTimestamp("write_date");
					int parent_seq = rs.getInt("parent_seq");
					
					list.add(new ReplyDTO(seq, writer, contents, write_date, parent_seq));
					
				}
			}
			
			return list;
		}
	}
	
	
	/**
	 * 댓글을 삭제하는 메서드
	 * @param seq
	 * @return
	 * @throws Exception
	 */
	public int deleteReply(int seq) throws Exception {
		String sql = "delete from reply where seq = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, seq);
			
			return pstat.executeUpdate();
		}
	}
	
	
	public int updateReply(int seq, String contents) throws Exception {
		String sql = "update reply set contents = ? where seq = ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, contents);
			pstat.setInt(2, seq);
			
			return pstat.executeUpdate();
		}
	}
	
	
}
