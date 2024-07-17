package bitcamp.project3.vo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TakeOutManager implements Serializable {
  private final int MAX_LIMIT = 3;
  private Map<String, List<TakeOutRecord>> userTakes;

  public TakeOutManager() {
    this.userTakes = new HashMap<>();
  }

  public void saveTakes(User user) {
    String userHome = System.getProperty("user.home");
    String userID = user.getUserID();
    String filePath = userHome + "/git/bitcamp-project3/database/taken/" + userID + "_takeout.dat";
    try (FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(this.userTakes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void updateUserTakes(String userID, List<TakeOutRecord> updatedValues) {
    this.userTakes.put(userID, updatedValues);
  }

  public Map<String, List<TakeOutRecord>> loadTakes(User user) {
    String userHome = System.getProperty("user.home");
    String userID = user.getUserID();
    String filePath = userHome + "/git/bitcamp-project3/database/taken/" + userID + "_takeout.dat";
    try (FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      return (Map<String, List<TakeOutRecord>>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      //      System.out.println("로그 : 데이터 로딩 X ");
      return new HashMap<>();
    }
  }

  public void takeOut(User user, Book book) {
    String ansiRed = "\u001B[31m";
    String ansiEnd = "\u001B[0m";
    userTakes = loadTakes(user);
    List<TakeOutRecord> records = userTakes.getOrDefault(user.getUserID(), new ArrayList<>());
    if (records.size() > MAX_LIMIT - 1) {
      System.out.println("대출 한도를 초과했습니다.");
    } else if (user.isBlack()) {
      System.out.println(ansiRed + "현재 도서가 연체중입니다. 먼저 책을 반납해주세요~" + ansiEnd);
    } else {
      records.add(new TakeOutRecord(book));
      userTakes.put(user.getUserID(), records);
      if (book.getMainCategory().equals("미디어")) {
        System.out.println(book.getBookTitle() + " CD 을(를) 대여했습니다.");
      } else {
        System.out.println("도서 " + book.getBookTitle() + " 을(를) 대출했습니다.");
      }
      saveTakes(user);
    }
  }

  public void isOverdue(User user, Map<String, List<TakeOutRecord>> userTakes) {
    userTakes = loadTakes(user);
    if (userTakes.containsKey(user.getUserID())) {
      List<TakeOutRecord> values = userTakes.get(user.getUserID());
      for (TakeOutRecord value : values) {
        LocalDate loneDate = value.getTakesOutDate().plusDays(14);
        LocalDate today = LocalDate.now();
        String isOverdue;
        if (loneDate.isBefore(today)) {
          user.setBlack(true);
          break;
        } else {
          //          isOverdue = String.valueOf(loneDate);
          user.setBlack(false);
        }
      }
    }
  }

}
