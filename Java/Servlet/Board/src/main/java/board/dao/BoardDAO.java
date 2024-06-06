package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.BoardDTO;
import common.BoardConfig;

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
	 * 글의 총 개수를 반환하는 메서드
	 * @return
	 * @throws Exception
	 */
	public int getRecordCount() throws Exception {
		String sql = "select count(*) from board";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery()){
			rs.next();
			return rs.getInt(1);
		}
		
	}
	
	
	/**
	 * 글 목록 반환하는 메서드
	 * @return
	 * @throws Exception
	 */
	public List<BoardDTO> getList() throws Exception {
		List<BoardDTO> list = new ArrayList<>();
		
		String sql = "select * from board order by seq desc";
		
		
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
	 * 지정한 개수만큼의 글 목록을 반환하는 메서드
	 * @param startR
	 * @param endR
	 * @return
	 * @throws Exception
	 */
	public List<BoardDTO> getListNtoM(int startR, int endR) throws Exception {
		List<BoardDTO> list = new ArrayList<>();
		
		String sql = "select * from (select board.*, row_number() over(order by seq desc) rown from board) where rown between ? and ?";
		
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
				pstat.setInt(1, startR);
				pstat.setInt(2, endR);
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
	
//	 public int write(String writer, String title, String contents) throws Exception {
//		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
//		try(Connection con = dbConnect();
//			PreparedStatement pstat = con.prepareStatement(sql, new String[] {"seq"})){
//			
//			pstat.setString(1, writer);
//			pstat.setString(2, title);
//			pstat.setString(3, contents);
//			
//			pstat.executeUpdate();
//			
//			try(ResultSet rs = pstat.getGeneratedKeys();){
//				rs.next();
//				return rs.getInt("seq");
//			}
//		}
//	}	
	
	
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
	
	
	/**
	 * 디테일 진입시 조회수가 1씩 증가하는 메서드
	 * @param seq
	 * @throws Exception
	 */
	public void viewCountUp(int seq) throws Exception {
		String sql = "update board set view_count = view_count + 1 where seq = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, seq);
			pstat.executeUpdate();
		}
	}
	
	
	public int seqByWirter(String writer) throws Exception {
		String sql = "select seq from board where writer = ? order by seq desc";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, writer);
			
			try(ResultSet rs = pstat.executeQuery()){
				rs.next();
				return rs.getInt("seq");
			}
		}
	}
	
}
