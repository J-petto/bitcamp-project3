package bitcamp.project3.util;

import bitcamp.project3.vo.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class dataReader {
    private final List<Book> books;
    private static dataReader instance;

    private dataReader() {
        books = new ArrayList<>();
        initializeBooks();
    }

    public static dataReader getInstance() {
        if (instance == null) {
            instance = new dataReader();
        }
        return instance;
    }


    private void initializeBooks() {
        try {
            String userHome = System.getProperty("user.home");
            BufferedReader br = new BufferedReader(
                    new FileReader(userHome + "/git/bitcamp-project3/database/book/books.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    books.add(new Book(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}

//    public List<Book> listReader() {
//        // 유저 홈을 받아와 유동적으로 연결
//        try {
//            String userHome = System.getProperty("user.home");
//            BufferedReader br = new BufferedReader(
//                    new FileReader(userHome + "/git/bitcamp-project3/database/book/books.txt"));
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(", ");
//                if (parts.length == 4) {
//                    books.add(new Book(parts[0], parts[1], parts[2], parts[3]));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return books;
//    }



