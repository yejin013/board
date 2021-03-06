package com.example.board.service;

import com.example.board.entity.Post;
import com.example.board.entity.User;
import com.example.board.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Transactional
    public Post insertPost(User user, Post post) throws Exception{
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return postRepo.save(post);
    }

    public List<Post> getPost() throws Exception{
        return postRepo.findAll();
    }

    public Post getPostDetail(Long id) throws Exception {
        return postRepo.findById(id).orElseGet(() -> null);
    }

    public void updatePost(Long id, Post param) throws Exception {
        Optional<Post> post = postRepo.findById(id);
        post.ifPresent(entity -> {
            entity.setTitle(param.getTitle());
            entity.setContent(param.getContent());
            entity.setUser(post.get().getUser());
            entity.setCreatedAt(post.get().getCreatedAt());
            entity.setUpdatedAt(LocalDateTime.now());
            postRepo.save(entity);
        });
    }

    public void deletePost(Long id) throws Exception {
        Object post = postRepo.findById(id).orElse(null);
        if (post != null)
            postRepo.delete((Post) post);
        else
            throw new Exception("No Post");
    }
}
