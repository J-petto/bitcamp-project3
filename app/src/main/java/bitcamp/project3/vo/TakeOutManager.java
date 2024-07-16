package bitcamp.project3.vo;

import java.io.*;
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

  private void saveTakes(User user) {
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

  public Map<String, List<TakeOutRecord>> loadTakes(User user) {
    String userHome = System.getProperty("user.home");
    String userID = user.getUserID();
    String filePath = userHome + "/git/bitcamp-project3/database/taken/" + userID + "_takeout.dat";
    try (FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      return (Map<String, List<TakeOutRecord>>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("로그 : 데이터 로딩 X ");
      return new HashMap<>();
    }
  }

  public void takeOut(User user, Book book) {
    userTakes=loadTakes(user);
    List<TakeOutRecord> records = userTakes.getOrDefault(user.getUserID(), new ArrayList<>());
    if (records.size() > MAX_LIMIT-1) {
      System.out.println("대출 한도를 초과했습니다.");
    } else {
      records.add(new TakeOutRecord(book));
      userTakes.put(user.getUserID(), records);
      System.out.println("도서 " + book.getBookTitle() + " 을(를) 대출했습니다.");
      saveTakes(user);
    }
  }

}
