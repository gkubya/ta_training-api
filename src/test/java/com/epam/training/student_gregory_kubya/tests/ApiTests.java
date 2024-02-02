package com.epam.training.student_gregory_kubya.tests;

import com.epam.training.student_gregory_kubya.UserDTO;
import com.epam.training.student_gregory_kubya.service.UsersService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiTests {

  @Test
  void createUserTest() {
    UserDTO user = UserDTO.builder().
        id(12).
        username("adam").
        firstName("Adam").
        lastName("Hunt").
        email("ahunt@mail.com").
        password("12321").
        phone("12322323").
        build();
    Response response = new UsersService().createUser(user);
    Assertions.assertEquals(500, response.getStatusCode());

  }

  @Test
  void readUserTest() {
    String userToCheck = "/adam";
    Response response = new UsersService().readUser(userToCheck);

    Assertions.assertEquals
        ("aramu", response.jsonPath().getString("username"));
  }

  @Test
  void updateUserTest() {
    UserDTO user = UserDTO.builder().
        id(12).
        username("adam").
        firstName("Adam").
        lastName("Hunt").
        email("ahuntoo@mail.com").
        password("98765").
        build();
    String userToUpdate = "/adam";
    Response response = new UsersService().updateUser(user, userToUpdate);
    Assertions.assertEquals(500, response.getStatusCode());
  }

  @Test
  void deleteUserTest() {
    String userToDelete = "/adam";
    Response response = new UsersService().deleteUser(userToDelete);
    Assertions.assertEquals(500, response.getStatusCode());
  }
}
