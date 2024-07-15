/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.project3;

import bitcamp.project3.command.mainCategory.Command;
import bitcamp.project3.util.Login;
import bitcamp.project3.command.mainCategory.MediaRoom;
import bitcamp.project3.command.mainCategory.OtherBooks;
import bitcamp.project3.command.mainCategory.KoreanBooks;
import bitcamp.project3.util.Prompt;
import bitcamp.project3.util.dataReader;
import bitcamp.project3.vo.User;
import bitcamp.project3.vo.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class App {
    String[] menus = {"계단", "오른쪽 통로", "왼쪽 통로", "뒤로가기"};
    String[] loginMenus = {"로그인", "회원가입", "비밀번호 찾기", "종료"};
    Stack<String> menuPath = new Stack<>();
    HashMap<String, Command> mainHash = new HashMap<>();

//    PrintMap mapPrinter = new PrintMap();

    public App() {
        mainHash.put("계단", new KoreanBooks("계단"));
        mainHash.put("오른쪽 통로", new OtherBooks("오른쪽 통로"));
        mainHash.put("왼쪽 통로", new MediaRoom("왼쪽 통로"));
    }

    public static void main(String[] args) {
        new App().init();
    }

    void init() {
        System.out.println("[로그인]");
        while (true) {
            printLoginMenu();
            String command = Prompt.input("> ");
            try {
                int menuNo = Integer.parseInt(command);
                String menuTitle = getloginMenuTitle(menuNo, loginMenus);
                if (menuTitle == null) {
                    System.out.println("유효한 메뉴가 아닙니다.");
                } else {
                    processLogin(menuTitle);
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

    void execute(User loginUser) {
        menuPath.push("로비");
//        mapPrinter.printBox(menuPath);
        printMenu();
        String command;
        while (true) {
            command = Prompt.input("%s>", getMenuPathTitle(menuPath));
            if (command.equals("menu")) {
                printMenu();
                continue;
            }
            int menuNo = Integer.parseInt(command);
            String menuTitle = getMenuTitle(menuNo);
            if (menuTitle == null) {
                System.out.println("유효한 메뉴가 아닙니다.");
            } else if (menuTitle.equals("뒤로가기")) {
                System.exit(0);
            } else {
                processMenu(menuTitle);
            }
        }
    }

    private void processMenu(String menuTitle) {
        Command command = mainHash.get(menuTitle);
        if (command == null) {
            System.out.println("해당 메뉴의 명령을 처리할 수 없습니다.");
            return;
        }
        command.execute(menuPath);
    }

    private void processLogin(String menuTitle) {
        switch (menuTitle) {
            case "로그인":
                User user = Login.loginUser();
                if (!(user == null)) {
                    new App().execute(user);
                    break;
                } else {
                    System.out.println("횟수 초가 - 초기화면으로 돌아갑니다.");
                    break;
                }
            case "회원가입":
                Login.authUser();
                break;
            case "비밀번호 분실":
                Login.reSetUserPassword();
                break;
            case "종료":
                System.out.println("시스템을 종료합니다.");
                System.exit(0);
            default:
                System.out.println("없는 메뉴입니다.");
                break;
        }
    }

    boolean isvalidatemenu(int menuNo, String[] loginMenus) {

        return menuNo >= 1 && menuNo <= loginMenus.length;
    }

    String getloginMenuTitle(int menuNo, String[] loginMenus) {
        return isvalidatemenu(menuNo, loginMenus) ? loginMenus[menuNo - 1] : null;
    }

    private String getMenuTitle(int menuNo) {
        return menus[menuNo - 1];
    }

    //  private String getMenuTitle(int menuNo) {
    //    return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
    //  }

    //  private boolean isValidateMenu(int menuNo) {
    //    return menuNo >= 1 && menuNo <= menus.length;
    //  }

    private void printMenu() {
        int count = 1;
        System.out.println("[로비]");
        for (String menu : menus) {
            System.out.printf("%s. %s\n", count++, menu);
        }
    }

    private void printLoginMenu() {
        int count = 1;
        for (String menu : loginMenus) {
            System.out.printf("%s. %s\n", count++, menu);
        }
    }

    private String getMenuPathTitle(Stack<String> menuPath) {
        StringBuilder strBuilder = new StringBuilder();
        for (String string : menuPath) {
            if (!strBuilder.isEmpty()) {
                strBuilder.append("/");
            }
            strBuilder.append(string);
        }
        return strBuilder.toString();
    }
}
