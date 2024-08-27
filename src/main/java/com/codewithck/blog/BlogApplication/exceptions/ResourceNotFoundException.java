package com.codewithck.blog.BlogApplication.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    long fieldValue;
    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue){
        //If you didn't use super, you would have to manually handle the message storage and retrieval,
        // which is redundant and error-prone since RuntimeException (through Throwable)
        // already provides these capabilities.
        super(String.format("%s not found with %s: %l", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
