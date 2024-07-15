package bitcamp.project3.command;

import bitcamp.project3.command.mainCategory.AbstractComputer;

public class Computer extends AbstractComputer {
    String[] menus = {"책 조회", "책 반납", "뒤로가기"};

    public Computer(String menuTitle) {
        super(menuTitle);
    }

    @Override
    protected String[] getMenus() {
        return menus;
    }

    @Override
    protected void processMenu(String menuName) {
        switch (menuName){
            case "책 조회": bookCheck(); break;
            case "책 반납": bookReturn();break;
            case "뒤로가기":
        }
    }

    private void bookCheck(){
        System.out.println("책 조회입니다.");
    }

    private void bookReturn(){
        System.out.println("책 반납입니다.");
    }
}
