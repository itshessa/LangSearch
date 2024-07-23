package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories("entityManagerFactory")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
