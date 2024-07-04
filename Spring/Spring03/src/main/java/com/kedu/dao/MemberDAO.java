package com.kedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kedu.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private BasicDataSource bds;
	
	public int login(MemberDTO dto) throws Exception {
		String sql = "select id, pw from member where id = ?";
				
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getId());
			
			try(ResultSet rs = pstat.executeQuery()){
				if(rs.next()) {
					if(rs.getString("pw").equals(dto.getPw())) {
						return 1;
					} else {
						return 2;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return 3;
		}
	}
	
	public boolean idcheck(String id) throws Exception {
		String sql = "select id from member where id = ?";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			
			try(ResultSet rs = pstat.executeQuery()){
				return rs.next();
			}
		}
	}
	
	public int joinProc(MemberDTO dto) throws Exception {
		String sql = "insert into member values(?, ?, ?)";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			
			return pstat.executeUpdate();
		}
	}
	
	public int memberDelete(String id) throws Exception {
		String sql = "delete from member where id = ?";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			
			return pstat.executeUpdate();
		}
	}
	
	public MemberDTO memberInfo(String id) throws Exception {
		String sql = "select * from member where id = ?";

		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			
			try(ResultSet rs = pstat.executeQuery()){
				
				if(rs.next()) {
					String name = rs.getString("name");	
					return new MemberDTO(id, null, name);
				} else {
					return null;
				}
			}
		}
	}
	
	
	public int update(String id, String name) throws Exception {
		String sql = "update member set name = ? where id = ?";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, name);
			pstat.setString(2, id);
			
			return pstat.executeUpdate();
		}
	}
	
}
