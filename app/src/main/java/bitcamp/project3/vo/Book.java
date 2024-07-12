package bitcamp.project3.vo;

import bitcamp.project3.BookCode.mainCategory;
import bitcamp.project3.BookCode.subCategory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Book {
  private static int seqBookId;
  private int bookCode;
  private String bookTitle;
  private String bookAuthor;
  private String[] bookContents;
  private boolean loneBook;
  //    List<User>
  private String category;

  public Book() {
  }


  public Book(String main, String sub, String bookTitle, String bookAuthor) {
    setBookCode2(main, sub);
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
  }

  public static int getSeqBookId() {
    return ++seqBookId;
  }

  public int getBookCode() {
    return bookCode;
  }

  private void setBookCode2(String main, String sub) {
    switch (main) {
      case "한국서적":
        bookCode += mainCategory.KOREAN;
        break;
      case "외국서적":
        bookCode += mainCategory.OTHER;
        break;
      case "미디어":
        bookCode += mainCategory.MEDIA;
        break;
    }

    switch (sub) {
      case "경제":
        bookCode += subCategory.ECONOMY;
        break;
      case "인문학":
        bookCode += subCategory.HUMAN;
        break;
      case "과학":
        bookCode += subCategory.SCIENCE;
        break;
      case "자기계발":
        bookCode += subCategory.SELF_HELP;
        break;
    }

    this.bookCode = bookCode + getSeqBookId();
  }


  private void setBookCode(String[] categorys) {
    int bookCode = 0;
    for (String category : categorys) {
      switch (category) {
        case "한국 서적":
          bookCode += mainCategory.KOREAN;
          break;
        case "외국 서적":
          bookCode += mainCategory.OTHER;
          break;
        case "미디어":
          bookCode += mainCategory.MEDIA;
          break;

        case "경제":
          bookCode += subCategory.ECONOMY;
          break;
        case "인문학":
          bookCode += subCategory.HUMAN;
          break;
        case "과학":
          bookCode += subCategory.SCIENCE;
          break;
        case "자기계발":
          bookCode += subCategory.SELF_HELP;
          break;
      }
    }
    this.bookCode = bookCode + getSeqBookId();
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String[] getBookContents() {
    return bookContents;
  }

  public void setBookContents(String[] bookContents) {
    this.bookContents = bookContents;
  }

  public boolean isLoneBook() {
    return loneBook;
  }

  public void setLoneBook(boolean loneBook) {
    this.loneBook = loneBook;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
    String[] categorys = category.split(" ");
    setBookCode(categorys);
  }

}
