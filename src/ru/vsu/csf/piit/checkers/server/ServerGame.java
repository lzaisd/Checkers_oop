package ru.vsu.csf.piit.checkers.server;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.PosVector;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.checker.Color;

public class ServerGame {
    private Board board;
    private Color currColor;
    private PosVector currMove = new PosVector();

    public ServerGame() {
        this.board = new Board();
        this.currColor = Color.WHITE;
    }

    public Board getBoard() {
        return board;
    }

    public void move(Position pos) {
        if (pos.checkPosition()) {
            if (board.cellContainsChecker(pos.getRow(), pos.getCol())) {
                currMove.setStart(pos);
                currMove.setFinish(null);
            } else if (currMove.getStart() != null) {
                currMove.setFinish(pos);
                if (board.move(currMove, currColor) != null) {
                    currColor = currColor == Color.WHITE ? Color.BLACK : Color.WHITE;
                    printMove();
                    currMove.setNull();
                }
            }
        }
    }

    public void printMove(){
        System.out.println("Move from " + currMove.getStart() + " to " + currMove.getFinish());
    }

    public Color getCurrColor() {
        return currColor;
    }
}
