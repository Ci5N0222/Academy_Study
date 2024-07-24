package com.kedu.springboot_01.dao;

import com.kedu.springboot_01.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private SqlSession mybatis;

    public void insert(MemberDTO dto) {
        mybatis.insert("Member.insert", dto);
    }

    public Boolean signIn(MemberDTO dto) {
        return mybatis.selectOne("Member.signin", dto);
    }

    public MemberDTO auth(MemberDTO dto) {
        return mybatis.selectOne("Member.info", dto);
    }

    public MemberDTO mypage(String id) {
        return mybatis.selectOne("Member.mypage", id);
    }
    public void delete(String id) {
        mybatis.delete("Member.delete", id);
    }

}
