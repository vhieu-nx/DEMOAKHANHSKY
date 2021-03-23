package com.codegym.socialNetwork.service.like;

import com.codegym.socialNetwork.model.Like;
import com.codegym.socialNetwork.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LikeService implements ILikeService {

    @Autowired
    private LikeRepo likeRepo;

    @Override
    public Iterable<Like> findAll() {
        return likeRepo.findAll();
    }

    @Override
    public Optional<Like> findById(Long id) {
        return likeRepo.findById(id);
    }

    @Override
    public void save(Like like) {
        likeRepo.save(like);
    }

    @Override
    public void remove(Long id) {
        likeRepo.deleteById(id);
    }
}
