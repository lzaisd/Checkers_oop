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
            outputBoard(board);
            System.out.println("\n     Ход белых");
            move(input(), WHITE);

            if (board.blackAmount == 0) {
                System.out.println("\nИгра завершена. Победили белые! \n");
                break;
            }

            outputBoard(board);
            System.out.println("\n     Ход черных");
            move(input(), BLACK);

            if (board.whiteAmount == 0) {
                System.out.println("\nИгра завершена. Победили чёрные! \n");
                break;
            }
        }

    }

    private static void move(PosVector vector, Color c) {
        while (board.move(vector, c) == null) {
            System.out.println("\nТакой ход невозможен! \n");
            vector = input();
        }
        System.out.println("Ход из " + vector.start + " в " + vector.finish);
    }

    private static PosVector input() {
        String strStartPos = consoleInputStartPosition();
        String strFinishPos = consoleInputFinishPosition();
        Position posStart = new Position(strStartPos);
        Position posFinish = new Position(strFinishPos);
        while (!checkStrPosition(strStartPos) || !checkStrPosition(strFinishPos) || !posStart.checkPosition() || !posFinish.checkPosition()) {
            System.out.println("\nПозиции введены неверно, повторите ввод! \n");
            strStartPos = consoleInputStartPosition();
            strFinishPos = consoleInputFinishPosition();
            posStart = new Position(strStartPos);
            posFinish = new Position(strFinishPos);
        }
        return new PosVector(posStart, posFinish);
    }

    private static String consoleInputStartPosition() {
        Scanner in = new Scanner(System.in);
        System.out.print("Шашка ходит из позиции: ");
        return in.nextLine();
    }

    private static String consoleInputFinishPosition() {
        Scanner in = new Scanner(System.in);
        System.out.print("Шашка ходит на позицию: ");
        return in.nextLine();
    }

    private static boolean checkStrPosition(String strPos) {
        return strPos.length() == 2;
    }

    public static void outputBoard(Board board){
        System.out.print("\n  ");
        char letter;
        int num = 8;

        System.out.print(" ");
        for (letter = 'A'; letter <= 'H'; letter++) {
            System.out.print(letter + " ");
        }
        System.out.print("\n  ");
        for (letter = 0; letter < 16; letter++) {
            System.out.print("_");
        }

        System.out.println();

        for (int row = 7; row >= 0; row--) {
            System.out.print(num + "| ");
            num --;
            for (int col = 0; col < board.getCellArr().length; col++) {
                System.out.print(board.getCellArr()[row][col].cellToString());
            }
            System.out.println();
        }
    }

}
