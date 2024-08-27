package com.codewithck.blog.BlogApplication.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Integer categoryId;

    @NotBlank(message = "Category title cannot be blank")
    @Size(min = 3, max = 50, message = "Category title must be between 3 and 50 characters")
    private String categoryTitle;

    @NotBlank(message = "Category description cannot be blank")
    @Size(min = 10, max = 200, message = "Category description must be between 10 and 200 characters")
    private String categoryDescription;
}
