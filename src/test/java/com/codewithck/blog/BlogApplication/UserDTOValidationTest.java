package com.codewithck.blog.BlogApplication;

import com.codewithck.blog.BlogApplication.payload.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserDTOValidationTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInvalidEmail() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("Test User");
        userDTO.setEmail(""); // Invalid email
        userDTO.setPassword("password");
        userDTO.setAbout("About the user");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        assertEquals(1, violations.size());
        ConstraintViolation<UserDTO> violation = violations.iterator().next();
        assertEquals("Email cannot be empty", violation.getMessage());
    }

    @Test
    public void testInvalidName() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName(""); // Invalid name
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("password");
        userDTO.setAbout("About the user");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        assertEquals(1, violations.size());
        ConstraintViolation<UserDTO> violation = violations.iterator().next();
        assertEquals("Name cannot be empty", violation.getMessage());
    }

    @Test
    public void testInvalidPassword() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("Test User");
        userDTO.setEmail("test@example.com");
        userDTO.setPassword(""); // Invalid password
        userDTO.setAbout("About the user");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        assertEquals(1, violations.size());
        ConstraintViolation<UserDTO> violation = violations.iterator().next();
        assertEquals("Password cannot be empty", violation.getMessage());
    }

    @Test
    public void testValidUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Test User");
        userDTO.setEmail("test@example.com"); // Valid email
        userDTO.setPassword("password");
        userDTO.setAbout("About the user");

        Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

        assertEquals(0, violations.size()); // No violations should be found
    }
}
