package com.example.board.controller;

import com.example.board.entity.Post;
import com.example.board.entity.User;
import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/blog")
@RequiredArgsConstructor
@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post insertPost(Post post) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return postService.insertPost(user, post);
    }

    @GetMapping
    public List<Post> getPostList() throws Exception {
        List<Post> postList = postService.getPost();

        return postList;
    }

    @GetMapping(value = "/{id}")
    public Post getPostDetail(@PathVariable("id") Long post_id) throws Exception{
        Post post = postService.getPostDetail(post_id);

        return post;
    }

    @PutMapping(value = "{id}")
    public Post updatePost(@PathVariable("id") Long post_id, Post post) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Post result = null;
        if (user.getUserId().equals(postService.getPostDetail(post_id).getUser().getUserId())) {
            postService.updatePost(post_id, post);
            result = postService.getPostDetail(post_id);
        } else {
            throw new Exception("Author Mismatch");
        }
        return result;
    }

    @DeleteMapping(value = "{id}")
    public void deletePost(@PathVariable("id") Long post_id) throws Exception {
        postService.deletePost(post_id);
    }
}
