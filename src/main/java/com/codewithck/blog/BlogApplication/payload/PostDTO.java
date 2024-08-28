package com.codewithck.blog.BlogApplication.payload;

import com.codewithck.blog.BlogApplication.entities.Category;
import com.codewithck.blog.BlogApplication.entities.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private String title;
    private String content;
    private String imageName;
    private Date addDate;
    //important if not infinite recursion will have when you are trying to create a post
    //because we call list of posts in category and user
    private CategoryDTO category;
    private UserDTO user;
}
