package bitcamp.project3.util;

import bitcamp.project3.vo.User;

import java.io.*;

public class Login {
  public static User loginUser() {
    int count = 0;
    User user = null;
    while (true) {
      String userID = Prompt.input("ID를 입력하세요: ");
      String userPassword = Prompt.input("비밀번호를 입력하세요: ");

      if (count >= 3) {
        break;
      } else {
        user = loadUser(userID);
        if (user == null) {
          System.out.println("유효하지 않은 ID 입니다.");
          count++;
        } else if (!(user.getUserPassword().equals(userPassword))) {
          System.out.println("유효하지 않은 비밀번호 입니다.");
        } else {
          System.out.println("* 로그인 성공 *");
          System.out.printf("%s님 접속하셨습니다.\n", userID);
          break;
        }
      }
    }
    return user;
  }

  public static void authUser() {
    System.out.println("* 회원가입 *");
    String userID = Prompt.input("ID로 사용하실 이메일을 입력하세요: ");
    String userPassword = Prompt.input("비밀번호를 입력하세요: ");
    User user = new User(userID, userPassword);
    saveUser(user);
    System.out.printf("%s님 환영합니다.\n", user.getUserID());
  }

  private static void saveUser(User user) {
    String datName = user.getUserID();
    try (FileOutputStream fos = new FileOutputStream("/home/kei/git/bitcamp-project3/database/user/"+datName+".dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(user);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static User loadUser(String userID) {
    try (FileInputStream fis = new FileInputStream("/home/kei/git/bitcamp-project3/database/user/"+userID+".dat");
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      return (User) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      return null;
    }
  }

}
