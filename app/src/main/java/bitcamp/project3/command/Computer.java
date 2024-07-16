package bitcamp.project3.command;

import bitcamp.project3.command.mainCategory.AbstractComputer;
import bitcamp.project3.vo.TakeOutManager;
import bitcamp.project3.vo.TakeOutRecord;
import bitcamp.project3.vo.User;

import java.util.List;
import java.util.Map;

public class Computer extends AbstractComputer {
  TakeOutManager test = new TakeOutManager();
  String[] menus = {"책 조회", "책 반납", "뒤로가기"};
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
      case "책 조회":
        bookCheck(user.getUserID());
        break;

      case "책 반납":
        bookReturn();
        break;
      case "뒤로가기":
    }
  }

  private void loadBooks() {
      this.userTakes = test.loadTakes();
  }

  private void bookCheck(String userID) {
    System.out.println("책 조회입니다.");
    loadBooks();
      if (userTakes.containsKey(userID)) {
          List<TakeOutRecord> values = userTakes.get(userID);
          for (TakeOutRecord value : values) {
              System.out.println(value.getTakesOutBook().getBookTitle());
              System.out.println(value.getTakesOutDate());
          }
      } else {
          System.out.println("지정된 키가 맵에 없습니다.");
      }
  }

  private void bookReturn() {
    System.out.println("책 반납입니다.");
  }
}
