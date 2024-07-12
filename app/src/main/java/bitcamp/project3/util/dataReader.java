package bitcamp.project3.util;

import bitcamp.project3.vo.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class dataReader {

  public List<Book> listReader() {
    List<Book> books = new ArrayList<>();

    try {
      BufferedReader br = new BufferedReader(
          new FileReader("/home/kei/git/bitcamp-project3/database/book/books.txt"));
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
          books.add(new Book(parts[0], parts[1], parts[2], parts[3]));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return books;
  }


}
