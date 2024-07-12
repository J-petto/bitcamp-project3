package bitcamp.project3.command.mainCategory;

import bitcamp.project3.command.AbstractCommand;
import bitcamp.project3.command.subCategory.Humanities;
import bitcamp.project3.command.subCategory.SubCommand;

import java.util.HashMap;
import java.util.Stack;

public class OtherBooks extends AbstractCommand {
    String[] menus = {"인문학", "자기계발", "경제", "과학", "뒤로가기"};

    HashMap<String, SubCommand> subHash = new HashMap<>();
    Stack<String> menuPath;

    public OtherBooks(String menuTitle, Stack<String> menuPath) {
        super(menuTitle);
        this.menuPath = menuPath;
        subHash.put("인문학", new Humanities("인문학"));
        subHash.put("자기계발", new Humanities("자기계발"));
        subHash.put("경제", new Humanities("경제"));
        subHash.put("과학", new Humanities("과학"));
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle + "(미디어 방)";
    }

    @Override
    protected void processMenu(String menuName) {
        System.out.println(menuName);
    }

    @Override
    protected String[] getMenus() {
        return menus;
    }
}
