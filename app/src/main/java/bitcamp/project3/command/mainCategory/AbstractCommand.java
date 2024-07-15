package bitcamp.project3.command.mainCategory;

import bitcamp.project3.PrintMap;
import bitcamp.project3.util.Prompt;
import bitcamp.project3.vo.Book;

import java.util.List;
import java.util.Stack;

public abstract class AbstractCommand implements Command{

    protected String menuTitle;
    protected Stack<String> menuPath;

    PrintMap mapPrinter = new PrintMap();

    public AbstractCommand(String menuTitle){
        this.menuTitle = menuTitle;
    }
    @Override
    public void execute(Stack<String> menuPath) {
        mapPrinter.printBox(menuPath, menuTitle);

        if (!checkGo(menuPath)) {
            return;
        }

        menuPath.push(menuTitle);
        mapPrinter.printBox(menuPath, menuTitle);
        this.menuPath = menuPath;

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
                processMenu(menuName);

            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

    private boolean checkGo(Stack<String> menuPath) {
        mapPrinter.printBox(menuPath, menuTitle);
        while (true) {
            String toGo = Prompt.input("%s 갈까?", getCheckGo(menuTitle));
            if (toGo.equalsIgnoreCase("n")) {
                mapPrinter.printBox(menuPath, "로비");
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
        String[] menus = getMenus();
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
    }

    private String getMenuTitle(int menuNo) {
        String[] menus = getMenus();
        return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
    }

    private boolean isValidateMenu(int menuNo) {
        String[] menus = getMenus();
        return menuNo >= 1 && menuNo <= menus.length;
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

    protected abstract String[] getMenus();

    protected abstract void processMenu(String menuName);
}
