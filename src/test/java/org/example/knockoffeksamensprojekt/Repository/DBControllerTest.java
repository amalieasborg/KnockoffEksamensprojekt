package org.example.knockoffeksamensprojekt.Repository;

import org.example.knockoffeksamensprojekt.Model.MyUser;
import org.example.knockoffeksamensprojekt.Repository.DBController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// This annotation tells JUnit to use Mockito extension for running the tests
@ExtendWith(MockitoExtension.class)
class DBControllerTest {

    // Mocking the JdbcTemplate dependency
    @Mock
    private JdbcTemplate jdbcTemplate;

    // Creating an instance of the Repository class and injecting the mocked JdbcTemplate
    @InjectMocks
    private DBController dbController;

    // Test method to verify the behavior when a user exists in the database
    @Test
    void testFindUserByEmail_UserExists() {
        // Arrange
        // Mocking email and an example user object with the same email
        String email = "test@example.com";
        MyUser expectedUser = new MyUser();
        expectedUser.setEmail(email);
        // Mocking the behavior of the jdbcTemplate.queryForObject() method to return the expected user
        when(jdbcTemplate.queryForObject(any(String.class), any(Object[].class), any(RowMapper.class)))
                .thenReturn(expectedUser);

        // Act
        // Calling the method under test
        Optional<MyUser> actualUser = dbController.findUserByEmail(email);

        // Assert
        // Verifying that the actual user returned by the method is the same as the expected user
        assertEquals(Optional.of(expectedUser), actualUser);
    }

    // Test method to verify the behavior when a user does not exist in the database
    @Test
    void testFindUserByEmail_UserDoesNotExist() {
        // Arrange
        // Mocking a nonexistent email
        String email = "nonexistent@example.com";
        // Mocking the behavior of the jdbcTemplate.queryForObject() method to throw an EmptyResultDataAccessException
        when(jdbcTemplate.queryForObject(any(String.class), any(Object[].class), any(RowMapper.class)))
                .thenThrow(EmptyResultDataAccessException.class);

        // Act
        // Calling the method under test
        Optional<MyUser> actualUser = dbController.findUserByEmail(email);

        // Assert
        // Verifying that the actual user returned by the method is an empty Optional
        assertEquals(Optional.empty(), actualUser);
    }
}