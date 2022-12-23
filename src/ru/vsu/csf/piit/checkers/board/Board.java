package ru.vsu.csf.piit.checkers.board;

import ru.vsu.csf.piit.checkers.checker.Color;
import ru.vsu.csf.piit.checkers.checker.Checker;

import static ru.vsu.csf.piit.checkers.checker.Color.*;

public class Board {

    private Cell[][] cellArr;
    public int whiteAmount, blackAmount;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        this.whiteAmount = 12;
        this.blackAmount = 12;

        this.cellArr = new Cell[][]{
                {new Cell(BLACK, new Checker(new Position("A1"), WHITE, this), new Position("A1")), new Cell(WHITE, null, new Position("B1")), new Cell(BLACK, new Checker(new Position("C1"), WHITE, this), new Position("C1")), new Cell(WHITE, null, new Position("D1")), new Cell(BLACK, new Checker(new Position("E1"), WHITE, this), new Position("E1")), new Cell(WHITE, null, new Position("F1")), new Cell(BLACK, new Checker(new Position("G1"), WHITE, this), new Position("G1")), new Cell(WHITE, null, new Position("H1"))},
                {new Cell(WHITE, null, new Position("A2")), new Cell(BLACK, new Checker(new Position("B2"), WHITE, this), new Position("B2")), new Cell(WHITE, null, new Position("C2")), new Cell(BLACK, new Checker(new Position("D2"), WHITE, this), new Position("D2")), new Cell(WHITE, null, new Position("E2")), new Cell(BLACK, new Checker(new Position("F2"), WHITE, this), new Position("F2")), new Cell(WHITE, null, new Position("G2")), new Cell(BLACK, new Checker(new Position("H2"), WHITE, this), new Position("H2"))},
                {new Cell(BLACK, new Checker(new Position("A3"), WHITE, this), new Position("A3")), new Cell(WHITE, null, new Position("B3")), new Cell(BLACK, new Checker(new Position("C3"), WHITE, this), new Position("C3")), new Cell(WHITE, null, new Position("D3")), new Cell(BLACK, new Checker(new Position("E3"), WHITE, this), new Position("E3")), new Cell(WHITE, null, new Position("F3")), new Cell(BLACK, new Checker(new Position("G3"), WHITE, this), new Position("G3")), new Cell(WHITE, null, new Position("H3"))},
                {new Cell(WHITE, null, new Position("A4")), new Cell(BLACK, null, new Position("B4")), new Cell(WHITE, null, new Position("C4")), new Cell(BLACK, null, new Position("D4")), new Cell(WHITE, null, new Position("E4")), new Cell(BLACK, null, new Position("F4")), new Cell(WHITE, null, new Position("G4")), new Cell(BLACK, null, new Position("H4"))},
                {new Cell(BLACK, null, new Position("A5")), new Cell(WHITE, null, new Position("B5")), new Cell(BLACK, null, new Position("C5")), new Cell(WHITE, null, new Position("D5")), new Cell(BLACK, null, new Position("E5")), new Cell(WHITE, null, new Position("F5")), new Cell(BLACK, null, new Position("G5")), new Cell(WHITE, null, new Position("H5"))},
                {new Cell(WHITE, null, new Position("A6")), new Cell(BLACK, new Checker(new Position("B6"), BLACK, this), new Position("B6")), new Cell(WHITE, null, new Position("C6")), new Cell(BLACK, new Checker(new Position("D6"), BLACK, this), new Position("D6")), new Cell(WHITE, null, new Position("E6")), new Cell(BLACK, new Checker(new Position("F6"), BLACK, this), new Position("F6")), new Cell(WHITE, null, new Position("G6")), new Cell(BLACK, new Checker(new Position("H6"), BLACK, this), new Position("H6"))},
                {new Cell(BLACK, new Checker(new Position("A7"), BLACK, this), new Position("A7")), new Cell(WHITE, null, new Position("B7")), new Cell(BLACK, new Checker(new Position("C7"), BLACK, this), new Position("C7")), new Cell(WHITE, null, new Position("D7")), new Cell(BLACK, new Checker(new Position("E7"), BLACK, this), new Position("E7")), new Cell(WHITE, null, new Position("F7")), new Cell(BLACK, new Checker(new Position("G7"), BLACK, this), new Position("G7")), new Cell(WHITE, null, new Position("H7"))},
                {new Cell(WHITE, null, new Position("A8")), new Cell(BLACK, new Checker(new Position("B8"), BLACK, this), new Position("B8")), new Cell(WHITE, null, new Position("C8")), new Cell(BLACK, new Checker(new Position("D8"), BLACK, this), new Position("D8")), new Cell(WHITE, null, new Position("E8")), new Cell(BLACK, new Checker(new Position("F8"), BLACK, this), new Position("F8")), new Cell(WHITE, null, new Position("G8")), new Cell(BLACK, new Checker(new Position("H8"), BLACK, this), new Position("H8"))}
        };
    }

    public PosVector move(PosVector vector, Color c) {
        PosVector pv = null;
        if (getCellByPos(vector.getStart()).containsChecker() && !(vector.getStart().equalsPos(vector.getFinish()))) {
            pv = getCellByPos(vector.getStart()).getChecker().move(getCellByPos(vector.getFinish()), c);
            if (pv == null){
                pv = getCellByPos(vector.getStart()).getChecker().beat(c);
            }
        }
        return pv;
    }

    public Cell getCellByPos(Position pos) {
        if (pos.checkPosition()) {
            return this.cellArr[pos.getRow()][pos.getCol()];
        } else return null;
    }

    public Cell[][] getCellArr() {
        return cellArr;
    }

    public int getLength() {
        return this.getCellArr().length;
    }

    public boolean cellContainsChecker(int row, int col){
        Cell cell = this.cellArr[row][col];
        return cell.containsChecker();
    }
}