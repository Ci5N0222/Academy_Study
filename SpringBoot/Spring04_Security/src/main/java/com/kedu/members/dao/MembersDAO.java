package com.kedu.members.dao;

import com.kedu.members.dto.MembersDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembersDAO {

    @Autowired
    private SqlSession mybatis;

    public boolean isMembers(MembersDTO dto) {
        return mybatis.selectOne("Members.isMembers", dto);
    }

    public MembersDTO getMember(String id) {
        return mybatis.selectOne("Members.getMember", id);
    }

}
