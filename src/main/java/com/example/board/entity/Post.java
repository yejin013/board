package com.example.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @SequenceGenerator(name="seq", sequenceName="jpa_sequence")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    private User user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
