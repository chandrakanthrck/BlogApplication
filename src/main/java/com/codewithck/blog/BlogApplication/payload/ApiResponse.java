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

    // Constructor without statusCode, to be used when only message and success are provided
    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.statusCode = HttpStatus.OK.value(); // Defaulting statusCode to 200 OK
    }

    // Static method to create ApiResponse directly
    public static ApiResponse createDeleteResponse(String resourceName, Integer resourceId) {
        String message = String.format("%s with ID %d was successfully deleted.", resourceName, resourceId);
        return new ApiResponse(message, true, HttpStatus.OK.value());
    }
}
