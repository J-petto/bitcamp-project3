package bitcamp.project3.command;

import bitcamp.project3.util.Prompt;

import java.util.Stack;

public class Humanities {
    String[] menus = {"책1", "책2", "책3", "책4", "뒤로가기"};

    protected String menuTitle;

    public void execute(Stack<String> menuPath, String menuTitle) {
        this.menuTitle = menuTitle;

        if(!checkGo()){
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
                if(menuName.equals("뒤로가기")){
                    menuPath.pop();
                    return;
                }
                processMenu(menuName);

            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

    private boolean checkGo(){
        while (true) {
            String toGo = Prompt.input("%s 책장으로 갈까?", menuTitle);
            if (toGo.equalsIgnoreCase("n")) {
                return false;
            } else if (toGo.equalsIgnoreCase("y")) {
                return true;
            } else {
                System.out.println("y와 n 중에 하나만 입력해주세요.");
            }
        }
    }

    private void processMenu(String menuName) {
        switch (menuName) {
            case "책1":
                System.out.println(menuName);
                break;
            case "책2":
                System.out.println(menuName);
                break;
            case "책3":
                System.out.println(menuName);
                break;
            case "책4":
                System.out.println(menuName);
                break;
        }
    }

    private void printMenus() {
        System.out.printf("[%s]\n", menuTitle);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", (i + 1), menus[i]);
        }
        System.out.println("9. 이전");
    }

    private String getMenuTitle(int menuNo) {
        return isValidateMenu(menuNo) ? menus[menuNo - 1] : null;
    }

    private boolean isValidateMenu(int menuNo) {
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

}
