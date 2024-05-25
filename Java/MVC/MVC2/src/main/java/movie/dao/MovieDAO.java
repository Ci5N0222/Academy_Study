package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import movie.dto.MovieDTO;

public class MovieDAO {
	
	private MovieDAO() {}
	
	/** Singleton Patten **/ 
	public static MovieDAO instance;
	public static MovieDAO getInstance() {
		if(instance == null) instance = new MovieDAO();
		return instance;
	}
	
	/** DB Connection **/
	private Connection dbConnect() throws Exception {
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	
	/**
	 * 입력 받은 Movie의 정보를 DB에 저장하는 메서드
	 * @param title
	 * @param genre
	 * @return
	 * @throws Exception
	 */
	public int addMovie(String title, String genre) throws Exception {
		String sql = "insert into movie values(movie_seq.nextval, ?, ?)";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, title);
			pstat.setString(2, genre);
			
			return pstat.executeUpdate();
		}
	}
	
	
	/**
	 * DB에 저장된 Movie 의 목록을 보여주는 메서드
	 * @return
	 * @throws Exception
	 */
	public List<MovieDTO> movieList() throws Exception {
		List<MovieDTO> list = new ArrayList<>();
		
		String sql = "select * from movie order by id desc";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet res = pstat.executeQuery()){
			
			while(res.next()) {
				int id = res.getInt("id");
				String title = res.getString("title");
				String genre = res.getString("genre");
				
				list.add(new MovieDTO(id, title, genre));
			}
			
		}
		return list;
	}
	
	
	/**
	 * DB에 저장된 Movie를 지우는 메서드
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteMovie(int id) throws Exception {
		String sql = "delete from movie where id = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, id);
			return pstat.executeUpdate();
		}
		
	}
	
	
	/**
	 * DB에 저장된 특정 Movie를 id를 통해 찾기
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MovieDTO searchMovie(int id) throws Exception {
		String sql = "select * from movie where id = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, id);
			
			try(ResultSet rs = pstat.executeQuery()){
				rs.next();
				int idx = rs.getInt("id");
				String title = rs.getString("title");
				String genre = rs.getString("genre");
				
				return new MovieDTO(idx, title, genre);
			}
		}
	}
	
	
	/**
	 * DB에 저장된 Movie의 정보를 업데이트하는 메서드
	 * @param id
	 * @param title
	 * @param genre
	 * @return
	 * @throws Exception
	 */
	public int updateMovie(int id, String title, String genre) throws Exception {
		String sql = "update movie set title = ?, genre = ? where id = ?";
		try(Connection con = dbConnect();
			PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, title);
			pstat.setString(2, genre);
			pstat.setInt(3, id);
			
			return pstat.executeUpdate();
		}
	}
	
}
