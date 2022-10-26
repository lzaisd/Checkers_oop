package ru.vsu.csf.piit.checkers.checker;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.Position;

import static ru.vsu.csf.piit.checkers.checker.Color.WHITE;

public class King extends Checker {

    public King(Position pos, Color color, Board board) {
        super(pos, color, board);
    }

    @Override
    public String checkerToString() {
        if (this.color == WHITE) {
            return "W ";
        } else {
            return "B ";
        }
    }
}
