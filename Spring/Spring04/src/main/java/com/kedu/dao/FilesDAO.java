package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class FilesDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	/** 파일 업로드 **/
	public int insert(String oriName, String sysName, int parentSeq) throws Exception {
		String sql = "insert into files values(files_seq.nextval, ?, ?, ?)";
		
		KeyHolder key = new GeneratedKeyHolder();
		
		/* 자바에서 사용하는 콜백 형식 메서드 */
		jdbc.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"seq"});
				ps.setString(1, oriName);
				ps.setString(2, sysName);
				ps.setInt(3, parentSeq);
				return ps;
			}
		}, key);
		int seq = key.getKey().intValue();
		System.out.println("seq ==== " + seq);
		return seq;
	}
	
	/** 파일 목록 **/
	
	/** 다일 다운로드 **/
}
