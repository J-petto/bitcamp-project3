package bitcamp.project3.util;


import bitcamp.project3.vo.TakeOutRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileHandler {
  String userHome = System.getProperty("user.home");
  String filePath = userHome + "/git/bitcamp-project3/database/taken";
  List<String> takeOutList = new ArrayList<>();

  File directory = new File(filePath);
  File[] files = directory.listFiles();

  public List<String> takeOutReader() {
    List<String> takeOutList = new ArrayList<>();
    String userHome = System.getProperty("user.home");
    String filePath = userHome + "/git/bitcamp-project3/database/taken";
    File directory = new File(filePath);
    File[] files = directory.listFiles();

    if (files != null) {
      for (File file : files) {
        try (FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
          Map<String, List<TakeOutRecord>> userTakes =
              (Map<String, List<TakeOutRecord>>) ois.readObject();
          for (List<TakeOutRecord> records : userTakes.values()) {
            for (TakeOutRecord record : records) {
              takeOutList.add(record.getTakesOutBook().getBookTitle());
            }
          }
        } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
      return takeOutList;
    } else {
      System.out.println("데이터 로딩 무참히 실패");
      return takeOutList;
    }
  }
}
