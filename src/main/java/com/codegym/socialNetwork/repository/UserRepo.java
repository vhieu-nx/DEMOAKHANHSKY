package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
    @Query (value = "select * from app_user join friend on app_user.id=friend.to_id where friend.from_id=?;",nativeQuery = true)
    List<AppUser> getListFriend(Long id);
}
