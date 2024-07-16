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
    this.userTakes=new HashMap<>();
  };

  private void saveTakes() {
    String userHome = System.getProperty("user.home");
    String filePath = userHome + "/git/bitcamp-project3/database/takeout_manager.dat";
    try (FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(this.userTakes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Map<String, List<TakeOutRecord>> loadTakes() {
    String userHome = System.getProperty("user.home");
    String filePath = userHome + "/git/bitcamp-project3/database/takeout_manager.dat";
    try (FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
      return (Map<String, List<TakeOutRecord>>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("데이터 로딩에 실패했다는 사실~");
      return new HashMap<>();
    }
  }

  public boolean takeOut(User user, Book book) {
    String userID= user.getUserID();
    List<TakeOutRecord> records = userTakes.getOrDefault(user.getUserID(), new ArrayList<>());

    if(records.size()>MAX_LIMIT) {
      System.out.println("대출 한도를 초과했습니다.");
      return false;
    }

    records.add(new TakeOutRecord(book));
    userTakes.put(userID, records);
    saveTakes();
    System.out.println(book.getBookTitle()+"대출했습니다.");
    return true;
  }

}
