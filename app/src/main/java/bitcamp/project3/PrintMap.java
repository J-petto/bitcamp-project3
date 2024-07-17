package bitcamp.project3;

import java.util.Stack;

public class PrintMap {
    String ansiBlue = "\u001B[34m";
    String ansiEnd = "\u001B[0m";
    String boldAnsi = "\033[1m";

    public void printBox(Stack<String> menuPath, String title) {

        if (menuPath.size() < 3) {
            if (!menuPath.getLast().equals(title)) {
                switch (title) {
                    case "계단":
                        printStair();
                        break;
                    case "왼쪽 통로":
                        printLeft();
                        break;
                    case "오른쪽 통로":
                        printRight();
                        break;
                }
            } else {
                switch (title) {
                    case "로비":
                        printLobby();
                        break;
                    case "계단":
                        printKorean();
                        break;
                    case "왼쪽 통로":
                        printMedia();
                        break;
                    case "오른쪽 통로":
                        printOther();
                        break;
                }
            }
        } else {
            String mainPath = menuPath.get(1);
            String subPath = menuPath.getLast();

            switch (mainPath) {
                case "계단" -> {
                    switch (subPath) {
                        case "인문학":
                            printKoreaHumanities();
                            break;
                        case "경제":
                            printKoreaEconomy();
                            break;
                        case "과학":
                            printKoreaScience();
                            break;
                        case "자기계발":
                            printKoreaSelfHelp();
                            break;
                    }
                }
                case "왼쪽 통로" -> {
                    printMediaCD();
                }
                case "오른쪽 통로" -> {
                    switch (subPath) {
                        case "인문학":
                            printOtherHumanities();
                            break;
                        case "경제":
                            printOtherEconomy();
                            break;
                        case "과학":
                            printOtherScience();
                            break;
                        case "자기계발":
                            printOtherSelfHelp();
                            break;
                    }
                }
            }
        }
    }


