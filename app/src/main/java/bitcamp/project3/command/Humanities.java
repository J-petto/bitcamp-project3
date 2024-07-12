package bitcamp.project3.command;

public class Humanities extends AbstractCommand {
    String[] menus = {"책1", "책2", "책3", "책4", "뒤로가기"};

    protected String menuTitle;

    public Humanities(String menuTitle) {
        super(menuTitle);
    }

    @Override
    protected String getCheckGo(String menuTitle) {
        return menuTitle;
    }

    @Override
    protected void processMenu(String menuName) {
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

    @Override
    protected String[] getMenus() {
        return menus;
    }

}
