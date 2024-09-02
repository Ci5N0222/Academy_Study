package com.kedu.dao;

import com.kedu.dto.MembersDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDAO {

    @Autowired
    private SqlSession mybatis;

    public MembersDTO login(MembersDTO dto) {
        return mybatis.selectOne("Members.login", dto);
    }

    public MembersDTO getMembers(String id) {
        System.out.println("dao id ===== "+ id);
        return mybatis.selectOne("Members.getMembers", id);
    }

}
