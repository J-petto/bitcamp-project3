package bitcamp.project3.command;

public class MainCategory extends AbstractCommand {
    String[] menus = {"인문학", "자기계발", "경제", "과학", "뒤로가기"};

    public MainCategory(String menuTitle) {
        super(menuTitle);
    }

    @Override
    protected void processMenu(String menuName) {
        switch (menuName){
            case "인문학": System.out.println(menuName);break;
            case "자기계발": System.out.println(menuName);break;
            case "경제": System.out.println(menuName);break;
            case "과학": System.out.println(menuName);break;
            case "뒤로가기": break;
        }
    }

    @Override
    protected String[] getMenus() {
        return menus;
    }

}
