package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.FriendRequest;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FriendRequestRepo extends JpaRepository <FriendRequest, Long>  {

}
