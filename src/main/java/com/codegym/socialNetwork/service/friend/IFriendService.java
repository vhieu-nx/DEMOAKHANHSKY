package com.codegym.socialNetwork.service.friend;

import com.codegym.socialNetwork.model.AppUser;
import com.codegym.socialNetwork.model.Friend;
import com.codegym.socialNetwork.service.IService;

import java.util.List;

public interface IFriendService extends IService<Friend> {
    List<AppUser> getListFriend(Long id);
}
