package bitcamp.project3.vo;

import java.io.Serializable;

public class User implements Serializable {
  private String userID;
  private String userPassword;
  private String userName;

  public User(String userID, String userPassword) {
    this.userID=userID;
    this.userPassword=userPassword;
  }

  public String getUserID() {
    return userID;
  }

  public String getUserPassword() {
    return userPassword;
  }
}
