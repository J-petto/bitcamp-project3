package bitcamp.project3.vo;

import java.io.Serializable;

public class Book implements Serializable {
  private static int seqBookId;
  private int bookCode;
  private String bookTitle;
  private String bookAuthor;
  private String mainCategory;
  private String subCategory;

  public Book() {
  }

  public Book(String main, String sub, String bookTitle, String bookAuthor) {
    setBookCode();
    mainCategory = main;
    subCategory = sub;
    this.bookTitle = bookTitle;
    this.bookAuthor = bookAuthor;
  }

  public static int getSeqBookId() {
    return ++seqBookId;
  }

  public int getBookCode() {
    return bookCode;
  }

  public void setBookCode() {
    this.bookCode = getSeqBookId();
  }

  //  private void setBookCode2(String main, String sub) {
//    switch (main) {
//      case "한국서적":
//        bookCode += mainCategory.KOREAN;
//        break;
//      case "외국서적":
//        bookCode += mainCategory.OTHER;
//        break;
//      case "미디어":
//        bookCode += mainCategory.MEDIA;
//        break;
//    }
//
//    switch (sub) {
//      case "경제":
//        bookCode += subCategory.ECONOMY;
//        break;
//      case "인문학":
//        bookCode += subCategory.HUMAN;
//        break;
//      case "과학":
//        bookCode += subCategory.SCIENCE;
//        break;
//      case "자기계발":
//        bookCode += subCategory.SELF_HELP;
//        break;
//    }
//
//    this.bookCode = bookCode + getSeqBookId();
//  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

//  public String[] getBookContents() {
//    return bookContents;
//  }
//
//  public void setBookContents(String[] bookContents) {
//    this.bookContents = bookContents;
//  }

//  public boolean isLoneBook() {
//    return loneBook;
//  }

//  public void setLoneBook(int check) {
//    this.loneBook = check == 1;
//  }

  public String getBookAuthor() {
    return bookAuthor;
  }

  public String getMainCategory() {
    return mainCategory;
  }

  public String getSubCategory() {
    return subCategory;
  }
}
