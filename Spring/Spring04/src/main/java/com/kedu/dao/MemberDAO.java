package com.kedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	public int insert() throws Exception {
		return jdbc.update("insert into member values('X','Y','Z')");
	}
}
