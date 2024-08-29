package com.codewithck.blog.BlogApplication.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private List<PostDTO> content;
    private int pageNumber;
    private long pageSize;
    private int totalElements;
    private int totalPages;
    private boolean lastPage;
}
