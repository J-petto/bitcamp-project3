package bitcamp.project3.util;

import bitcamp.project3.vo.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class dataReader {

//  public List<Book> listReader() {
//    List<Book> books = new ArrayList<>();
//
//    try {
//      BufferedReader br = new BufferedReader(
//          new FileReader("/home/kei/git/bitcamp-project3/database/book/books.txt"));
//      String line;
//      while ((line = br.readLine()) != null) {
//        String[] parts = line.split(",");
//        if (parts.length == 4) {
//          books.add(new Book(parts[0], parts[1], parts[2], parts[3]));
//        }
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//
//    return books;
//  }

    private final List<Book> books = new ArrayList<>();

    public List<Book> listReader() {
        // 유저 홈을 받아와 유동적으로 연결
        try {
            String userHome = System.getProperty("user.home");
            BufferedReader br = new BufferedReader(
                    new FileReader(userHome + "/git/bitcamp-project3/database/book/books.txt"));
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

//    public List<Book> categoryBooks(Stack<String> menuPath) {
//        List<Book> categoryBooks = new ArrayList<>();
//        int mainCategory = 1;
//        int subCategory = 2;
//
//        String mainMenu = menuPath.get(mainCategory);
//        String subMenu = menuPath.get(subCategory);
//
//        for (Book book : books) {
//            String mainBook = book.getMainCategory();
//            String subBook= book.getBookAuthor();
//            if (mainBook.equals(mainMenu)) {
//                if(subBook.equals(subMenu)){
//                    categoryBooks.add(book);
//                }
//            }
//        }
//
//        return categoryBooks;
//    }
}

