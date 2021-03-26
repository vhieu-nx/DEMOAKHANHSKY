package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    List<AppUser> findAllByIdIsNotLike(int id);
}
