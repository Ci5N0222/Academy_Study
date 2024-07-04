package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
	@Autowired
	private BasicDataSource bds;
	
	
	/**
	 * 메세지 작성
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int insert(MessagesDTO dto) throws Exception {
		String sql = "insert into messages values(messages_seq.nextval, ?, ?)";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			
			return pstat.executeUpdate();
		}
	}
	
	
	/**
	 * 메세지 목록
	 * @return
	 * @throws Exception
	 */
	public List<MessagesDTO> selectAll() throws Exception {
		String sql = "select * from messages order by seq desc";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery()){
			
			List<MessagesDTO> list = new ArrayList<>();
		
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				
				list.add(new MessagesDTO(seq, writer, message));
			}
			
			return list;
		}
	}
	
	
	/**
	 * 메세지 삭제
	 * @param seq
	 * @return
	 * @throws Exception
	 */
	public int delete(int seq) throws Exception {
		String sql = "delete from messages where seq = ?";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setInt(1, seq);
			
			return pstat.executeUpdate();
		}
	}
	
	
	/**
	 * 메세지 수정
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int update(MessagesDTO dto) throws Exception {
		String sql = "update messages set writer = ?, message = ? where seq = ?";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			pstat.setInt(3, dto.getSeq());
			
			return pstat.executeUpdate();
		}
	}
	
}
