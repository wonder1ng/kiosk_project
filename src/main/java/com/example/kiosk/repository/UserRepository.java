package com.example.kiosk.repository;

import com.example.kiosk.dto.UserDto;
import com.example.kiosk.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsBySignId(String signId);
    Optional<UserEntity> findBySignId(String signId);
}