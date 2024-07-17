package bitcamp.project3.command;

import bitcamp.project3.command.mainCategory.AbstractComputer;
import bitcamp.project3.util.BookDataReader;
import bitcamp.project3.util.FileHandler;
import bitcamp.project3.util.Prompt;
import bitcamp.project3.vo.Book;
import bitcamp.project3.vo.TakeOutManager;
import bitcamp.project3.vo.TakeOutRecord;
import bitcamp.project3.vo.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Computer extends AbstractComputer {
  BookDataReader reader = BookDataReader.getInstance();
  List<Book> books = reader.getBooks();
  FileHandler takeOutList = new FileHandler();
  List<String> takenBooks = new ArrayList<>();
  TakeOutManager test = new TakeOutManager();
  String[] menus = {"책 검색", "내 대여 내역 조회", "책 반납"};
  private Map<String, List<TakeOutRecord>> userTakes;

  public Computer(String menuTitle) {
    super(menuTitle);
  }

  @Override
  protected String[] getMenus() {
    return menus;
  }

  @Override
  protected void processMenu(String menuName, User user) {
    switch (menuName) {
      case "내 대여 내역 조회":
        takeOutCheck(user);
        break;
      case "책 반납":
        bookReturn(user);
        break;
      case "책 검색":
        bookCheck();
        break;
      case "뒤로가기":
    }
  }

  private void takeOutCheck(User user) {
    System.out.println("조회중 . . .");
    userTakes = test.loadTakes(user);
    if (userTakes.containsKey(user.getUserID())) {
      List<TakeOutRecord> values = userTakes.get(user.getUserID());
      printBookCheck(values);
    } else {
      System.out.println(user.getUserID() + "님은 현재 대출 중인 도서가 없습니다.");
    }
  }

  private void bookCheck() {
    takenBooks = takeOutList.takeOutReader();
    String search = Prompt.input("찾으시는 도서의 이름을 입력해주세요! ");
    for (Book book : books) {
      if (book.getBookTitle().equals(search)) {
        System.out.printf("해당 도서는 %s의 %s에 배치되어 있습니다.\n", book.getMainCategory(),
            book.getSubCategory());
        if (!(takenBooks.contains(book.getBookTitle()))) {
          System.out.println("대출 가능한 도서 입니다.");
        } else {
          System.out.println("대출 중인 도서 입니다.");
        }
      }
    }
  }


  private void bookReturn(User user) {
    System.out.println("조회중 . . .");
    userTakes = test.loadTakes(user);
    if (userTakes.containsKey(user.getUserID())) {
      List<TakeOutRecord> values = userTakes.get(user.getUserID());
      printBookCheck(values);
      String command = Prompt.input("반납하실 책의 이름을 입력해주세요.\n");
      Iterator<TakeOutRecord> iterator = values.iterator();
      boolean found = false;
      while (iterator.hasNext()) {
        TakeOutRecord value = iterator.next();
        if (value.getTakesOutBook().getBookTitle().equals(command)) {
          iterator.remove();
          found = true;
          System.out.println("도서 " + command + "(이)가 성공적으로 반납되었습니다.");
          break;
        }
      }
      if (!found) {
        System.out.println("입력하신 이름의 책을 찾을 수 없습니다.");
      } else {
        test.updateUserTakes(user.getUserID(), values);
        test.saveTakes(user);
      }
    } else {
      System.out.println(user.getUserID() + "님은 현재 대출 중인 도서가 없습니다.");
    }
  }

  private void printBookCheck(List<TakeOutRecord> values) {
    String ansiRed = "\u001B[31m";
    String ansiEnd = "\u001B[0m";
    String twoLine = "=========================================================";
    String oneLine = "---------------------------------------------------------";
    System.out.println(twoLine);
    System.out.println("| 대여한 책 이름                           |   반납일   |");
    System.out.println(oneLine);

    for (TakeOutRecord value : values) {
      String bookTitle = value.getTakesOutBook().getBookTitle();
      printSort(bookTitle);
      LocalDate loneDate = value.getTakesOutDate().plusDays(14);
      LocalDate today = LocalDate.now();
      String isOverdue = loneDate.isBefore(today) ?
          ansiRed + loneDate + ansiEnd :
          String.valueOf(loneDate);
      System.out.printf(" %s |\n", isOverdue);
    }
    System.out.println(twoLine);
  }

  // 한글 영어 구분
  private void printSort(String title) {
    final int TITLE_MAX = 20;

    int kor = 0;
    int eng = 0;
    System.out.print("| ");
    System.out.print(title);

    for (char titleChar : title.toCharArray()) {
      if (isKorean(titleChar)) {
        kor++;
        continue;
      }
      eng++;
    }

    int resultSpace = TITLE_MAX - kor - (eng / 2) - (eng % 2);
    for (int i = 0; i < resultSpace; i++) {
      System.out.print("  ");
    }

    if (resultSpace > 0) {
      if (eng % 2 == 1) {
        System.out.print(" ");
      }
    }

    System.out.print(" |");
  }

  private boolean isKorean(char titleChar) {
    return titleChar >= 0xAC00 && titleChar <= 0xD7A3;
  }
}
