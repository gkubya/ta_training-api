package com.epam.training.student_gregory_kubya.tests;

import static com.epam.training.student_gregory_kubya.TestDataUtils.createUserDTO;
import static com.epam.training.student_gregory_kubya.service.UserService.parseJsonToUserDTO;

import com.epam.training.student_gregory_kubya.UserDTO;
import com.epam.training.student_gregory_kubya.service.UserService;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTests {

  private static UserDTO testUser;
  private static UserDTO userUpdated;

  @BeforeAll
  static void setTestUser() {
    testUser = createUserDTO();

    userUpdated = UserDTO.builder().
        id(testUser.getId()).
        username(testUser.getUsername()).
        firstName(testUser.getFirstName()).
        lastName(testUser.getLastName()).
        email("ahuntoo@mail.com").
        password("98765").
        build();
  }

  @Order(1)
  @Test
  void createUserTest() {
    Response createUser = new UserService().createUser(testUser);

    Assertions.assertThat(parseJsonToUserDTO(createUser)).
        as("Tried to create user but was not successful").
        isEqualTo(testUser);
  }

  @Order(2)
  @Test
  void readUserTest() {
    Response readTestUser = new UserService().readUser(testUser.getUsername());

    Assertions.assertThat(parseJsonToUserDTO(readTestUser)).
        as("Tried to confirm data on created user but found divergences").
        isEqualTo(testUser);
  }

  @Order(3)
  @Test
  void updateUserTest() {
    Response updateTestUser = new UserService().updateUser(userUpdated);

    Assertions.assertThat(parseJsonToUserDTO(updateTestUser)).
        as("Tried to update user data but was not successful").
        isEqualTo(userUpdated);
  }

  @Order(4)
  @Test
  void deleteUserTest() {
    Response deleteTestUser = new UserService().deleteUser(testUser.getUsername());
    Assertions.assertThat(deleteTestUser.getStatusCode()).
        as("Tried to delete user but was not successful").
        isEqualTo(200);
  }
}
