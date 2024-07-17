/*
 * This source file was generated by the Gradle 'init' task
 */
package bitcamp.project3;

import bitcamp.project3.command.MainMenu;
import bitcamp.project3.util.Login;
import bitcamp.project3.util.Prompt;
import bitcamp.project3.vo.User;

public class App {
    String[] loginMenus = {"로그인", "회원가입", "재설정", "종료"};
    MainMenu mainMenu = new MainMenu();

    public static void main(String[] args) {
        new App().init();
    }

    private void loginImg(){
        System.out.print("\n" +
                "⣳⣳⡳⡵⣯⣳⣝⣗⣗⡯⣗⢇⡏⣖⡇⡳⣝⡺⡜⡮⡺⣪⢮⡫⡮⡳⣕⢯⡳⡕⣗⢝⢮⡣⣗⢵⢳⡹⣕⣽⣱⣳⣕⣮⡳⡵⡝⣎⣗⣝⢮⡳⣝⢮⡳⣝⢮⢯⡳⡽\n" +
                "⣵⡳⡽⡽⣺⣺⡺⣺⣺⣺⡣⡇⡗⣕⡧⢱⡣⣳⢹⡪⣫⡺⣪⢮⡫⣞⢮⢳⢕⢯⢎⣏⢧⣳⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣶⣕⢗⣝⢮⡳⣝⢮⢯⡺⡮⣫\n" +
                "⡺⡹⡝⣝⡓⡗⣝⢭⢝⡲⣱⢹⢜⢎⡧⡑⡯⡪⡧⣫⡺⣚⢮⡣⡯⡺⣪⡳⣝⡕⣗⢵⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣧⡳⡝⣎⢗⣗⣝⢮⡳\n" +
                "⣣⢳⡹⡔⡽⡸⡜⡼⣜⠼⡜⡮⣪⢳⠱⣸⢝⢵⡹⡪⡮⡳⡣⡯⢮⣫⡺⣜⢮⢺⣪⠣⠨⣢⣶⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣮⡳⡝⣖⢵⡫⣞\n" +
                "⡴⣳⢽⢽⣫⣟⢿⢽⢽⣻⣫⢿⢽⣻⣻⢽⣻⣳⣝⢮⡳⡝⣝⢮⢳⡱⣕⢧⢳⡣⣯⣼⣿⣿⣿⡿⡟⢍⠢⠡⡉⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣮⢏⡮⡳⣝⢞\n" +
                "⣯⣯⣯⣻⣺⣺⣽⣽⢽⡺⡺⠽⠽⢞⠾⠽⢞⠷⡯⡷⢵⢝⢮⢮⡳⠽⢜⠮⠧⡳⡵⡿⡛⡝⢅⠢⠩⡢⡅⢕⠨⡘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣗⣝⢽⢜⡵\n" +
                "⢀⢂⢐⠠⢂⢂⢐⠠⠂⠔⠨⢈⠔⡐⠨⢐⠐⡐⠠⢂⠂⡂⢂⠂⠔⠡⢂⢌⠤⢝⢚⠰⡐⡅⠕⢌⢊⠢⡑⢅⢑⠌⡺⣿⣿⠟⠟⢿⣿⣿⣿⣿⣿⣿⣿⡷⡕⣗⡳⣝\n" +
                "⣀⣢⠴⡬⡴⣔⣴⢾⢾⢾⡽⣕⡆⡂⠅⡂⠌⡐⡁⠢⠨⠠⢁⠊⠌⡨⢰⠣⠡⡑⡐⢅⠢⣹⢌⠢⠢⡑⢌⢂⢆⢑⢌⡻⠡⡡⡑⢅⢙⣿⣿⣿⣿⣿⣿⢯⡺⣪⡺⣜\n" +
                "⡷⣗⣟⣯⡿⣯⢿⢝⣟⠽⠽⠕⡓⠠⢁⠂⠅⡂⠂⠅⡊⠌⡐⠨⢐⠠⡇⡅⢕⠨⠨⡂⢕⠨⡃⢅⠕⢌⢂⢆⠢⡑⢄⠅⢕⢐⠌⡂⡂⣿⣿⣿⣿⣿⣟⣕⢧⢳⢕⢇\n" +
                "⠨⠩⢉⠍⡨⢐⠐⡐⢐⠨⢐⠡⡆⢃⠒⠑⠑⠒⠑⠑⠒⠑⢒⠑⠒⠒⢗⠨⡂⢅⢕⠨⡂⢕⠨⠢⡑⢔⢑⠄⢕⠨⠢⠡⡑⣐⣑⣌⣶⣿⣿⣿⢿⢋⢐⢀⠻⠼⣕⢽\n" +
                "⠠⡁⡂⡂⡂⠅⢌⢐⢐⠨⢐⠐⢹⢢⠀⡁⠸⡀⡁⠑⡇⢱⢱⢌⢞⡇⢨⢮⣈⢂⠢⡑⢌⠢⠡⡑⢌⢂⠢⡡⢡⠡⠣⣑⢌⣌⣻⡿⡿⣟⡯⡷⡐⡀⡂⡐⠠⢁⠑⢯\n" +
                "⡐⢐⢐⠠⠂⠅⡂⢂⠂⢌⢐⠨⢐⠹⣢⠀⠂⢱⠀⠂⠹⡆⠹⢎⡿⡵⢯⢯⢾⢽⡺⣲⢵⡭⡮⣖⡵⣖⣗⣞⢮⣻⣻⢵⡻⣮⡳⡽⡽⡵⣫⢯⢗⡀⡂⠄⠅⢊⠳⡈\n" +
                "⢈⠔⡐⠨⡈⡂⠌⡐⠨⢐⢀⢊⠐⠄⢣⠃⢈⡀⡡⣈⠠⠈⢨⠣⣛⣌⠬⠳⠛⡣⠩⠉⠔⡠⢙⢷⢽⢵⡳⡽⡵⣳⢯⣳⣻⡪⡯⡯⣫⢯⣫⢯⢯⠂⠄⠅⠌⡐⠠⢙\n" +
                "⡐⡐⠨⢐⠠⠂⠅⠌⠌⡐⡐⢐⠨⠈⠌⢯⡁⢈⠈⠠⠉⡉⢡⢩⡻⡌⢏⠉⡉⠘⡌⠌⡐⢐⠠⠹⣳⢽⡺⣽⢽⢽⢵⡳⣵⣫⢯⣫⢯⣳⢽⢵⡻⡌⠄⠅⡂⠂⠅⡂\n" +
                "⡂⣂⣑⣐⣨⣈⣌⣰⣡⣢⣰⣰⣬⣨⣬⣸⣢⠂⠈⡆⡁⠄⡏⡄⡳⣜⢰⠀⢢⠁⠘⢆⢲⢑⢙⢾⢽⢽⢽⢵⢯⢯⣳⡻⣺⣪⢷⣫⢗⣗⢯⡳⡯⣟⢤⢁⠂⠅⡁⡂\n" +
                "⢂⢿⣿⡿⡿⣟⡿⣟⡯⢿⠿⡻⠾⡯⡿⡽⡎⡆⢁⠸⡀⠄⠸⢇⠯⡸⢎⡆⠘⡄⢁⠘⡎⢓⢊⠫⢓⢯⣗⣯⣳⣫⢞⡾⡵⣯⡳⣝⣗⡽⣳⣫⢯⢗⣝⢦⠨⢐⢀⢢\n" +
                "⠄⡇⡢⢱⠉⠒⢪⡂⡊⡢⡑⢌⢊⠢⡑⡰⡹⣊⣠⣀⣁⣐⣈⣈⣀⣂⡠⣐⡀⡌⡀⢄⢱⢐⠠⠨⢐⠐⢗⠷⣵⣫⢯⢯⣫⣞⣞⡗⣗⠽⠵⢓⢫⢇⡗⣕⢧⢂⠒⡁\n" +
                "⢁⢺⠨⡊⡆⠁⢸⡐⡑⠔⢌⠢⡡⡑⢌⠢⢩⠩⡑⡕⡑⡑⡑⡑⡑⢒⠑⠕⡑⡃⡋⡓⢛⠠⠨⢈⢐⠨⢘⡔⡀⢂⠩⠁⠅⡐⡀⡂⠄⠅⠌⡐⣸⢽⢨⡞⡎⡯⣲⢲\n" +
                "⠂⠌⡇⡢⠣⡊⢎⠢⣑⢅⣕⣑⡔⣌⣢⣑⣅⢕⢔⢵⠠⢂⢐⠠⢂⠂⠅⡡⢂⠐⠄⡂⠢⠨⠨⢐⠐⡨⢐⠸⡐⠠⠈⠌⡐⡀⡂⠄⠅⠌⡐⢠⠳⡣⣳⢕⡝⡮⡪⡧\n" +
                "⠁⠅⡛⢛⠛⠫⠛⠝⠎⡓⡚⢒⠓⡓⢊⠒⡊⢃⠋⠕⡑⢐⢐⠨⢐⠨⠐⠄⠅⡊⠔⠨⢐⢁⠊⠔⠨⢐⢐⠨⠸⡬⠬⠴⠰⠰⠤⠕⠜⢒⠊⠅⡂⠹⡕⡧⡫⡮⣳⢹\n" +
                "⢈⢂⠂⠢⠨⠨⢈⠌⡐⡐⢐⢐⠐⠄⠅⠌⠄⠅⡊⠔⠨⢐⠠⢊⢐⠨⢈⠌⡐⠄⠅⡑⡐⠠⠡⠡⢑⠐⡀⡊⡐⢹⠈⡊⡉⠊⠅⠍⡊⠢⠉⠍⡈⣢⢟⢎⡗⡽⣸⢵\n" +
                "⠦⢔⠬⠬⢔⠥⡢⠬⡔⢤⠥⡢⢬⠢⡥⠥⠥⠥⡢⠥⠥⡆⡎⢦⠲⡪⡲⡚⡖⡳⢳⠲⡲⡓⡗⢞⠖⢞⢲⢒⢓⢕⢻⢜⢎⡏⣏⠯⣽⢍⠫⣏⢯⢺⡪⣳⡹⣪⡳⣕\n");
    }

