package ru.vsu.csf.piit.checkers.checker;

import ru.vsu.csf.piit.checkers.board.*;

import static ru.vsu.csf.piit.checkers.checker.Color.BLACK;
import static ru.vsu.csf.piit.checkers.checker.Color.WHITE;

public class Checker {

    protected Position pos;
    public final Color color;
    protected final Board board;

    public Checker(Position pos, Color color, Board board) {
        this.pos = pos;
        this.color = color;
        this.board = board;
    }

    public PosVector move(Cell finish, Color c) {  // c - цвет хода
        if (canMove(finish, c)) {
            if (c == WHITE && this.color == WHITE && finish.pos.getRow() == 7) {
                finish.setChecker(new King(finish.pos, WHITE, board));
            } else if (c == BLACK && this.color == BLACK && finish.pos.getRow() == 0) {
                finish.setChecker(new King(finish.pos, BLACK, board));
            } else {
                finish.setChecker(this);
            }
            board.getCellByPos(this.pos).setChecker(null);
            this.pos = finish.getPos();
            return new PosVector(this.pos, finish.pos);
        } else return null;
    }

    private boolean canMove(Cell finish, Color c) {
        if (!finish.containsChecker()) {
            switch (this.color) {
                case WHITE: {
                    return (finish.pos.getRow() == this.pos.getRow() + 1 &&
                            (this.pos.getCol() + 1 == finish.pos.getCol() || this.pos.getCol() - 1 == finish.pos.getCol())) &&
                            c == WHITE;
                }
                case BLACK: {
                    return (finish.pos.getRow() == this.pos.getRow() - 1 &&
                            (this.pos.getCol() + 1 == finish.pos.getCol() || this.pos.getCol() - 1 == finish.pos.getCol())) &&
                            c == BLACK;
                }
            }
        }
        return true;
    }

    public PosVectorBeat beat(Color c) {
        PosVectorBeat vectorBeat = null;
        Position finish;
        for (int upCoef = -1; upCoef <= 1; upCoef+=2) {
            for (int sideCoef = -1; sideCoef <= 1; sideCoef+=2) {
                if (canBeat(upCoef, sideCoef, c)) {
                    finish = new Position(this.pos.getRow() + upCoef * 2, this.pos.getCol() + sideCoef * 2);
                    vectorBeat = new PosVectorBeat(this.pos, finish, new Position(this.pos.getRow() + upCoef, this.pos.getCol() + sideCoef));
                    board.getCellByPos(this.pos).setChecker(null);
                    board.getCellByPos(new Position(this.pos.getRow() + upCoef, this.pos.getCol() + sideCoef)).setChecker(null);
                    this.pos = finish;
                    board.getCellByPos(finish).setChecker(this);
                }
            }
        }
        return vectorBeat;
    }

    private boolean canBeat(int upCoef, int sideCoef, Color c) {
        return this.getCellByCoefs(upCoef, sideCoef) != null &&
                this.getCellByCoefs(upCoef, sideCoef).containsChecker() &&
                this.getCellByCoefs(upCoef, sideCoef).getChecker().color != c &&
                this.getCellByCoefs(upCoef * 2, sideCoef * 2) != null &&
                !this.getCellByCoefs(upCoef * 2, sideCoef * 2).containsChecker();
    }

    private Cell getCellByCoefs(int upCoef, int sideCoef) {
        return this.board.getCellByPos(new Position(this.pos.getRow() + upCoef, this.pos.getCol() + sideCoef));
    }
//todo: исправить this.pos.getRow() на this.getRow() и this.board.getCellByPos() на this.getCellByPos()
    /*public int getRow() {
        return pos.getRow();
    }*/

    public String checkerToString() {
        if (this.color == WHITE) {
            return "w ";
        } else {
            return "b ";
        }
    }
    public java.awt.Color getColor() {
        if (this.color == Color.WHITE) {
            return java.awt.Color.WHITE;
        } else return java.awt.Color.BLACK;
    }
}
