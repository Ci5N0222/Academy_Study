package com.kedu.messages.domain.repository;


import com.kedu.messages.domain.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA는 스스로 DAO 관련된 기능들을 구현하는데 이때 필요한 정보를 JpaRepository에 Generic 에 제공함

public interface MessagesRepository extends JpaRepository<Messages, Long> {
    //JpaRepository
    // 1번째 인자 : Entity
    // 2번째 인자 :  Entity Type, Entity의 Primary key 타입
}
