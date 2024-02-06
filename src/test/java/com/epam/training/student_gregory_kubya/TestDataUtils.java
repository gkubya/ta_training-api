package com.epam.training.student_gregory_kubya;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class TestDataUtils {

  public static String getRandomString(int length) {
    return randomAlphabetic(length);
  }

  public static String getRandomAlphanumeric(int length) {
    return randomAlphanumeric(length);
  }

  public static String getRandomInteger(int length) {
    return randomNumeric(length);
  }

  public static String createEmail(String firstName, String lastName) {
    return firstName + "_" + lastName + "@contoso.com";
  }

  public static UserDTO createUserDTO() {
    String firstName = getRandomString(5);
    String lastName = getRandomString(5);

    return UserDTO.builder().
        id(Integer.parseInt(getRandomInteger(2))).
        username(getRandomString(5)).
        firstName(firstName).
        lastName(lastName).
        email(createEmail(firstName, lastName)).
        password(getRandomAlphanumeric(10)).
        phone(getRandomInteger(8)).
        build();
  }

}
