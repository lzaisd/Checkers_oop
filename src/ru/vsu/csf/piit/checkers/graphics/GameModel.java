package ru.vsu.csf.piit.checkers.graphics;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.PosVector;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.checker.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameModel extends MouseAdapter {
    private Board board;
    private Color currColor;
    private int cellSize;
    private PosVector pv = new PosVector();

    public GameModel(Board board, Color currColor, int cellSize) {
        this.board = board;
        this.currColor = currColor;
        this.cellSize = cellSize;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.board.getLength() - e.getY() / cellSize;
        int col = e.getX() / cellSize - 3;

        Position pos = new Position(row, col);

        if (pos.checkPosition()) {
            if (board.cellContainsChecker(row, col)) {
                pv.setStart(pos);
                pv.setFinish(null);
            } else if (pv.getStart() != null) {
                pv.setFinish(pos);
                if (board.move(pv, currColor) != null) {
                    currColor = currColor == Color.WHITE ? Color.BLACK : Color.WHITE;
                    pv.setNull();
                }
            }
        }
    }
}
