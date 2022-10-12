package ru.vsu.csf.piit.checkers.board;

import ru.vsu.csf.piit.checkers.checker.Checker;
import ru.vsu.csf.piit.checkers.checker.Color;

public class Cell {
    public final Color color;
    private Checker checker;
    public final Position pos;

    public Cell(Color color, Checker checker, Position pos) {
        this.color = color;
        this.checker = checker;
        this.pos = pos;
    }

    public Checker getChecker() {
        return checker;
    }

    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Position getPos() {
        return pos;
    }
}
