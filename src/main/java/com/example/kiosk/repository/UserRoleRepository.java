package com.example.kiosk.repository;

import com.example.kiosk.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Byte> {
}
