package bitcamp.project3.command.mainCategory;

import bitcamp.project3.command.subCategory.Humanities;
import bitcamp.project3.command.subCategory.SubCommand;
import bitcamp.project3.vo.Book;
import bitcamp.project3.vo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MediaRoom extends AbstractCommand {
    String[] menus = {"한국영화", "외국영화", "뒤로가기"};

    HashMap<String, SubCommand> subHash = new HashMap<>();

    public MediaRoom(String menuTitle) {
        super(menuTitle);
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle + "(미디어)";
    }

    @Override
    protected void processMenu(String menuName, User user) {

    }

    @Override
    protected String[] getMenus() {
        return menus;
    }
}
