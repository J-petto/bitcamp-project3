package bitcamp.project3.command.mainCategory;

import bitcamp.project3.command.subCategory.Humanities;
import bitcamp.project3.command.subCategory.SubCommand;
import bitcamp.project3.vo.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MediaRoom extends AbstractCommand {
    String[] menus = {"인문학", "자기계발", "경제", "과학", "뒤로가기"};

    HashMap<String, SubCommand> subHash = new HashMap<>();

    public MediaRoom(String menuTitle) {
        super(menuTitle);
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle + "(미디어)";
    }

    @Override
    protected void processMenu(String menuName) {

    }

    @Override
    protected String[] getMenus() {
        return menus;
    }
}
