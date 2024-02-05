package com.epam.training.student_gregory_kubya;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

  int id;
  String username;
  String firstName;
  String lastName;
  String email;
  String password;
  String phone;
  int userStatus;


}
