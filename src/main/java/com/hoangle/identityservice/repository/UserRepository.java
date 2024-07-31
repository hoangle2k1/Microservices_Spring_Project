package com.hoangle.identityservice.repository;


import com.hoangle.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String userName);

    //Câu hỏi: Tại sao phải để là Optional thì mới dùng orElseThrow được
    Optional<User> findByUsername(String userName);
}
