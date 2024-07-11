package bitcamp.project3;

public class PrintMap {
    public void printBox(int width, int height) {
        printLine(width);
        for (int i = 0; i < height - 2; i++) {
            printMiddleLine(width);
        }
        printLine(width);
    }

    private void printLine(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("■");
        }
        System.out.println();
    }

    private void printMiddleLine(int width) {
        System.out.print("■");
        for (int i = 0; i < width - 2; i++) {
            System.out.print(" ");
        }
        System.out.print("■");
        System.out.println();
    }
}
