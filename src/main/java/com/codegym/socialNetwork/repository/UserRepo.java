package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
