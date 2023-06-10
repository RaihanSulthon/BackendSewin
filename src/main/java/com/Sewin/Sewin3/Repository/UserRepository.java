package com.Sewin.Sewin3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sewin.Sewin3.Model.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long> {
    user findByEmail(String email);
}
