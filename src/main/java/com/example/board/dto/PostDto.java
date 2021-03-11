package com.example.board.dto;

import com.example.board.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private String title;
    private String content;
}
