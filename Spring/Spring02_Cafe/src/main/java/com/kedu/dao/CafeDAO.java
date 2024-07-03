package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.CafeDTO;

@Repository
public class CafeDAO {

	@Autowired
	private BasicDataSource bds;
	
	public int addMenu(CafeDTO dto) throws Exception {
		
		String sql = "insert into cafe values(cafe_seq.nextval, ?, ?)";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getMenu());
			pstat.setInt(2, dto.getPrice());
			
			return pstat.executeUpdate();
		}
	}
}
