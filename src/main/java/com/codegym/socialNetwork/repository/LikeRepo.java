package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<Like, Long> {
}
