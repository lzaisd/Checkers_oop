package ru.vsu.csf.piit.checkers.board;

import ru.vsu.csf.piit.checkers.checker.Color;
import ru.vsu.csf.piit.checkers.checker.Checker;
import ru.vsu.csf.piit.checkers.checker.King;

import java.util.ArrayList;

import static ru.vsu.csf.piit.checkers.checker.Color.*;

public class Board {

    Cell[][] cellArr;
    public int whiteAmount, blackAmount;

    public final ArrayList<Cell>[] diagonals = new ArrayList[11];

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
        initDiagonals();
    }
    private void initDiagonals() {
        int r, c, k;
        for (r = this.getRows() / 2 , c = 0, k = 0; r > 0 || c < this.getCols() - 2; k++) {
            this.diagonals[k] = initDiagonal(r, c, true);
            if ((r) >= 2) {
                r -= 2;
            } else {
                r = 0;
                c+=2;
            }
        }
        for (r = this.getRows() / 2 + 1, c = this.getCols() - 1; r > 0 || c > 0; k++) {
            this.diagonals[k] = initDiagonal(r, c, false);
            if ((r) > 1) {
                r -= 2;
            } else if (r == 1){
                r = 0;
                c -= 1;
            } else {
                c -= 2;
            }
        }
    }
    private ArrayList<Cell> initDiagonal(int startRow, int startCol, boolean isRight) {
        int r;
        int c;
        ArrayList<Cell> diagonal = new ArrayList<>();
        if (isRight) {
            for (r = startRow, c = startCol; r < this.getRows() && c < this.getCols(); r++, c++) {
                diagonal.add(this.getCellArr()[r][c]);
            }
        } else {
            for (r = startRow, c = startCol; r < this.getCellArr().length && c >= 0; r++, c--) {
                diagonal.add(this.getCellArr()[r][c]);
            }
        }

        return diagonal;
    }

    public PosVector move(PosVector vector, Color c){
        PosVector pv = getCellByPos(vector.start).getChecker().beat(c);
        if (pv == null) {
            pv = getCellByPos(vector.start).getChecker().move(getCellByPos(vector.finish), c);
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

    public int getRows() {
        return this.getCellArr().length;
    }

    public int getCols() {
        return this.getCellArr()[0].length;
    }
}