package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MessagesDTO;

@Repository
public class MessagesDAO {
	
	@Autowired
	private BasicDataSource bds;
	
	public int insert(MessagesDTO dto) throws Exception {
		String sql = "insert into messages values(messages_seq.nextval, ?, ?)";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			
			return pstat.executeUpdate();
		}
	}
}
