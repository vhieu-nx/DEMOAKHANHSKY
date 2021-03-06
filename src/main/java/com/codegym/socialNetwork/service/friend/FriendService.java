package com.codegym.socialNetwork.service.friend;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Friend;
import com.codegym.socialNetwork.repository.FriendRepo;
import com.codegym.socialNetwork.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendService implements IFriendService {

    @Autowired
    private FriendRepo friendRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public Iterable<Friend> findAll() {
        return friendRepo.findAll();
    }

    @Override
    public Optional<Friend> findById(Long id) {
        return friendRepo.findById(id);
    }

    @Override
    public void save(Friend friend) {
        friendRepo.save(friend);
    }

    @Override
    public void remove(Long id) {
        friendRepo.deleteById(id);
    }

    @Override
    public List<AppUser> getListFriend(Long id){
        return userRepo.getListFriend(id);

    }
}
