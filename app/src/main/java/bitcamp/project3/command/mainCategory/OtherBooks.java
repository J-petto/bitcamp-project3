package bitcamp.project3.command.mainCategory;

import bitcamp.project3.command.subCategory.TakeOutCommand;
import bitcamp.project3.command.subCategory.SubCommand;
import bitcamp.project3.vo.User;

import java.util.HashMap;

public class OtherBooks extends AbstractCommand {
    String[] menus = {"인문학", "자기계발", "경제", "과학"};

    HashMap<String, SubCommand> subHash = new HashMap<>();

    public OtherBooks(String menuTitle) {
        super(menuTitle);
        subHash.put("인문학", new TakeOutCommand("인문학"));
        subHash.put("자기계발", new TakeOutCommand("자기계발"));
        subHash.put("경제", new TakeOutCommand("경제"));
        subHash.put("과학", new TakeOutCommand("과학"));
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle + "(외국서적)";
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
