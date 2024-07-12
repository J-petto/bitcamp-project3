package bitcamp.project3.command.subCategory;

import bitcamp.project3.util.Prompt;
import bitcamp.project3.vo.Book;

import java.util.ArrayList;
import java.util.Stack;

public abstract class AbstractSubCommand implements SubCommand{

    protected String menuTitle;

    public AbstractSubCommand(String menuTitle){
        this.menuTitle = menuTitle;
    }

    @Override
    public void execute(Stack<String> menuPath) {
        if (!checkGo()) {
            return;
        }

        menuPath.push(menuTitle);
        printMenus();

        while (true) {
            String command = Prompt.input("%s>", getMenuPathTitle(menuPath));
            if (command.equals("menu")) {
                printMenus();
                continue;
            }

            try {
                int menuNo = Integer.parseInt(command);
                String menuName = getMenuTitle(menuNo);
                if (menuName == null) {
                    System.out.println("유효한 메뉴 번호가 아닙니다.");
                    continue;
                }
                if (menuName.equals("뒤로가기")) {
                    menuPath.pop();
                    return;
                }
                processMenu(menuNo);

            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

    private boolean checkGo() {
        while (true) {
            String toGo = Prompt.input("%s 갈까?", getCheckGo(menuTitle));
            if (toGo.equalsIgnoreCase("n")) {
                return false;
            } else if (toGo.equalsIgnoreCase("y")) {
                return true;
            } else {
                System.out.println("y와 n 중에 하나만 입력해주세요.");
            }
        }
    }

    abstract protected String getCheckGo(String menuTitle);

    private void printMenus() {
        ArrayList<Book> menus = getMenus();
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.size(); i++) {
            String bookTitle = menus.get(i).getBookTitle();
            System.out.printf("%d. %s\n", (i + 1), bookTitle);
        }
    }

    private String getMenuTitle(int menuNo) {
        ArrayList<Book> menus = getMenus();
        return isValidateMenu(menuNo) ? menus.get(menuNo - 1).getBookTitle() : null;
    }

    private boolean isValidateMenu(int menuNo) {
        ArrayList<Book> menus = getMenus();
        return menuNo >= 1 && menuNo <= menus.size();
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

   abstract protected void processMenu(int bookNo);

   abstract protected ArrayList<Book> getMenus();
}
