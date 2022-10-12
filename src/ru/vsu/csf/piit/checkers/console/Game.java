package ru.vsu.csf.piit.checkers.console;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.Cell;
import ru.vsu.csf.piit.checkers.board.Position;


import java.util.Scanner;

public class Game {

    public static void startGameInConsole() {
        Board board = new Board();

        while (true) {
            board.outputBoard();
            System.out.println("\n     Ход белых");
            inputAndMove(true, board);

            if (board.blackAmount == 0) {
                System.out.println("\nИгра завершена. Победили белые! \n");
                break;
            }

            board.outputBoard();
            System.out.println("\n     Ход черных");
            inputAndMove(false, board);

            if (board.whiteAmount == 0) {
                System.out.println("\nИгра завершена. Победили чёрные! \n");
                break;
            }
        }

    }

    private static void inputAndMove(boolean currColorIsWhite, Board board) {
        if (board.kingAppeared) {
            Cell[] startFinish = new Cell[3];
            if (board.checkDiagonalsForKing(currColorIsWhite) != null && board.checkDiagonalsForKing(currColorIsWhite)[2] != null) {
                System.out.print("\nБудет автоматически произведён бьющий ход дамкой.\n");
                board.beatKing(startFinish, currColorIsWhite);
            }
        } else if (board.checkRightUpDiagonals(currColorIsWhite) != null && board.canBeatUpRight(board.checkRightUpDiagonals(currColorIsWhite), currColorIsWhite)) {
            System.out.print("\nБудет автоматически произведён бьющий ход.\n");
            board.beatUpRight(board.getCellByPosition(board.checkRightUpDiagonals(currColorIsWhite).getPos()), currColorIsWhite);
        } else if (board.checkLeftUpDiagonals(currColorIsWhite) != null && board.canBeatUpLeft(board.checkLeftUpDiagonals(currColorIsWhite), currColorIsWhite)) {
            System.out.print("\nБудет автоматически произведён бьющий ход.\n");
            board.beatUpLeft(board.getCellByPosition(board.checkLeftUpDiagonals(currColorIsWhite).getPos()), currColorIsWhite);
        } else if (board.checkRightDownDiagonals(currColorIsWhite) != null && board.canBeatDownRight(board.checkRightDownDiagonals(currColorIsWhite), currColorIsWhite)) {
            System.out.print("\nБудет автоматически произведён бьющий ход.\n");
            board.beatDownRight(board.getCellByPosition(board.checkRightDownDiagonals(currColorIsWhite).getPos()), currColorIsWhite);
        } else if (board.checkLeftDownDiagonals(currColorIsWhite) != null && board.canBeatDownLeft(board.checkLeftDownDiagonals(currColorIsWhite), currColorIsWhite)) {
            System.out.print("\nБудет автоматически произведён бьющий ход.\n");
            board.beatDownLeft(board.getCellByPosition(board.checkLeftDownDiagonals(currColorIsWhite).getPos()), currColorIsWhite);
        } else {
            String strStartPos = consoleInputStartPosition();
            String strFinishPos = consoleInputFinishPosition();
            while (!checkStrPosition(strStartPos) || !checkStrPosition(strFinishPos)) {
                System.out.println("\nПозиции введены неверно, повторите ввод! \n");
                strStartPos = consoleInputStartPosition();
                strFinishPos = consoleInputFinishPosition();
            }

            Position posStart = new Position(strStartPos);
            Position posFinish = new Position(strFinishPos);
            while (!board.move(board.getCellByPosition(posStart), board.getCellByPosition(posFinish), currColorIsWhite) || !posStart.checkPosition() || !posFinish.checkPosition()) {
                System.out.print("\nВ такую позицию или из такой позиции невозможно ходить, повторите ввод!\n");
                strStartPos = consoleInputStartPosition();
                strFinishPos = consoleInputFinishPosition();
                posStart = new Position(strStartPos);
                posFinish = new Position(strFinishPos);
            }
        }
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

}