    void init() {
        loginImg();
        System.out.println("=".repeat(80));
        sortTitle("[로그인]");
        System.out.println("-".repeat(80));
//        System.out.println("[로그인]");
        while (true) {
            printLoginMenu();
            String command = Prompt.input(">");
            try {
                int menuNo = Integer.parseInt(command);
                String menuTitle = getloginMenuTitle(menuNo, loginMenus);
                if (menuTitle == null) {
                    System.out.println("유효한 메뉴가 아닙니다.");
                } else {
                    switch (menuTitle) {
                        case "로그인":
                            User user = Login.loginUser();
                            if (!(user == null)) {
                                mainMenu.execute(user);
                            } else {
                                System.out.println("횟수 초과 - 초기화면으로 돌아갑니다.");
                            }
                            break;
                        case "회원가입":
                            Login.authUser();
                            break;
                        case "비밀번호 찾기":
                            Login.reSetUserPassword();
                            break;
                        case "종료":
                            System.out.println("시스템을 종료합니다.");
                            System.exit(0);
                        default:
                            System.out.println("없는 메뉴입니다.");
                            break;
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("숫자로 메뉴 번호를 입력하세요.");
            }
        }
    }

//    private void processLogin(String menuTitle) {
//        switch (menuTitle) {
//            case "로그인":
//                User user = Login.loginUser();
//                if (!(user == null)) {
//                    mainMenu.execute(user);
//                } else {
//                    System.out.println("횟수 초가 - 초기화면으로 돌아갑니다.");
//                    break;
//                }
//            case "회원가입":
//                Login.authUser();
//                break;
//            case "비밀번호 분실":
//                Login.reSetUserPassword();
//                break;
//            case "종료":
//                System.out.println("시스템을 종료합니다.");
//                System.exit(0);
//            default:
//                System.out.println("없는 메뉴입니다.");
//                break;
//        }
//    }

    boolean isvalidatemenu(int menuNo, String[] loginMenus) {

        return menuNo >= 1 && menuNo <= loginMenus.length;
    }

    String getloginMenuTitle(int menuNo, String[] loginMenus) {
        return isvalidatemenu(menuNo, loginMenus) ? loginMenus[menuNo - 1] : null;
    }

    private void printLoginMenu() {
        int count = 1;
        for (String menu : loginMenus) {
            sortCLI(count++, menu);
        }
    }

    private void sortTitle(String text){
        // 터미널 너비 (고정된 값으로 가정, 일반적인 터미널 너비는 80)
        int terminalWidth = 78;

        // 텍스트 길이
        int textLength = text.length();

        // 가운데 정렬을 위해 앞에 추가할 공백의 수 계산
        int padding = (terminalWidth - textLength) / 2;

        // 공백 생성
        StringBuilder menu = new StringBuilder();
        menu.append(" ".repeat(Math.max(0, padding)));

        // 텍스트 추가
        menu.append(text);
        // 출력
        System.out.println(menu);
    }

    private void sortCLI(int count, String text){
        // 터미널 너비 (고정된 값으로 가정, 일반적인 터미널 너비는 80)
        int terminalWidth = 78;

        String st = String.format("%d. %s",  count, text);
        // 텍스트 길이
        int textLength = st.length();

        // 가운데 정렬을 위해 앞에 추가할 공백의 수 계산
        int padding = (terminalWidth - textLength) / 2;

        // 공백 생성
        StringBuilder menu = new StringBuilder();
        menu.append(" ".repeat(Math.max(0, padding)));

        // 텍스트 추가
        menu.append(st);
        // 출력
        System.out.println(menu);
    }
}
