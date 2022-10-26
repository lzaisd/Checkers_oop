package ru.vsu.csf.piit.checkers.board;

public class PosVectorBeat extends PosVector{
    public Position posOfBeaten;

    public PosVectorBeat(Position start, Position finish, Position posOfBeaten) {
        super(start, finish);
        this.posOfBeaten = posOfBeaten;
    }
}
