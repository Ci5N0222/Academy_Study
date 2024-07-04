package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private BasicDataSource bds;
	
	public List<BoardDTO> getList() throws Exception {
		String sql = "select * from board";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery()){
			
			List<BoardDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp write_date = rs.getTimestamp("write_date");
				
				list.add(new BoardDTO(seq, writer, title, content, write_date));
			}
			
			return list;
		}
	}
	
	public int insert(String writer, String title, String content) throws Exception {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate)";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, writer);
			pstat.setString(2, title);
			pstat.setString(3, content);
			
			return pstat.executeUpdate();
		}
		
	}
	
}
