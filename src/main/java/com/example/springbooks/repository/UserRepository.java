package com.example.springbooks.repository;
import com.example.springbooks.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    Optional findByName(String name);
 }
