package ru.vsu.csf.piit.checkers.checker;

import ru.vsu.csf.piit.checkers.board.*;

import static ru.vsu.csf.piit.checkers.checker.Color.WHITE;

public class King extends Checker {

    public King(Position pos, Color color, Board board) {
        super(pos, color, board);
    }

    @Override
    public PosVector move(Cell finish, Color c) {
        PosVector moveVector = getMoveVector(finish, c);
        if (moveVector != null){
            if (moveVector instanceof PosVectorBeat) {  //todo: удалить PosVectorBeat, в PosVector сделать поле Position posOfBeaten и конструктор без него, оно null
                board.getCellByPos(((PosVectorBeat) moveVector).posOfBeaten).setChecker(null);
            }
            board.getCellByPos(this.pos).setChecker(null);
            this.pos = finish.getPos();
            board.getCellByPos(moveVector.getFinish()).setChecker(this);
            return moveVector;
        } else return null;
    }

    @Override
    public PosVectorBeat beat(Color c) {
        return null;
    }

    private PosVector getMoveVector(Cell finish, Color c) {
        PosVector posVector = new PosVector(this.pos, finish.pos);

        if (!finish.containsChecker() && this.color == c && finish.pos.getCol() - this.pos.getCol() == finish.pos.getRow() - this.pos.getRow()) {
            int sideCoef = (finish.pos.getCol() - this.pos.getCol()) / Math.abs(this.pos.getCol() - finish.pos.getCol());
            int upCoef = (finish.pos.getRow() - this.pos.getRow()) / Math.abs(this.pos.getRow() - finish.pos.getRow());
            Cell currCell = this.board.getCellByPos(new Position(this.pos.getRow() + upCoef, this.pos.getCol() +sideCoef));
            int checkerAmount = 0;

            while (this.board.getCellByPos(new Position(currCell.pos.getRow() + upCoef, currCell.pos.getCol() + sideCoef)) != null) { //todo пока след. €чейка != €чейке финиша
                if (currCell.containsChecker() && c != currCell.getChecker().color) { //todo отдельна€ проверка цвета если c == currCell.getChecker().color то return null;
                    posVector = new PosVectorBeat(posVector.getStart(), posVector.getFinish(), currCell.pos);
                    checkerAmount ++;
                }
                if (checkerAmount > 1) {
                    return null;
                }
                currCell = this.board.getCellByPos(new Position(currCell.pos.getRow() + upCoef, currCell.pos.getCol() + sideCoef));
            }

            return posVector;
        } else return null;
    }

    @Override
    public java.awt.Color getColor() {
        if (this.color == Color.WHITE) {
            return new java.awt.Color(255, 219, 219);
        } else return new java.awt.Color(7, 26, 0);
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
