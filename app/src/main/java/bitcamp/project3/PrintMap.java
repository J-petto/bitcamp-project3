package bitcamp.project3;

import java.util.Stack;

public class PrintMap {
    private final int width = 60;
    private final int height = 15;

    private final String[][] box = new String[width][height];

    public void printBox(Stack<String> menuPath) {
        switch (menuPath.getLast()){
            case "로비" : printLobby(); break;
            case "계단" : korean(); break;
            case "왼쪽 통로" : printLeft(); break;
            case "오른쪽 통로" : printRight(); break;
        }
    }

    private void printLobby(){
        String stair = "계단";
        printEmpty();

        saveMainBox();

        for(int w = 50; w < 50 + stair.length(); w++){
            box[w][1] = "##";
            box[w][2] = stair;
        }

        for(int h = 0; h < height; h++){
            for(int w = 0; w < width; w++){
                System.out.print(box[w][h]);
            }
            System.out.print("\n");
        }
    }

    private void printStair(){

    }

    private void printRight(){

    }

    private void printLeft(){

    }

    private void saveMainBox(){
        for (int w = 0; w < height; w++) {
            for (int h = 0; h < width; h++) {
                if (w == 0 || w == height - 1) {
                    box[h][w] = "==";
                } else if (h == 0 || h == width - 1) {
                    box[h][w] = "||";
                } else {
                    box[h][w] = "  ";
                }
            }
        }
    }

    private void printMap(String[][] map) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private void printEmpty(){
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public static void korean() {
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════╗        ╔═════════════════════════════════════╗        ║");
        System.out.println("║          ║ 🪟  🪟 ║        ║                        Study zone   ║        ║");
        System.out.println("║          ╚═════════╝        ║                                     ║        ║");
        System.out.println("║                             ╚═════════════════════════════════════╝        ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚  ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚  ║                             ║  📚  📚  📚  ║    ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }


}
