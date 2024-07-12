package bitcamp.project3.command.mainCategory;

import bitcamp.project3.command.AbstractCommand;
import bitcamp.project3.command.Command;
import bitcamp.project3.command.Humanities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class KoreanBooks extends AbstractCommand {
    String[] menus = {"인문학", "자기계발", "경제", "과학", "뒤로가기"};

    Stack<String> menuPath;

    HashMap<String, Command> subHash = new HashMap<>();
    public KoreanBooks(String menuTitle, Stack<String> menuPath) {
        super(menuTitle);
        this.menuPath = menuPath;
        subHash.put("인문학", new Humanities("인문학"));
        subHash.put("자기계발", new Humanities("자기계발"));
        subHash.put("경제", new Humanities("경제"));
        subHash.put("과학", new Humanities("과학"));
    }
    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle + "(한국서적)";
    }

    @Override
    protected void processMenu(String menuName) {
        Command command = subHash.get(menuName);
        if(command == null){
            System.out.println("해당 메뉴의 명령을 처리할 수 없습니다.");
            return;
        }
        command.execute(menuPath);
    }

    @Override
    protected String[] getMenus() {
        return menus;
    }
}
