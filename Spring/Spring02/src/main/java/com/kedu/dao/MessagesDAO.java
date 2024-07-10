package com.kedu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MessagesDTO;


@Repository
public class MessagesDAO {
	
	@Autowired
	private SqlSession mybatis;
	
	public List<Map<String, Object>> list() {
		return mybatis.selectList("Messgaes.selectAll");
	}
	
	public List<MessagesDTO> search(Map<String, String> map) {
		return mybatis.selectList("Messgaes.selectSearch", map);
	}
	
	public List<MessagesDTO> searchMulti(Map<String, String> map) {
		return mybatis.selectList("Messgaes.selectSearchMulti", map);
	}
	
	public int insert(MessagesDTO dto) {
		mybatis.insert("Messgaes.insert", dto);
		return dto.getSeq();
	}
	
	public int update(MessagesDTO dto) {
		return mybatis.update("Messgaes.update", dto);
	}
	
	public int delete(int seq) {
		return mybatis.delete("Messgaes.delete", seq);
	}
	

//	@Autowired
//	private JdbcTemplate jdbc;
//	
//	/** Insert **/
//	public int insert(MessagesDTO dto) throws Exception {
//		String sql = "insert into messages values(messages_seq.nextval, ?, ?)";
//		return jdbc.update(sql, dto.getWriter(), dto.getMessage());
//	}
//	
//	/** List Count **/
//	public int selectCount() throws Exception {
//		String sql = "select count(*) from messages";
//		return jdbc.queryForObject(sql, Integer.class);
//	}
//	
//	/** List **/
//	public List<MessagesDTO> selectAll() throws Exception {
//		String sql = "select * from messages order by seq desc";
//		return jdbc.query(sql, new BeanPropertyRowMapper<>(MessagesDTO.class));
//	}
//	
//	/** Detail **/
//	public MessagesDTO selectBySeq(int seq) throws Exception{
//		String sql = "select * from messages where seq = ?";
//		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(MessagesDTO.class), seq);
//	}
//	
//	/** Update **/
//	public int update(MessagesDTO dto) throws Exception {
//		String sql = "update messages set writer = ?, message = ? where seq = ?";
//		return jdbc.update(sql, dto.getWriter(), dto.getMessage(), dto.getSeq());
//	}
//	
//	/** Delete **/
//	public int delete(int seq) throws Exception {
//		String sql = "delete from messages where seq = ?";
//		return jdbc.update(sql, seq);
//	}
	

	
//	@Autowired
//	private BasicDataSource bds;
//	
//	
//	/**
//	 * 메세지 작성
//	 * @param dto
//	 * @return
//	 * @throws Exception
//	 */
//	public int insert(MessagesDTO dto) throws Exception {
//		String sql = "insert into messages values(messages_seq.nextval, ?, ?)";
//		
//		try(Connection con = bds.getConnection();
//			PreparedStatement pstat = con.prepareStatement(sql)){
//			pstat.setString(1, dto.getWriter());
//			pstat.setString(2, dto.getMessage());
//			
//			return pstat.executeUpdate();
//		}
//	}
//	
//	
//	/**
//	 * 메세지 목록
//	 * @return
//	 * @throws Exception
//	 */
//	public List<MessagesDTO> selectAll() throws Exception {
//		String sql = "select * from messages order by seq desc";
//		
//		try(Connection con = bds.getConnection();
//			PreparedStatement pstat = con.prepareStatement(sql);
//			ResultSet rs = pstat.executeQuery()){
//			
//			List<MessagesDTO> list = new ArrayList<>();
//		
//			while(rs.next()) {
//				int seq = rs.getInt("seq");
//				String writer = rs.getString("writer");
//				String message = rs.getString("message");
//				
//				list.add(new MessagesDTO(seq, writer, message));
//			}
//			
//			return list;
//		}
//	}
//	
//	
//	/**
//	 * 메세지 삭제
//	 * @param seq
//	 * @return
//	 * @throws Exception
//	 */
//	public int delete(int seq) throws Exception {
//		String sql = "delete from messages where seq = ?";
//		
//		try(Connection con = bds.getConnection();
//			PreparedStatement pstat = con.prepareStatement(sql)){
//			pstat.setInt(1, seq);
//			
//			return pstat.executeUpdate();
//		}
//	}
//	
//	
//	/**
//	 * 메세지 수정
//	 * @param dto
//	 * @return
//	 * @throws Exception
//	 */
//	public int update(MessagesDTO dto) throws Exception {
//		String sql = "update messages set writer = ?, message = ? where seq = ?";
//		
//		try(Connection con = bds.getConnection();
//			PreparedStatement pstat = con.prepareStatement(sql)){
//			pstat.setString(1, dto.getWriter());
//			pstat.setString(2, dto.getMessage());
//			pstat.setInt(3, dto.getSeq());
//			
//			return pstat.executeUpdate();
//		}
//	}
	
}
