package bitcamp.project3.command.subCategory;

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
  dataReader reader = dataReader.getInstance();
  List<Book> books = reader.getBooks();
  TakeOutManager test = new TakeOutManager();
  List<Book> takenBooks = new ArrayList<>();
  private Map<String, List<TakeOutRecord>> userTakes;

  protected String menuTitle;

  public Humanities(String menuTitle) {
    super(menuTitle);
  }

  @Override
  protected String getCheckGo(String menuTitle) {
    return menuTitle;
  }

  private void loadBooks() {
    this.userTakes = test.loadTakes();
  }

  private void bookAllCheck() {
    loadBooks();
    for (Map.Entry<String, List<TakeOutRecord>> entry : userTakes.entrySet()) {
//      String userID = entry.getKey();
      List<TakeOutRecord> records = entry.getValue();
      for (TakeOutRecord record : records) {
        takenBooks.add(record.getTakesOutBook());
        }
    }
  }

  @Override
  protected void processMenu(int bookNo, List<Book> sortBooks, User user) {
    Book book = sortBooks.get(bookNo - 1);
    bookAllCheck();
    while (true) {
      String command = Prompt.input("%s를 대여하시겠습니까?", book.getBookTitle());
      if (command.equalsIgnoreCase("y")) {
        if (!(takenBooks.contains(book))) {
          test.takeOut(user, book);
          break;
        }
        break;
      } else if (command.equalsIgnoreCase("n")) {
        System.out.println("다른 사람이 대출 중인 책입니다." +
            "책을 제자리에 돌려놨습니다.");
        break;
      } else {
        System.out.println("y나 n로 대답해주세요.");
      }
    }
  }

  @Override
  protected List<Book> getMenus() {
    return books;
  }

}
