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
	
	
	public String getPageNavi(int currentPage) throws Exception {
			
		// 1. "전체 글"의 개수
		int recordTotalCount = this.getRecordCount();	// 향후 데이터 베이스에서 알아와야 하는 값
		
		// 2. "한 페이지"에 보여질 "글"의 개수 결정
		int recordCountPerPage = BoardConfig.RECODE_COUNT_PER_PAGE;
		
		// 3. 페이지에 보여질 네비게이터의 개수 결정
		int naviCountPerPage = BoardConfig.NAVI_COUNT_PER_PAGE;
		
		// 4. 총 "페이지"의 개수
		int pageTotalCount = 0; 
		
		// 총 페이지 수를 담아줌
		if(recordTotalCount % recordCountPerPage > 0) pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		else pageTotalCount = recordTotalCount / recordCountPerPage;
		
		// 현재 위치
//		int currentPage = 1	// 향후 클라이언트가 누르는 번호로 대체 될 예정
		
		// 네비게이터의 시작 번호
		int startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
		
		// 네비게이터의 마지막
		int endNavi = startNavi + naviCountPerPage - 1;
		
		if(endNavi > pageTotalCount) endNavi = pageTotalCount;
			
		boolean needNext = true;
		boolean needPrev = true;
		
		if(startNavi == 1) needPrev = false;
		if(endNavi == pageTotalCount) needNext = false;
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev) sb.append("<a href='/list.board?cpage=" + (startNavi-1) + "'>" + "< </a>");
		
		// 네비게이터 시작~마지막 까지 번호 출력
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/list.board?cpage=" + i + "'>" + i + "</a> ");
		}
		if(needNext) sb.append("<a href='/list.board?cpage=" + (endNavi+1) + "'>></a>");
		
		return sb.toString();
	}
}
