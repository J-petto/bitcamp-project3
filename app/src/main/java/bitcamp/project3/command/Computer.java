package bitcamp.project3.command;

import bitcamp.project3.command.mainCategory.AbstractComputer;
import bitcamp.project3.vo.TakeOutManager;
import bitcamp.project3.vo.TakeOutRecord;
import bitcamp.project3.vo.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
//            for (TakeOutRecord value : values) {
//                System.out.println(value.getTakesOutBook().getBookTitle());
//                System.out.println(value.getTakesOutDate());
//            }
            printBookCheck(values);
        } else {
            System.out.println("지정된 키가 맵에 없습니다.");
        }
    }

    private void bookReturn() {
        System.out.println("책 반납입니다.");
    }

    private void printBookCheck(List<TakeOutRecord> values) {
        String ansiRed = "\u001B[31m";
        String ansiEnd = "\u001B[0m";
        String twoLine = "=========================================================";
        String oneLine = "---------------------------------------------------------";
        System.out.println(twoLine);
        System.out.println("| 대여한 책 이름                           |   대여일   |");
        System.out.println(oneLine);

        for (TakeOutRecord value : values) {
            String bookTitle = value.getTakesOutBook().getBookTitle();
            printSort(bookTitle);
            LocalDate loneDate = value.getTakesOutDate();
            LocalDate today = LocalDate.now();
            String isOverdue = ChronoUnit.DAYS.between(loneDate, today) > 14 ? ansiRed + loneDate + ansiEnd : String.valueOf(loneDate);
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
        for (int i = 0; i <resultSpace ; i++) {
            System.out.print("  ");
        }

        if(resultSpace > 0){
            if(eng % 2 == 1){
                System.out.print(" ");
            }
        }

        System.out.print(" |");
    }

    private boolean isKorean(char titleChar) {
        return titleChar >= 0xAC00 && titleChar <= 0xD7A3;
    }
}
