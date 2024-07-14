package bitcamp.project3.command.mainCategory;

import bitcamp.project3.command.subCategory.Humanities;
import bitcamp.project3.command.subCategory.SubCommand;
import bitcamp.project3.vo.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class OtherBooks extends AbstractCommand {
    String[] menus = {"인문학", "자기계발", "경제", "과학", "뒤로가기"};

    HashMap<String, SubCommand> subHash = new HashMap<>();

    public OtherBooks(String menuTitle) {
        super(menuTitle);
        subHash.put("인문학", new Humanities("인문학"));
        subHash.put("자기계발", new Humanities("자기계발"));
        subHash.put("경제", new Humanities("경제"));
        subHash.put("과학", new Humanities("과학"));
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle + "(외국서적)";
    }

    @Override
    protected void processMenu(String menuName) {
        SubCommand command = subHash.get(menuName);
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
