package com.example.board.service;

import com.example.board.dto.PostDto;
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
    public Post insertPost(User user, PostDto postDto) throws Exception{
        Post post = new Post(postDto.getTitle(), postDto.getContent(), user, LocalDateTime.now(), LocalDateTime.now());
        return postRepo.save(post);
    }

    public List<Post> getPost() throws Exception{
        return postRepo.findAll();
    }

    public Post getPostDetail(Long id) throws Exception {
        return postRepo.findById(id).orElseGet(() -> null);
    }

    public void updatePost(Long id, PostDto postDto) throws Exception {
        Post post = postRepo.findById(id).orElseGet(() -> null);
        if(post == null) {
            throw new Exception("No Post");
        } else {
            post.setUpdate(postDto.getTitle(), postDto.getContent());
        }
    }

    public void deletePost(Long id) throws Exception {
        Post post = postRepo.findById(id).orElse(null);
        if (post != null)
            postRepo.delete(post);
        else
            throw new Exception("No Post");
    }
}
