package ru.vsu.csf.piit.checkers.console;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.Cell;
import ru.vsu.csf.piit.checkers.board.PosVector;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.checker.Color;


import java.util.Scanner;

import static ru.vsu.csf.piit.checkers.checker.Color.BLACK;
import static ru.vsu.csf.piit.checkers.checker.Color.WHITE;

public class ConsoleGame {
    private static Board board = new Board();

    public static void startGameInConsole() {
        while (true) {
            board.outputBoard();
            System.out.println("\n     ??? ?????");
            move(input(), WHITE);

            if (board.blackAmount == 0) {
                System.out.println("\n???? ?????????. ???????? ?????! \n");
                break;
            }

            board.outputBoard();
            System.out.println("\n     ??? ??????");
            move(input(), BLACK);

            if (board.whiteAmount == 0) {
                System.out.println("\n???? ?????????. ???????? ??????! \n");
                break;
            }
        }

    }

    private static void move(PosVector vector, Color c) {
        while (board.move(vector, c) == null) {
            System.out.println("\n????? ??? ??????????! \n");
            vector = input();
        }
        System.out.println("??? ?? " + vector.getStart() + " ? " + vector.getFinish());
    }

    private static PosVector input() {
        String strStartPos = consoleInputStartPosition();
        String strFinishPos = consoleInputFinishPosition();
        Position posStart = new Position(strStartPos);
        Position posFinish = new Position(strFinishPos);
        while (!checkStrPosition(strStartPos) || !checkStrPosition(strFinishPos) || !posStart.checkPosition() || !posFinish.checkPosition()) {
            System.out.println("\n??????? ??????? ???????, ????????? ????! \n");
            strStartPos = consoleInputStartPosition();
            strFinishPos = consoleInputFinishPosition();
            posStart = new Position(strStartPos);
            posFinish = new Position(strFinishPos);
        }
        return new PosVector(posStart, posFinish);
    }

    private static String consoleInputStartPosition() {
        Scanner in = new Scanner(System.in);
        System.out.print("????? ????? ?? ???????: ");
        return in.nextLine();
    }

    private static String consoleInputFinishPosition() {
        Scanner in = new Scanner(System.in);
        System.out.print("????? ????? ?? ???????: ");
        return in.nextLine();
    }

    private static boolean checkStrPosition(String strPos) {
        return strPos.length() == 2;
    }

}
