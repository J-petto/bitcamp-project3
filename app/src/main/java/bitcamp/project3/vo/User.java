package bitcamp.project3.vo;

import java.io.Serializable;

public class User implements Serializable {
  private static int seqUserId;
  private String userID;
  private String userPassword;
  private String userName;
  private String userHint;
  private boolean isBlack;

  public static int getSeqUserId() {
    return ++seqUserId;
  }

  public User(String userID, String userPassword) {
    getSeqUserId();
    this.isBlack=false;
    this.userID = userID;
    this.userPassword = userPassword;
  }

  public String getUserID() {
    return userID;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserHint() {
    return userHint;
  }

  public void setUserHint(String userHint) {
    this.userHint = userHint;
  }

  public boolean isBlack() {
    return isBlack;
  }

  public void setBlack(boolean black) {
    isBlack = black;
  }

}
