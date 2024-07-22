package com.kedu.springboot_01.dao;

import com.kedu.springboot_01.dto.MusicDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MusicDAO {

    @Autowired
    private SqlSession mybatis;

    public void insert(MusicDTO dto) {
        mybatis.insert("Music.insert", dto);
    }

}
