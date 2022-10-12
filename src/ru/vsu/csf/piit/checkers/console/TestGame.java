package ru.vsu.csf.piit.checkers.console;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.Cell;
import ru.vsu.csf.piit.checkers.board.Position;

public class TestGame {
    public static void startGameInConsole() {
        Board board = new Board();


        board.outputBoard();
        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "g3", "h4");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "h6", "g5");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "a3", "b4");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "g5", "f4");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "a3", "b4");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "f6", "e5");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "g5", "h6");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "e5", "d4");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "a3", "b4");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "e5", "d4");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "f2", "g3");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "g7", "f6");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "f2", "g3");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "f6", "e5");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "d2", "c3");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "h8", "g7");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "d2", "c3");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "e7", "d6");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "b2", "a3");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "f8", "e7");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "c1", "b2");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "c7", "d6");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "c1", "b2");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "b6", "a5");
        board.outputBoard();

        System.out.println("\n     Ход белых");
        inputAndMove(true, board, "c1", "b2");
        board.outputBoard();

        System.out.println("\n     Ход черных");
        inputAndMove(false, board, "b6", "a5");
        board.outputBoard();
    }

    private static void inputAndMove(boolean currColorIsWhite, Board board, String strStartPos, String strFinishPos) {
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

            Position posStart = new Position(strStartPos);
            Position posFinish = new Position(strFinishPos);
            board.move(board.getCellByPosition(posStart), board.getCellByPosition(posFinish), currColorIsWhite);
        }
    }
}
