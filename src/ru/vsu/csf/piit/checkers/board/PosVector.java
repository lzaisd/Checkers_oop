package ru.vsu.csf.piit.checkers.board;

public class PosVector {
    private Position start;
    private Position finish;

    public PosVector(Position start, Position finish) {
        this.start = start;
        this.finish = finish;
    }

    public PosVector(){
        this.start = null;
        this.finish = null;
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public Position getFinish() {
        return finish;
    }

    public void setFinish(Position finish) {
        this.finish = finish;
    }
}
