package bitcamp.project3.command.subCategory;

import bitcamp.project3.util.FileHandler;
import bitcamp.project3.util.Prompt;
import bitcamp.project3.util.dataReader;
import bitcamp.project3.vo.Book;
import bitcamp.project3.vo.TakeOutManager;
import bitcamp.project3.vo.TakeOutRecord;
import bitcamp.project3.vo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Humanities extends AbstractSubCommand {
  FileHandler takeOutList = new FileHandler();
  dataReader reader = dataReader.getInstance();
  List<Book> books = reader.getBooks();
  TakeOutManager test = new TakeOutManager();
  List<String> takenBooks = new ArrayList<>();
  private Map<String, List<TakeOutRecord>> userTakes;

  protected String menuTitle;

  public Humanities(String menuTitle) {
    super(menuTitle);
  }

  @Override
  protected String getCheckGo(String menuTitle) {
    return menuTitle;
  }

  @Override
  protected void processMenu(int menuNo, List<Book> sortBooks, User user) {
    Book book = sortBooks.get(menuNo - 1);
    takenBooks = takeOutList.takeOutReader();
    userTakes = test.loadTakes(user);
    while (true) {
      String command = Prompt.input("%s를 대여하시겠습니까?", book.getBookTitle());
      if (command.equalsIgnoreCase("y")) {
        if (!(takenBooks.contains(book.getBookTitle()))) {
          test.takeOut(user, book);
          break;
        } else {
          System.out.println("대출 중인 도서입니다.");
          System.out.println("책을 제자리에 돌려놨습니다.");
          break;
        }
      } else if (command.equalsIgnoreCase("n")) {
        System.out.println("책을 제자리에 돌려놨습니다.");
        break;
      } else {
        System.out.println("y나 n로 대답해주세요.");
      }
    }
  }

//  private void bookReservation(Book book) {
//    while (true) {
//      String command = Prompt.input("다른 사람이 대출 중인 책입니다. 예약하시겠습니까?");
//      if (command.equalsIgnoreCase("y")) {
//        System.out.println("예약했습니다");
//        break;
//      } else if (command.equalsIgnoreCase("n")) {
//        break;
//      } else {
//        System.out.println("y나 n로 대답해주세요.");
//      }
//    }
//
//  }



  @Override
  protected List<Book> getMenus() {
    return books;
  }

}