    private void printLobby() {
        System.out.println("╔═══════════════════════════════════════════════════════════════  🚪 ═════╗");
        System.out.println("║          ╔═════════╗                                          ║ ↑↑ ║    ║");
        System.out.println("║          ║ 🪟  🪟 ║                                                    ║");
        System.out.println("║          ╚═════════╝                                                    ║");
        System.out.println("║                                                      ╔═════════╗        ║");
        System.out.println("║               ╔════╗       ╔═════╗       ╔════╗      ║ 🧑🏻‍💻👨🏼‍💻   ║        ║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║    ║      ╚═══╗     ║        ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║ 📚 ║          ║     ║        ║");
        System.out.println("║════           ║ 📚 ║       ║ 📚 ║       ║    ║          ╚═════╝    ════║");
        System.out.println("║🚪 <-          ║    ║       ║    ║       ║    ║                    -> 🚪║");
        System.out.println("║════           ║    ║       ║ 📚 ║       ║    ║                      ════║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║ 📚 ║                         ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║     ║                         ║");
        System.out.println("║               ╚════╝       ║    ║        ╚════╝                          ║");
        System.out.println("║                            ║ 📚 ║                                       ║");
        System.out.println("║      ╔═════════╗           ╚════╝                                        ║");
        System.out.println("║      ║ 🖥️  🖥️ ║                                                         ║");
        System.out.println("║      ║ ⌨️  ⌨️ ║              " + ansiBlue + boldAnsi + "YOU" + ansiEnd + "                                        ║");
        System.out.println("║      ╚═════════╝                                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
    }

    private void printStair() {
        printEmpty();
        System.out.println("╔═══════════════════════════════════════════════════════════════  🚪 ═════╗");
        System.out.println("║          ╔═════════╗                                          ║ ↑↑ ║     ║");
        System.out.println("║          ║ 🪟  🪟 ║                                           " + ansiBlue + boldAnsi + "YOU" + ansiEnd + "      ║");
        System.out.println("║          ╚═════════╝                                                     ║");
        System.out.println("║                                                      ╔═════════╗         ║");
        System.out.println("║               ╔════╗       ╔═════╗       ╔════╗      ║ 🧑🏻‍💻👨🏼‍💻   ║        ║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║    ║      ╚═══╗     ║        ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║ 📚 ║          ║     ║        ║");
        System.out.println("║════           ║ 📚 ║       ║ 📚 ║       ║    ║          ╚═════╝    ════║");
        System.out.println("║🚪 <-          ║    ║       ║    ║       ║    ║                    -> 🚪║");
        System.out.println("║════           ║    ║       ║ 📚 ║       ║    ║                      ════║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║ 📚 ║                         ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║     ║                         ║");
        System.out.println("║               ╚════╝       ║    ║        ╚════╝                          ║");
        System.out.println("║                            ║ 📚 ║                                       ║");
        System.out.println("║      ╔═════════╗           ╚════╝                                        ║");
        System.out.println("║      ║ 🖥️  🖥️ ║                                                         ║");
        System.out.println("║      ║ ⌨️  ⌨️ ║                                                         ║");
        System.out.println("║      ╚═════════╝                                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
    }

    private void printRight() {
        printEmpty();
        System.out.println("╔═══════════════════════════════════════════════════════════════  🚪 ═════╗");
        System.out.println("║          ╔═════════╗                                          ║ ↑↑ ║     ║");
        System.out.println("║          ║ 🪟  🪟 ║                                                    ║");
        System.out.println("║          ╚═════════╝                                                    ║");
        System.out.println("║                                                      ╔═════════╗        ║");
        System.out.println("║               ╔════╗       ╔═════╗       ╔════╗      ║ 🧑🏻‍💻👨🏼‍💻   ║        ║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║    ║      ╚═══╗     ║        ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║ 📚 ║          ║     ║        ║");
        System.out.println("║════           ║ 📚 ║       ║ 📚 ║       ║    ║          ╚═════╝    ════║");
        System.out.println("║🚪 <-          ║    ║       ║    ║       ║    ║                " + ansiBlue + boldAnsi + "YOU" + ansiEnd + " -> 🚪║");
        System.out.println("║════           ║    ║       ║ 📚 ║       ║    ║                      ════║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║ 📚 ║                         ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║     ║                         ║");
        System.out.println("║               ╚════╝       ║    ║        ╚════╝                          ║");
        System.out.println("║                            ║ 📚 ║                                       ║");
        System.out.println("║      ╔═════════╗           ╚════╝                                        ║");
        System.out.println("║      ║ 🖥️  🖥️ ║                                                         ║");
        System.out.println("║      ║ ⌨️  ⌨️ ║                                                         ║");
        System.out.println("║      ╚═════════╝                                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
    }

    private void printLeft() {
        printEmpty();
        System.out.println("╔═══════════════════════════════════════════════════════════════  🚪 ═════╗");
        System.out.println("║          ╔═════════╗                                          ║ ↑↑ ║    ║");
        System.out.println("║          ║ 🪟  🪟 ║                                                    ║");
        System.out.println("║          ╚═════════╝                                                    ║");
        System.out.println("║                                                      ╔═════════╗        ║");
        System.out.println("║               ╔════╗       ╔═════╗       ╔════╗      ║ 🧑🏻‍💻👨🏼‍💻   ║        ║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║    ║      ╚═══╗     ║        ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║ 📚 ║          ║     ║        ║");
        System.out.println("║════           ║ 📚 ║       ║ 📚 ║       ║    ║          ╚═════╝    ════║");
        System.out.println("║🚪 <-  " + ansiBlue + boldAnsi + "YOU" + ansiEnd + "     ║    ║       ║    ║       ║    ║                    -> 🚪║");
        System.out.println("║════           ║    ║       ║ 📚 ║       ║    ║                      ════║");
        System.out.println("║               ║ 📚 ║       ║ 📚 ║       ║ 📚 ║                         ║");
        System.out.println("║               ║ 📚 ║       ║    ║       ║     ║                         ║");
        System.out.println("║               ╚════╝       ║    ║        ╚════╝                          ║");
        System.out.println("║                            ║ 📚 ║                                       ║");
        System.out.println("║      ╔═════════╗           ╚════╝                                        ║");
        System.out.println("║      ║ 🖥️  🖥️ ║                                                         ║");
        System.out.println("║      ║ ⌨️  ⌨️ ║                                                         ║");
        System.out.println("║      ╚═════════╝                                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════╝");
    }

    private void printKorean() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════╗        ╔═════════════════════════════════════╗        ║");
        System.out.println("║          ║ 🪟  🪟 ║        ║                        Study zone   ║        ║");
        System.out.println("║          ╚═════════╝        ║                                     ║        ║");
        System.out.println("║                             ╚═════════════════════════════════════╝        ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                   " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "                                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printOther() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════════════════════════════════╗        ╔═════════╗        ║");
        System.out.println("║          ║                        Study zone   ║        ║ 🪟  🪟 ║        ║");
        System.out.println("║          ║                                     ║        ╚═════════╝        ║");
        System.out.println("║          ╚═════════════════════════════════════╝                           ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                     " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "                                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printMedia() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║            🖥️            ║            🖥       🖥      🖥       🖥      ║");
        System.out.println("║                           ║         ════════════════════════════════════   ║");
        System.out.println("║        👧🏻      👩🏻‍💻        ║                                                ║");
        System.out.println("║        🧒🏼      👦🏻        ║                                          ╔═════║");
        System.out.println("║                           ║          ═══════════════════════════      ║    ║");
        System.out.println("║═══════════════════════════┤             🖥       🖥      🖥         ║ 💿 ║");
        System.out.println("║            🖥️            ║          ═══════════════════════════      ║ 💿 ║");
        System.out.println("║                           ║                                           ║ 💿 ║");
        System.out.println("║                           ║                                           ║     ║");
        System.out.println("║       Media Room 2        ║                                           ║ 💿 ║");
        System.out.println("║                           ║                                           ║     ║");
        System.out.println("║                           ║                                           ║ 💿 ║");
        System.out.println("║═══════════════════════════┤                                           ║ 💿 ║");
        System.out.println("║            🖥            ║                                           ╚═════║");
        System.out.println("║                           ║                                                ║");
        System.out.println("║       Media Room 3        ║                                                ║");
        System.out.println("║                           ║                                                ║");
        System.out.println("║                           ║                       " + ansiBlue + boldAnsi + "YOU" + ansiEnd + "                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printKoreaHumanities() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════╗        ╔═════════════════════════════════════╗        ║");
        System.out.println("║          ║ 🪟  🪟 ║        ║                        Study zone   ║        ║");
        System.out.println("║          ╚═════════╝        ║                                     ║        ║");
        System.out.println("║                             ╚═════════════════════════════════════╝        ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║             " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printKoreaEconomy() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════╗        ╔═════════════════════════════════════╗        ║");
        System.out.println("║          ║ 🪟  🪟 ║        ║                        Study zone   ║        ║");
        System.out.println("║          ╚═════════╝        ║                                     ║        ║");
        System.out.println("║                             ╚═════════════════════════════════════╝        ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                            " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "             ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printKoreaScience() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════╗        ╔═════════════════════════════════════╗        ║");
        System.out.println("║          ║ 🪟  🪟 ║        ║                        Study zone   ║        ║");
        System.out.println("║          ╚═════════╝        ║                                     ║        ║");
        System.out.println("║                             ╚═════════════════════════════════════╝        ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║             " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printKoreaSelfHelp() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════╗        ╔═════════════════════════════════════╗        ║");
        System.out.println("║          ║ 🪟  🪟 ║        ║                        Study zone   ║        ║");
        System.out.println("║          ╚═════════╝        ║                                     ║        ║");
        System.out.println("║                             ╚═════════════════════════════════════╝        ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                            " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "             ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printOtherHumanities() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════════════════════════════════╗        ╔═════════╗        ║");
        System.out.println("║          ║                        Study zone   ║        ║ 🪟  🪟 ║        ║");
        System.out.println("║          ║                                     ║        ╚═════════╝        ║");
        System.out.println("║          ╚═════════════════════════════════════╝                           ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║              " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "                                                           ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printOtherEconomy() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════════════════════════════════╗        ╔═════════╗        ║");
        System.out.println("║          ║                        Study zone   ║        ║ 🪟  🪟 ║        ║");
        System.out.println("║          ║                                     ║        ╚═════════╝        ║");
        System.out.println("║          ╚═════════════════════════════════════╝                           ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                             " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printOtherScience() {
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════════════════════════════════╗        ╔═════════╗        ║");
        System.out.println("║          ║                        Study zone   ║        ║ 🪟  🪟 ║        ║");
        System.out.println("║          ║                                     ║        ╚═════════╝        ║");
        System.out.println("║          ╚═════════════════════════════════════╝                           ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║              " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "                                                           ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printOtherSelfHelp() {
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          ╔═════════════════════════════════════╗        ╔═════════╗        ║");
        System.out.println("║          ║                        Study zone   ║        ║ 🪟  🪟 ║        ║");
        System.out.println("║          ║                                     ║        ╚═════════╝        ║");
        System.out.println("║          ╚═════════════════════════════════════╝                           ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                            ╔═══════════════╗      ║");
        System.out.println("║        ║  📚  📚  📚 ║                            ║  📚  📚  📚 ║      ║");
        System.out.println("║        ╚═══════════════╝                            ╚═══════════════╝      ║");
        System.out.println("║                                                           " + ansiBlue + boldAnsi +"YOU" + ansiEnd + "              ║");
        System.out.println("║                                                                            ║");
        System.out.println("║        ╔═══════════════╗                             ╔═══════════════╗     ║");
        System.out.println("║        ║  📚  📚  📚 ║                             ║  📚  📚  📚 ║     ║");
        System.out.println("║        ╚═══════════════╝                             ╚═══════════════╝     ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("║                                                                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printMediaCD(){
        printEmpty();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║            🖥️            ║            🖥       🖥      🖥       🖥      ║");
        System.out.println("║                           ║         ════════════════════════════════════   ║");
        System.out.println("║        👧🏻      👩🏻‍💻        ║                                                ║");
        System.out.println("║        🧒🏼      👦🏻        ║                                          ╔═════║");
        System.out.println("║                           ║          ═══════════════════════════      ║    ║");
        System.out.println("║═══════════════════════════┤             🖥       🖥      🖥         ║ 💿 ║");
        System.out.println("║            🖥️            ║          ═══════════════════════════      ║ 💿 ║");
        System.out.println("║                           ║                                           ║ 💿 ║");
        System.out.println("║                           ║                                           ║     ║");
        System.out.println("║       Media Room 2        ║                                      " + ansiBlue + boldAnsi + "YOU" + ansiEnd + "  ║ 💿 ║");
        System.out.println("║                           ║                                           ║     ║");
        System.out.println("║                           ║                                           ║ 💿 ║");
        System.out.println("║═══════════════════════════┤                                           ║ 💿 ║");
        System.out.println("║            🖥            ║                                           ╚═════║");
        System.out.println("║                           ║                                                ║");
        System.out.println("║       Media Room 3        ║                                                ║");
        System.out.println("║                           ║                                                ║");
        System.out.println("║                           ║                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }

    private void printEmpty() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}



