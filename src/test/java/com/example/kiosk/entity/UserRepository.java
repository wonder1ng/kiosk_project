package com.example.kiosk.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
    //기본 메소드
    //findAll, count, save, delete

    //사용자정의 메소드(JPA함수, JPQL, NativeQuery)
    Optional<UserEntity> findByLoginId(String loginId);
    Optional<UserEntity> findByLoginIdAndUserpassword(String loginId, String password);

}