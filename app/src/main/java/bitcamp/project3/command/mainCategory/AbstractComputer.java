package bitcamp.project3.command.mainCategory;

import bitcamp.project3.PrintMap;
import bitcamp.project3.util.Prompt;
import bitcamp.project3.vo.User;

import java.util.Stack;

public abstract class AbstractComputer implements Command{
    protected String menuTitle;

    PrintMap mapPrinter = new PrintMap();

    public AbstractComputer(String menuTitle){
        this.menuTitle = menuTitle;
    }

    @Override
    public void execute(Stack<String> menuPath, User user) {
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
                processMenu(menuName, user);

            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

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

    protected abstract void processMenu(String menuName, User user);
}
