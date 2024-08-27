package com.codewithck.blog.BlogApplication.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private int statusCode;

    // Static method to create ApiResponse directly
    public static ApiResponse createDeleteResponse(String resourceName, Integer resourceId) {
        String message = String.format("%s with ID %d was successfully deleted.", resourceName, resourceId);
        return new ApiResponse(message, true, HttpStatus.OK.value());
    }
}
