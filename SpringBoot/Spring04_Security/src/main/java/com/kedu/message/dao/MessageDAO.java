package com.kedu.message.dao;

import com.kedu.message.dto.MessageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDAO {

    @Autowired
    private SqlSession mybatis;

    public List<MessageDTO> getMessages() {
        return mybatis.selectList("Message.getMessages");
    }

    public int delMessage(int seq) {
        return mybatis.delete("Message.delMessage", seq);
    }
}
