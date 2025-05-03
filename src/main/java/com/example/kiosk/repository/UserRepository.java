package com.example.kiosk.repository;

import com.example.kiosk.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsBySignId(String signId);
    Optional<UserEntity> findBySignId(String signId);
}