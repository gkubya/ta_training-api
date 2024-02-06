package com.epam.training.student_gregory_kubya.tests;

import static com.epam.training.student_gregory_kubya.TestDataUtils.createUserDTO;
import static com.epam.training.student_gregory_kubya.service.UserService.parseJsonToUserDTO;

import com.epam.training.student_gregory_kubya.UserDTO;
import com.epam.training.student_gregory_kubya.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTests {

  static UserDTO testUser = createUserDTO();
  static UserDTO userUpdated = testUser.toBuilder().
      email("ahuntoo@mail.com").
      password("98765").
      build();
  private final UserService userService = new UserService();


  @Order(1)
  @Test
  void createUserTest() {

    Assertions.assertThat(parseJsonToUserDTO(userService.createUser(testUser))).
        as("Tried to create new user on the API").
        isEqualTo(testUser);
  }

  @Order(2)
  @Test
  void readUserTest() {

    Assertions.assertThat(parseJsonToUserDTO(userService.readUser(testUser))).
        as("Tried to confirm data on created user").
        isEqualTo(testUser);
  }

  @Order(3)
  @Test
  void updateUserTest() {

    Assertions.assertThat(parseJsonToUserDTO(userService.updateUser(userUpdated))).
        as("Tried to update data of the created user").
        isEqualTo(userUpdated);
  }

  @Order(4)
  @Test
  void deleteUserTest() {

    Assertions.assertThat(userService.deleteUser(testUser).getStatusCode()).
        as("Tried to delete the created user").
        isEqualTo(200);
  }
}
