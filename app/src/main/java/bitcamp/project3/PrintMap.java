package bitcamp.project3;

import java.util.Stack;

public class PrintMap {
    private final int width = 60;
    private final int height = 15;

    private final char[][] box = new char[width][height];

    public void printBox(Stack<String> menuPath) {
        switch (menuPath.getLast()){
            case "로비" : printLobby(); break;
            case "계단" : printStair(); break;
            case "왼쪽 통로" : printLeft(); break;
            case "오른쪽 통로" : printRight(); break;
        }
    }

    private void printLobby(){
        String stair = "1.계단";
        saveMainBox();

        for(int w = 50; w < 50 + stair.length(); w++){
            box[w][1] = '#';
            box[w][2] = stair.charAt(w - 50);
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
                    box[h][w] = '=';
                } else if (h == 0 || h == width - 1) {
                    box[h][w] = '|';
                } else {
                    box[h][w] = ' ';
                }
            }
        }
    }

}
