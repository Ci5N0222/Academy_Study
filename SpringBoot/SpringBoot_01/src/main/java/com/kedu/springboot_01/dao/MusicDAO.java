package com.kedu.springboot_01.dao;

import com.kedu.springboot_01.dto.MusicDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicDAO {

    @Autowired
    private SqlSession mybatis;

    public void insert(MusicDTO dto) {
        mybatis.insert("Music.insert", dto);
    }

    public List<MusicDTO> getAllData(){
        return mybatis.selectList("Music.list");
    }

    public void delete(int id){
        mybatis.delete("Music.delete", id);
    }

    public void update(MusicDTO dto){
        mybatis.update("Music.update", dto);
    }

}
