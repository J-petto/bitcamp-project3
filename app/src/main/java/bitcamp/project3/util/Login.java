package bitcamp.project3.util;

import bitcamp.project3.vo.User;

import java.io.*;

public class Login {
  public static User loginUser() {
    System.out.println("* 로그인 *");
    int count = 0;
    User user = null;
    while (true) {
      String userID = Prompt.input("ID를 입력하세요: ");
      String userPassword = Prompt.input("비밀번호를 입력하세요: ");

      if (count > 2) {
        break;
      } else {
        user = loadUser(userID);
        if (user == null) {
          System.out.println("유효하지 않은 ID 입니다.");
          count++;
        } else if (!(user.getUserPassword().equals(userPassword))) {
          System.out.println("유효하지 않은 비밀번호 입니다.");
        } else {
          System.out.println("로그인 성공 !");
          System.out.printf("%s님 접속하셨습니다.\n", user.getUserName());
          break;
        }
      }
    }
    return user;
  }

  public static void authUser() {
    System.out.println("* 회원가입 *");
    while (true) {
      String userID = Prompt.input("ID로 사용하실 이메일을 입력하세요: ");
      User user = loadUser(userID);
      if (!(user == null)) {
        System.out.println("중복된 이메일 입니다.");
      } else {
        String userPassword = Prompt.input("비밀번호를 입력하세요: ");
        user = new User(userID, userPassword);
        user.setUserName(Prompt.input("사용자의 이름을 입력하세요: "));
        user.setUserHint(Prompt.input("해당 질문은 비밀번호 찾기를 위한 암호입니다.\n" +
            "당신이 가장 좋아하는 책의 이름은 무엇인가요?"));
        saveUser(user);
        System.out.printf("%s님 환영합니다.\n", user.getUserName());
        break;
      }
    }
  }

  public static void reSetUserPassword() {
    System.out.println("* 비밀번호 재설정 *");
    while (true) {
      String userID = Prompt.input("ID를 입력하세요: ");
      User user = loadUser(userID);
      if (user == null) {
        System.out.println("존재하지 않는 ID 입니다.");
      } else {
        String reSetHint = Prompt.input("당신이 가장 좋아하는 책의 이름은 무엇인가여?");
        if(reSetHint.equals(user.getUserHint())) {
          user.setUserPassword(Prompt.input("새 비밀번호를 입력하세요: "));
          saveUser(user);
          System.out.printf("비밀번호를 재설정 했습니다.\n");
          break;
        } else {
          System.out.printf("유효하지 않은 암호입니다.\n");
          break;
        }
      }
    }
  }

//  private static void saveUser(User user) {
//    String datName = user.getUserID();
//    try (FileOutputStream fos = new FileOutputStream(
//        "/home/kei/git/bitcamp-project3/database/user/" + datName + ".dat");
//        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//      oos.writeObject(user);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

  // 유저 홈을 받아와 유동적으로 연결
  private static void saveUser(User user) {
    String datName = user.getUserID();
    String userHome = System.getProperty("user.home");
    try (FileOutputStream fos = new FileOutputStream(
            userHome + "/git/bitcamp-project3/database/user/" + datName + ".dat");
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(user);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

//  private static User loadUser(String userID) {
//    try (FileInputStream fis = new FileInputStream(
//        "/home/kei/git/bitcamp-project3/database/user/" + userID + ".dat");
//        ObjectInputStream ois = new ObjectInputStream(fis)) {
//      return (User) ois.readObject();
//    } catch (IOException | ClassNotFoundException e) {
//      return null;
//    }
//  }

  // UserHome을 받아와 유동적 처리
  private static User loadUser(String userID) {
    String userHome = System.getProperty("user.home");
    try (FileInputStream fis = new FileInputStream(
            userHome + "/git/bitcamp-project3/database/user/" + userID + ".dat");
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      return (User) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      return null;
    }
  }

}
