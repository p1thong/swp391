package com.p1thong.springsecurity.repository;

import com.p1thong.springsecurity.entity.Role;
import com.p1thong.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
