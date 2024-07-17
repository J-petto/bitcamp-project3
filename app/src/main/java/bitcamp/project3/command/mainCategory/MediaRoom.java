package bitcamp.project3.command.mainCategory;

import bitcamp.project3.command.subCategory.TakeOutCommand;
import bitcamp.project3.command.subCategory.SubCommand;
import bitcamp.project3.vo.User;

import java.util.HashMap;

public class MediaRoom extends AbstractCommand {
    String[] menus = {"한국영화", "외국영화"};

    HashMap<String, SubCommand> subHash = new HashMap<>();

    public MediaRoom(String menuTitle) {
        super(menuTitle);
        subHash.put("한국영화", new TakeOutCommand("한국영화"));
        subHash.put("외국영화", new TakeOutCommand("외국영화"));
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle + "(미디어)";
    }

    @Override
    protected void processMenu(String menuName, User user) {
        SubCommand command = subHash.get(menuName);
        if(command == null){
            System.out.println("해당 메뉴의 명령을 처리할 수 없습니다.");
            return;
        }
        command.execute(menuPath, user);
    }

    @Override
    protected String[] getMenus() {
        return menus;
    }
}
