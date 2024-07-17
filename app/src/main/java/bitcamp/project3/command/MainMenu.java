package bitcamp.project3.command;

import bitcamp.project3.PrintMap;
import bitcamp.project3.command.mainCategory.Command;
import bitcamp.project3.command.mainCategory.KoreanBooks;
import bitcamp.project3.command.mainCategory.MediaRoom;
import bitcamp.project3.command.mainCategory.OtherBooks;
import bitcamp.project3.util.Prompt;
import bitcamp.project3.vo.User;

import java.util.HashMap;
import java.util.Stack;

public class MainMenu {

    String[] menus = {"계단", "오른쪽 통로", "왼쪽 통로", "컴퓨터"};

    Stack<String> menuPath = new Stack<>();
    HashMap<String, Command> mainHash = new HashMap<>();

    PrintMap mapPrinter = new PrintMap();

    public MainMenu(){
        mainHash.put("계단", new KoreanBooks("계단"));
        mainHash.put("오른쪽 통로", new OtherBooks("오른쪽 통로"));
        mainHash.put("왼쪽 통로", new MediaRoom("왼쪽 통로"));
        mainHash.put("컴퓨터", new Computer("컴퓨터"));
    }

    public void execute(User loginUser) {
        menuPath.push("로비");
        mapPrinter.printBox(menuPath, "로비");
        printMenu();
        String command;
        while (true) {
            command = Prompt.input("%s>", getMenuPathTitle(menuPath));
            if (command.equals("menu")) {
                printMenu();
                continue;
            }
            if(command.equals("0")){
                menuPath.pop();
                break;
            }
            try {
                int menuNo = Integer.parseInt(command);
                String menuTitle = getMenuTitle(menuNo);
                if (menuTitle == null) {
                    System.out.println("유효한 메뉴가 아닙니다.");
                }else {
                    processMenu(menuTitle, loginUser);
                }
            }catch (NumberFormatException e){
                System.out.println("메뉴는 번호로 입력해주세요.");
            }

        }
    }

    private void processMenu(String menuTitle, User user) {
        Command command = mainHash.get(menuTitle);
        if (command == null) {
            System.out.println("해당 메뉴의 명령을 처리할 수 없습니다.");
            return;
        }
        command.execute(menuPath, user);
    }

    boolean isValidateMainMenu(int menuNo) {
        return menuNo >= 1 && menuNo <= menus.length;
    }

    private String getMenuTitle(int menuNo) {
        return isValidateMainMenu(menuNo) ? menus[menuNo - 1] : null;
    }

    private void printMenu() {
        int count = 1;
        System.out.println("[로비]");
        for (String menu : menus) {
            System.out.printf("%s. %s\n", count++, menu);
        }
        System.out.println("0. 뒤로가기");
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
