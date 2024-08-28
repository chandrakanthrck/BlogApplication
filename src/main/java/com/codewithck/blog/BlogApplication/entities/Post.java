package com.codewithck.blog.BlogApplication.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    @Column(name="post_title", length = 100, nullable = false)
    private String title;
    @Column(length = 1000)
    private String content;
    private String imageName;
    private Date addDate;
    //many posts for one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    //many posts by one user
    //author of the post
    @ManyToOne
    private User user;
}