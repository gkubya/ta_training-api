package com.epam.training.student_gregory_kubya.service;

import static com.epam.training.student_gregory_kubya.configuration.RequestSpecificationConfig.getRequestSpecification;
import static io.restassured.RestAssured.given;

import com.epam.training.student_gregory_kubya.UserDTO;
import io.restassured.response.Response;

public class UsersService {

  public Response createUser(UserDTO user) {
    return given(getRequestSpecification()).
        body(user).
        when().post();
  }

  public Response readUser(String userToCheck) {
    return given(getRequestSpecification()).when().get(userToCheck);
  }

  public Response updateUser(UserDTO user, String userToUpdate) {
    return given(getRequestSpecification()).
        body(user)
        .when().put(userToUpdate);
  }

  public Response deleteUser(String userToDelete) {
    return
        given(getRequestSpecification()).delete(userToDelete);
  }
}
