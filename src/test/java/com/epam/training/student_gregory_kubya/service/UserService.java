package com.epam.training.student_gregory_kubya.service;

import static com.epam.training.student_gregory_kubya.configuration.RequestSpecificationConfig.getRequestSpecification;
import static io.restassured.RestAssured.given;

import com.epam.training.student_gregory_kubya.UserDTO;
import io.restassured.response.Response;

public class UserService {

  public Response createUser(UserDTO user) {
    return given(getRequestSpecification()).
        body(user).post();
  }

  public Response readUser(UserDTO user) {
    return given(getRequestSpecification()).
        pathParam("username", user.getUsername()).
        get("{username}");
  }

  public Response updateUser(UserDTO user) {
    return given(getRequestSpecification()).
        body(user).
        pathParam("username", user.getUsername()).
        put("{username}");
  }

  public Response deleteUser(UserDTO user) {
    return given(getRequestSpecification()).
        pathParam("username", user.getUsername()).
        delete("{username}");
  }

  public static UserDTO parseJsonToUserDTO(Response response) {
    return response.as(UserDTO.class);
  }
}
