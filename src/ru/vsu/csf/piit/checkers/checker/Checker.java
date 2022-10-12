package ru.vsu.csf.piit.checkers.checker;

import ru.vsu.csf.piit.checkers.board.Position;

public class Checker {

    Position pos;
    public final Color color;

    public Checker(Position pos, Color color) {
        this.pos = pos;
        this.color = color;
    }
}
