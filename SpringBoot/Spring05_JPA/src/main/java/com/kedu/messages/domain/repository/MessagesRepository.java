package com.kedu.messages.domain.repository;


import com.kedu.messages.domain.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Spring Data JPA는 스스로 DAO 관련된 기능들을 구현하는데 이때 필요한 정보를 JpaRepository에 Generic 에 제공함

public interface MessagesRepository extends JpaRepository<Messages, Long> {
    //JpaRepository
    // 1번째 인자 : Entity
    // 2번째 인자 :  Entity Type, Entity의 Primary key 타입

    List<Messages> findByWriter(String writer);

    /**
     *  JpaRepository는 메서드의 이름이 쿼리를 만들어 낸다. (임의로 짓는 메서드 이름을 지어선 안됨)
     *  findBy로 시작하여야 한다.
     *  뒤쪽엔 컬럼명이 들어와야 한다.
     *
     *  컬러명 / and, or / GreaterThan / LessThan / Containing
     */

}
