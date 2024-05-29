package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.BoardDTO;

public class BoardDAO {
	
	/** Singleton Patten **/ 
	private static BoardDAO instance;
	public static BoardDAO getInstance() {
		if(instance == null) instance = new BoardDAO();
		return instance;
	}
	
	/** DB Connection **/
	private Connection dbConnect() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	
	/**
	 * 글 목록 반환하는 메서드
	 * @return
	 * @throws Exception
	 */
	public List<BoardDTO> getList() throws Exception {
		List<BoardDTO> list = new ArrayList<>();
		
		String sql = "select * from board";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery()){
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				Timestamp write_date = rs.getTimestamp("write_date");
				int count = rs.getInt("view_count");
				
				list.add(new BoardDTO(seq, writer, title, contents, write_date, count));
			}
		}
		
		return list;
	}
	
	
	/**
	 * 게시글 디테일 메서드
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BoardDTO boardDetail(int id) throws Exception {
		String sql = "select * from board where seq = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, id);
			
			try(ResultSet rs = pstat.executeQuery()){
				
				if(rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
					Timestamp write_date = rs.getTimestamp("write_date");
					int count = rs.getInt("view_count");
					
					return new BoardDTO(seq, writer, title, contents, write_date, count);
				} else {
					return null;
				}
			}
		}
	}
	
	
	/**
	 * 게시글 작성
	 * @param writer
	 * @param title
	 * @param contents
	 * @return
	 * @throws Exception
	 */
	public int write(String writer, String title, String contents) throws Exception {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			
			pstat.setString(1, writer);
			pstat.setString(2, title);
			pstat.setString(3, contents);
			
			return pstat.executeUpdate();
		}
		
	}
	
	
	/**
	 * 게시물 제목 검색
	 * @param search
	 * @return
	 * @throws Exception
	 */
	public List<BoardDTO> searchList(String search) throws Exception {
		List<BoardDTO> list = new ArrayList<>();
		
		String sql = "select * from board where title like ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, "%"+ search +"%");
			
			try (ResultSet rs = pstat.executeQuery()){
				while(rs.next()) {
					int seq = rs.getInt("seq");
					String writer = rs.getString("writer");
					String title = rs.getString("title");
					String contents = rs.getString("contents");
					Timestamp write_date = rs.getTimestamp("write_date");
					int count = rs.getInt("view_count");
					
					list.add(new BoardDTO(seq, writer, title, contents, write_date, count));
				}
			}
			
		}
		
		return list;
	}
	
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public int deleteContents(int idx, String writer) throws Exception {
		System.out.println("dao idx ==== " + idx);
		System.out.println("dao writer ==== " + writer);
		
		String sql= "delete from board where seq = ? and writer = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, idx);
			pstat.setString(2, writer);
			
			return pstat.executeUpdate();
		}
	}
	
	
	/**
	 * 게시글을 수정하는 메서드
	 * @param seq
	 * @param writer
	 * @param title
	 * @param contents
	 * @return
	 * @throws Exception
	 */
	public int updateContents(int seq, String writer, String title, String contents) throws Exception {
		String sql = "update board set title = ?, contents = ? where seq = ? and writer = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, title);
			pstat.setString(2, contents);
			pstat.setInt(3, seq);
			pstat.setString(4, writer);
			
			return pstat.executeUpdate();
		}
		
	}
	
	
}
