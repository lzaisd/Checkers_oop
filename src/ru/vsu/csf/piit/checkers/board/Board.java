package ru.vsu.csf.piit.checkers.board;

import ru.vsu.csf.piit.checkers.checker.Color;
import ru.vsu.csf.piit.checkers.checker.Checker;
import ru.vsu.csf.piit.checkers.checker.King;

import static ru.vsu.csf.piit.checkers.checker.Color.*;

public class Board {  // функция доски - двигать шашки

    Cell[][] cellArr;
    public int whiteAmount, blackAmount;

    private final Cell[]  rightE1H4;
    private final Cell[]  rightC1H6;
    private final Cell[]  rightA1H8;
    private final Cell[]  rightA3F8;
    private final Cell[]  rightA5D8;

    private final Cell[]  leftC1A3;
    private final Cell[]  leftE1A5;
    private final Cell[]  leftG1A7;
    private final Cell[]  leftH2B8;
    private final Cell[]  leftH4D8;
    private final Cell[]  leftH6F8;

    public boolean kingAppeared = false;



    public Board() {
        this.whiteAmount = 12;
        this.blackAmount = 12;

        this.cellArr = new Cell[][]{
                {new Cell(BLACK, new Checker(new Position("A1"), WHITE), new Position("A1")), new Cell(WHITE, null, new Position("B1")), new Cell(BLACK, new Checker(new Position("C1"), WHITE), new Position("C1")), new Cell(WHITE, null, new Position("D1")), new Cell(BLACK, new Checker(new Position("E1"), WHITE), new Position("E1")), new Cell(WHITE, null, new Position("F1")), new Cell(BLACK, new Checker(new Position("G1"), WHITE), new Position("G1")), new Cell(WHITE, null, new Position("H1"))},
                {new Cell(WHITE, null, new Position("A2")), new Cell(BLACK, new Checker(new Position("B2"), WHITE), new Position("B2")), new Cell(WHITE, null, new Position("C2")), new Cell(BLACK, new Checker(new Position("D2"), WHITE), new Position("D2")), new Cell(WHITE, null, new Position("E2")), new Cell(BLACK, new Checker(new Position("F2"), WHITE), new Position("F2")), new Cell(WHITE, null, new Position("G2")), new Cell(BLACK, new Checker(new Position("H2"), WHITE), new Position("H2"))},
                {new Cell(BLACK, new Checker(new Position("A3"), WHITE), new Position("A3")), new Cell(WHITE, null, new Position("B3")), new Cell(BLACK, new Checker(new Position("C3"), WHITE), new Position("C3")), new Cell(WHITE, null, new Position("D3")), new Cell(BLACK, new Checker(new Position("E3"), WHITE), new Position("E3")), new Cell(WHITE, null, new Position("F3")), new Cell(BLACK, new Checker(new Position("G3"), WHITE), new Position("G3")), new Cell(WHITE, null, new Position("H3"))},
                {new Cell(WHITE, null, new Position("A4")), new Cell(BLACK, null, new Position("B4")), new Cell(WHITE, null, new Position("C4")), new Cell(BLACK, null, new Position("D4")), new Cell(WHITE, null, new Position("E4")), new Cell(BLACK, null, new Position("F4")), new Cell(WHITE, null, new Position("G4")), new Cell(BLACK, null, new Position("H4"))},
                {new Cell(BLACK, null, new Position("A5")), new Cell(WHITE, null, new Position("B5")), new Cell(BLACK, null, new Position("C5")), new Cell(WHITE, null, new Position("D5")), new Cell(BLACK, null, new Position("E5")), new Cell(WHITE, null, new Position("F5")), new Cell(BLACK, null, new Position("G5")), new Cell(WHITE, null, new Position("H5"))},
                {new Cell(WHITE, null, new Position("A6")), new Cell(BLACK, new Checker(new Position("B6"), BLACK), new Position("B6")), new Cell(WHITE, null, new Position("C6")), new Cell(BLACK, new Checker(new Position("D6"), BLACK), new Position("D6")), new Cell(WHITE, null, new Position("E6")), new Cell(BLACK, new Checker(new Position("F6"), BLACK), new Position("F6")), new Cell(WHITE, null, new Position("G6")), new Cell(BLACK, new Checker(new Position("H6"), BLACK), new Position("H6"))},
                {new Cell(BLACK, new Checker(new Position("A7"), BLACK), new Position("A7")), new Cell(WHITE, null, new Position("B7")), new Cell(BLACK, new Checker(new Position("C7"), BLACK), new Position("C7")), new Cell(WHITE, null, new Position("D7")), new Cell(BLACK, new Checker(new Position("E7"), BLACK), new Position("E7")), new Cell(WHITE, null, new Position("F7")), new Cell(BLACK, new Checker(new Position("G7"), BLACK), new Position("G7")), new Cell(WHITE, null, new Position("H7"))},
                {new Cell(WHITE, null, new Position("A8")), new Cell(BLACK, new Checker(new Position("B8"), BLACK), new Position("B8")), new Cell(WHITE, null, new Position("C8")), new Cell(BLACK, new Checker(new Position("D8"), BLACK), new Position("D8")), new Cell(WHITE, null, new Position("E8")), new Cell(BLACK, new Checker(new Position("F8"), BLACK), new Position("F8")), new Cell(WHITE, null, new Position("G8")), new Cell(BLACK, new Checker(new Position("H8"), BLACK), new Position("H8"))}
        };

        this.rightE1H4 = new Cell[]{
                getCellByPosition(new Position("E1")),
                getCellByPosition(new Position("F2")),
                getCellByPosition(new Position("G3")),
                getCellByPosition(new Position("H4"))
        };
        this.rightC1H6 = new Cell[]{
                getCellByPosition(new Position("C1")),
                getCellByPosition(new Position("D2")),
                getCellByPosition(new Position("E3")),
                getCellByPosition(new Position("F4")),
                getCellByPosition(new Position("G5")),
                getCellByPosition(new Position("H6"))
        };
        this.rightA1H8 = new Cell[]{
                getCellByPosition(new Position("A1")),
                getCellByPosition(new Position("B2")),
                getCellByPosition(new Position("C3")),
                getCellByPosition(new Position("D4")),
                getCellByPosition(new Position("E5")),
                getCellByPosition(new Position("F6")),
                getCellByPosition(new Position("G7")),
                getCellByPosition(new Position("H8"))
        };
        this.rightA3F8 = new Cell[]{
                getCellByPosition(new Position("A3")),
                getCellByPosition(new Position("B4")),
                getCellByPosition(new Position("C5")),
                getCellByPosition(new Position("D6")),
                getCellByPosition(new Position("E7")),
                getCellByPosition(new Position("F8"))
        };
        this.rightA5D8 = new Cell[]{
                getCellByPosition(new Position("A5")),
                getCellByPosition(new Position("B6")),
                getCellByPosition(new Position("C7")),
                getCellByPosition(new Position("D8"))
        };
        this.leftC1A3 = new Cell[]{
                getCellByPosition(new Position("C1")),
                getCellByPosition(new Position("B2")),
                getCellByPosition(new Position("A3"))
        };
        this.leftE1A5 = new Cell[]{
                getCellByPosition(new Position("E1")),
                getCellByPosition(new Position("D2")),
                getCellByPosition(new Position("C3")),
                getCellByPosition(new Position("B4")),
                getCellByPosition(new Position("A5"))
        };
        this.leftG1A7 = new Cell[]{
                getCellByPosition(new Position("G1")),
                getCellByPosition(new Position("F2")),
                getCellByPosition(new Position("E3")),
                getCellByPosition(new Position("D4")),
                getCellByPosition(new Position("C5")),
                getCellByPosition(new Position("B6")),
                getCellByPosition(new Position("A7"))
        };
        this.leftH2B8 = new Cell[]{
                getCellByPosition(new Position("H2")),
                getCellByPosition(new Position("G3")),
                getCellByPosition(new Position("F4")),
                getCellByPosition(new Position("E5")),
                getCellByPosition(new Position("D6")),
                getCellByPosition(new Position("C7")),
                getCellByPosition(new Position("B8"))
        };
        this.leftH4D8 = new Cell[]{
                getCellByPosition(new Position("H4")),
                getCellByPosition(new Position("G5")),
                getCellByPosition(new Position("F6")),
                getCellByPosition(new Position("E7")),
                getCellByPosition(new Position("D8"))
        };
        this.leftH6F8 = new Cell[]{
                getCellByPosition(new Position("H6")),
                getCellByPosition(new Position("G7")),
                getCellByPosition(new Position("F8"))
        };
    }

    public boolean move(Cell start, Cell finish, boolean currColorIsWhite){
        if (canMove(start, finish, currColorIsWhite)) {
            if (currColorIsWhite && start.getChecker().color == WHITE && finish.pos.getRow() == 7) {
                finish.setChecker(new King(new Position(finish.pos.getRow(), finish.pos.getCol()), WHITE));
                this.kingAppeared = true;
            } else if (!currColorIsWhite && start.getChecker().color == BLACK && finish.pos.getRow() == 0){
                finish.setChecker(new King(new Position(finish.pos.getRow(), finish.pos.getCol()), BLACK));
                this.kingAppeared = true;
            } else {
                finish.setChecker(start.getChecker());
            }
            start.setChecker(null);
            return true;
        } else return false;
    }

    public Cell checkRightUpDiagonals(boolean currColorIsWhite) {
        Color c = (currColorIsWhite)? WHITE : BLACK;
        if (checkUpDiagonal(c, this.rightE1H4) != null) {
            return checkUpDiagonal(c, this.rightE1H4);
        } else if (checkUpDiagonal(c, this.rightC1H6) != null){
            return checkUpDiagonal(c, this.rightC1H6);
        } else if (checkUpDiagonal(c, this.rightA1H8) != null){
            return checkUpDiagonal(c, this.rightA1H8);
        } else if (checkUpDiagonal(c, this.rightA3F8) != null){
            return checkUpDiagonal(c, this.rightA3F8);
        } else if (checkUpDiagonal(c, this.rightA5D8) != null){
            return checkUpDiagonal(c, this.rightA5D8);
        } else return null;
    }
    public Cell checkLeftUpDiagonals(boolean currColorIsWhite) {
        Color c = (currColorIsWhite)? WHITE : BLACK;
        if (checkUpDiagonal(c, this.leftC1A3) != null){
            return checkUpDiagonal(c, this.leftC1A3);
        } else if (checkUpDiagonal(c, this.leftE1A5) != null){
            return checkUpDiagonal(c, this.leftE1A5);
        } else if (checkUpDiagonal(c, this.leftG1A7) != null){
            return checkUpDiagonal(c, this.leftG1A7);
        } else if (checkUpDiagonal(c, this.leftH2B8) != null){
            return checkUpDiagonal(c, this.leftH2B8);
        } else if (checkUpDiagonal(c, this.leftH4D8) != null){
            return checkUpDiagonal(c, this.leftH4D8);
        }  else if (checkUpDiagonal(c, this.leftH6F8) != null){
            return checkUpDiagonal(c, this.leftH6F8);
        } else return null;
    }

    private Cell checkUpDiagonal(Color c, Cell[] arr) {
        int cellNum;
        for (cellNum = 0; cellNum < arr.length - 2; cellNum ++) {
            if (containsChecker(arr[cellNum]) &&
                containsChecker(arr[cellNum+1]) &&
                c != arr[cellNum + 1].getChecker().color &&
                c == arr[cellNum].getChecker().color) {
                return arr[cellNum];
            }
        }
        return null;
    }

    public Cell checkRightDownDiagonals(boolean currColorIsWhite) {
        Color c = (currColorIsWhite)? WHITE : BLACK;
        if (checkDownDiagonal(c, this.leftC1A3) != null){
            return checkDownDiagonal(c, this.leftC1A3);
        } else if (checkDownDiagonal(c, this.leftE1A5) != null){
            return checkDownDiagonal(c, this.leftE1A5);
        } else if (checkDownDiagonal(c, this.leftG1A7) != null){
            return checkDownDiagonal(c, this.leftG1A7);
        } else if (checkDownDiagonal(c, this.leftH2B8) != null){
            return checkDownDiagonal(c, this.leftH2B8);
        } else if (checkDownDiagonal(c, this.leftH4D8) != null){
            return checkDownDiagonal(c, this.leftH4D8);
        }  else if (checkDownDiagonal(c, this.leftH6F8) != null){
            return checkDownDiagonal(c, this.leftH6F8);
        } else return null;
    }
    public Cell checkLeftDownDiagonals(boolean currColorIsWhite) {
        Color c = (currColorIsWhite)? WHITE : BLACK;
        if (checkDownDiagonal(c, this.rightE1H4) != null) {
            return checkDownDiagonal(c, this.rightE1H4);
        } else if (checkDownDiagonal(c, this.rightC1H6) != null){
            return checkDownDiagonal(c, this.rightC1H6);
        } else if (checkDownDiagonal(c, this.rightA1H8) != null){
            return checkDownDiagonal(c, this.rightA1H8);
        } else if (checkDownDiagonal(c, this.rightA3F8) != null){
            return checkDownDiagonal(c, this.rightA3F8);
        } else if (checkDownDiagonal(c, this.rightA5D8) != null){
            return checkDownDiagonal(c, this.rightA5D8);
        } else return null;
    }


    private Cell checkDownDiagonal(Color c, Cell[] arr) {
        int cellNum;
        for (cellNum = arr.length - 1; cellNum > 1; cellNum --) {
            if (containsChecker(arr[cellNum]) &&
                    containsChecker(arr[cellNum-1]) &&
                    c != arr[cellNum - 1].getChecker().color &&
                    c == arr[cellNum].getChecker().color) {
                return arr[cellNum];
            }
        }
        return null;
    }

    private Cell[] checkUpDiagonalForKing(Color c, Cell[] arr) { //с - нынешний цвет, 0-король, 1-шашка, 2-финиш
        int cellNum;
        int cellNumNew;
        Cell[] startFinish = new Cell[3];
        for (cellNum = 0; cellNum < arr.length - 2; cellNum ++) {
            if (containsChecker(arr[cellNum])  &&
                arr[cellNum].getChecker() instanceof King &&
                arr[cellNum].getChecker().color == c) {
                startFinish[0] = arr[cellNum];
                for (cellNumNew = cellNum + 1; cellNumNew < arr.length - 2; cellNumNew ++) {
                    if (containsChecker(arr[cellNumNew]) && arr[cellNumNew].getChecker().color == c) {
                        break;
                    }
                    if (containsChecker(arr[cellNumNew]) && arr[cellNumNew].getChecker().color != c) {
                        startFinish[1] = arr[cellNumNew];
                        startFinish[2] = arr[cellNumNew + 1];
                        break;
                    }
                }
            }
        }
        return startFinish;
    }

    private Cell[] checkDownDiagonalForKing(Color c, Cell[] arr) {
        int cellNum;
        int cellNumNew;
        Cell[] startFinish = new Cell[3];
        for (cellNum = arr.length - 1; cellNum > 2; cellNum --) {
            if (containsChecker(arr[cellNum])  &&
                    arr[cellNum].getChecker() instanceof King &&
                    arr[cellNum].getChecker().color == c) {
                startFinish[0] = arr[cellNum];
                for (cellNumNew = cellNum - 1; cellNumNew > 2; cellNumNew --) {
                    if (containsChecker(arr[cellNumNew]) && arr[cellNumNew].getChecker().color == c) {
                        break;
                    }
                    if (containsChecker(arr[cellNumNew]) && arr[cellNumNew].getChecker().color != c) {
                        startFinish[1] = arr[cellNumNew];
                        startFinish[2] = arr[cellNumNew - 1];
                        break;
                    }
                }
            }
        }
        return startFinish;
    }

    public void beatKing(Cell[] startFinish, boolean currColorIsWhite) {
        cellArr[startFinish[2].pos.getRow()][startFinish[2].pos.getCol()].setChecker(cellArr[startFinish[0].pos.getRow()][startFinish[0].pos.getCol()].getChecker());
        cellArr[startFinish[0].pos.getRow()][startFinish[0].pos.getCol()].setChecker(null);
        cellArr[startFinish[1].pos.getRow()][startFinish[1].pos.getCol()].setChecker(null);
        if (currColorIsWhite) {
            this.blackAmount --;
        } else {
            this.whiteAmount --;
        }
    }

    public Cell[] checkDiagonalsForKing(boolean currColorIsWhite) {
        Color c = (currColorIsWhite)? WHITE : BLACK;
        if (checkDownDiagonalForKing(c, this.leftC1A3)[0] != null){
            return checkDownDiagonalForKing(c, this.leftC1A3);
        } else if (checkDownDiagonalForKing(c, this.leftE1A5)[0] != null){
            return checkDownDiagonalForKing(c, this.leftE1A5);
        } else if (checkDownDiagonalForKing(c, this.leftG1A7)[0] != null){
            return checkDownDiagonalForKing(c, this.leftG1A7);
        } else if (checkDownDiagonalForKing(c, this.leftH2B8)[0] != null){
            return checkDownDiagonalForKing(c, this.leftH2B8);
        } else if (checkDownDiagonalForKing(c, this.leftH4D8)[0] != null){
            return checkDownDiagonalForKing(c, this.leftH4D8);
        }  else if (checkDownDiagonalForKing(c, this.leftH6F8)[0] != null){
            return checkDownDiagonalForKing(c, this.leftH6F8);
        } else if (checkDownDiagonalForKing(c, this.rightE1H4)[0] != null) {
            return checkDownDiagonalForKing(c, this.rightE1H4);
        } else if (checkDownDiagonalForKing(c, this.rightC1H6)[0] != null){
            return checkDownDiagonalForKing(c, this.rightC1H6);
        } else if (checkDownDiagonalForKing(c, this.rightA1H8)[0] != null){
            return checkDownDiagonalForKing(c, this.rightA1H8);
        } else if (checkDownDiagonalForKing(c, this.rightA3F8)[0] != null){
            return checkDownDiagonalForKing(c, this.rightA3F8);
        } else if (checkDownDiagonalForKing(c, this.rightA5D8)[0] != null){
            return checkDownDiagonalForKing(c, this.rightA5D8);
        } else if (checkUpDiagonalForKing(c, this.leftC1A3)[0] != null){
            return checkUpDiagonalForKing(c, this.leftC1A3);
        } else if (checkUpDiagonalForKing(c, this.leftE1A5)[0] != null){
            return checkUpDiagonalForKing(c, this.leftE1A5);
        } else if (checkUpDiagonalForKing(c, this.leftG1A7)[0] != null){
            return checkUpDiagonalForKing(c, this.leftG1A7);
        } else if (checkUpDiagonalForKing(c, this.leftH2B8)[0] != null){
            return checkUpDiagonalForKing(c, this.leftH2B8);
        } else if (checkUpDiagonalForKing(c, this.leftH4D8)[0] != null){
            return checkUpDiagonalForKing(c, this.leftH4D8);
        }  else if (checkUpDiagonalForKing(c, this.leftH6F8)[0] != null){
            return checkUpDiagonalForKing(c, this.leftH6F8);
        } else if (checkUpDiagonalForKing(c, this.rightE1H4)[0] != null) {
            return checkUpDiagonalForKing(c, this.rightE1H4);
        } else if (checkUpDiagonalForKing(c, this.rightC1H6)[0] != null){
            return checkUpDiagonalForKing(c, this.rightC1H6);
        } else if (checkUpDiagonalForKing(c, this.rightA1H8)[0] != null){
            return checkUpDiagonalForKing(c, this.rightA1H8);
        } else if (checkUpDiagonalForKing(c, this.rightA3F8)[0] != null){
            return checkUpDiagonalForKing(c, this.rightA3F8);
        } else if (checkUpDiagonalForKing(c, this.rightA5D8)[0] != null){
            return checkUpDiagonalForKing(c, this.rightA5D8);
        } else return null;
    }


    public void beatUpRight(Cell start, boolean currColorIsWhite) {
        if (currColorIsWhite && this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker().color == WHITE && start.pos.getRow() + 2 == 7) {
            this.cellArr[start.pos.getRow() + 2][start.pos.getCol() + 2].setChecker(new King(new Position(start.pos.getRow() + 2, start.pos.getCol() + 2), WHITE));
            this.kingAppeared = true;
        } else {
            this.cellArr[start.pos.getRow() + 2][start.pos.getCol() + 2].setChecker(this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker());
        }
        this.cellArr[start.pos.getRow()][start.pos.getCol()].setChecker(null);
        this.cellArr[start.pos.getRow() + 1][start.pos.getCol() + 1].setChecker(null);
        if (currColorIsWhite) {
            this.blackAmount --;
        } else {
            this.whiteAmount --;
        }
    }
    public void beatDownRight(Cell start, boolean currColorIsWhite) {
        if (!currColorIsWhite && this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker().color == BLACK && start.pos.getRow() - 2 == 0) {
            this.cellArr[start.pos.getRow() - 2][start.pos.getCol() + 2].setChecker(new King(new Position(start.pos.getRow() - 2, start.pos.getCol() + 2), WHITE));
            this.kingAppeared = true;
        } else {
            this.cellArr[start.pos.getRow() - 2][start.pos.getCol() + 2].setChecker(this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker());
        }
        this.cellArr[start.pos.getRow()][start.pos.getCol()].setChecker(null);
        this.cellArr[start.pos.getRow() - 1][start.pos.getCol() + 1].setChecker(null);
        if (currColorIsWhite) {
            this.blackAmount --;
        } else {
            this.whiteAmount --;
        }
    }
    public void beatUpLeft(Cell start, boolean currColorIsWhite) {
        if (currColorIsWhite && this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker().color == WHITE && start.pos.getRow() + 2 == 7) {
            this.cellArr[start.pos.getRow() + 2][start.pos.getCol() - 2].setChecker(new King(new Position(start.pos.getRow() + 2, start.pos.getCol() - 2), WHITE));
            this.kingAppeared = true;
        } else {
            this.cellArr[start.pos.getRow() + 2][start.pos.getCol() - 2].setChecker(this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker());
        }
        this.cellArr[start.pos.getRow()][start.pos.getCol()].setChecker(null);
        this.cellArr[start.pos.getRow() + 1][start.pos.getCol() - 1].setChecker(null);
        if (currColorIsWhite) {
            this.blackAmount --;
        } else {
            this.whiteAmount --;
        }
    }
    public void beatDownLeft(Cell start, boolean currColorIsWhite) {
        if (!currColorIsWhite && this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker().color == BLACK && start.pos.getRow() - 2 == 0) {
            this.cellArr[start.pos.getRow() - 2][start.pos.getCol() - 2].setChecker(new King(new Position(start.pos.getRow() - 2, start.pos.getCol() - 2), WHITE));
            this.kingAppeared = true;
        } else {
            this.cellArr[start.pos.getRow() - 2][start.pos.getCol() - 2].setChecker(this.cellArr[start.pos.getRow()][start.pos.getCol()].getChecker());
        }
        this.cellArr[start.pos.getRow()][start.pos.getCol()].setChecker(null);
        this.cellArr[start.pos.getRow() - 1][start.pos.getCol() - 1].setChecker(null);
        if (currColorIsWhite) {
            this.blackAmount --;
        } else {
            this.whiteAmount --;
        }
    }


    public boolean canBeatUpRight(Cell start, boolean currColorIsWhite) {
        Color c = (currColorIsWhite) ? BLACK : WHITE;
        return start.pos.getRow() <= 5 && start.pos.getCol() <= 5 &&
               containsChecker( this.cellArr[start.pos.getRow() + 1][start.pos.getCol() + 1]) &&
               this.cellArr[start.pos.getRow() + 1][start.pos.getCol() + 1].getChecker().color == c &&
               !containsChecker(this.cellArr[start.pos.getRow() + 2][start.pos.getCol() + 2]);
    }
    public boolean canBeatDownRight(Cell start, boolean currColorIsWhite) {
        Color c = (currColorIsWhite) ? BLACK : WHITE;
        return start.pos.getRow() >= 2 && start.pos.getCol() <= 5 &&
                containsChecker(this.cellArr[start.pos.getRow() - 1][start.pos.getCol() + 1]) &&
               this.cellArr[start.pos.getRow() - 1][start.pos.getCol() + 1].getChecker().color == c &&
               !containsChecker(this.cellArr[start.pos.getRow() - 2][start.pos.getCol() + 2]);
    }
    public boolean canBeatUpLeft(Cell start, boolean currColorIsWhite) {
        Color c = (currColorIsWhite) ? BLACK : WHITE;
        return start.pos.getRow() <= 5 && start.pos.getCol() >= 2 &&
                containsChecker(this.cellArr[start.pos.getRow() + 1][start.pos.getCol() - 1]) &&
               this.cellArr[start.pos.getRow() + 1][start.pos.getCol() - 1].getChecker().color == c &&
               !containsChecker(this.cellArr[start.pos.getRow() + 2][start.pos.getCol() - 2]);
    }
    public boolean canBeatDownLeft(Cell start, boolean currColorIsWhite) {
        Color c = (currColorIsWhite) ? BLACK : WHITE;
        return start.pos.getRow() >= 2 && start.pos.getCol() >= 2 &&
                containsChecker(this.cellArr[start.pos.getRow() - 1][start.pos.getCol() - 1]) &&
               this.cellArr[start.pos.getRow() - 1][start.pos.getCol() - 1].getChecker().color == c &&
               !containsChecker(this.cellArr[start.pos.getRow() - 2][start.pos.getCol() - 2]);
    }

    private boolean canMove(Cell start, Cell finish, boolean currColorIsWhite) {
        if (containsChecker(start) && !containsChecker(finish)) {
            switch (start.getChecker().color) {
                case WHITE:
                {
                    return (finish.pos.getRow() == start.pos.getRow() + 1 &&
                            (start.pos.getCol() + 1 == finish.pos.getCol() || start.pos.getCol() - 1 == finish.pos.getCol())) &&
                            currColorIsWhite;
                }
                case BLACK: {
                    return (finish.pos.getRow() == start.pos.getRow() - 1 &&
                            (start.pos.getCol() + 1 == finish.pos.getCol() || start.pos.getCol() - 1 == finish.pos.getCol())) &&
                            !currColorIsWhite;
                }
            }
        }
        return true;
    }

    private boolean containsChecker(Cell cell){
        return cell.getChecker() != null;
    }

    public void outputBoard(){
        System.out.print("\n  ");
        char letter;
        int num = 8;

        System.out.print(" ");
        for (letter = 'A'; letter <= 'H'; letter++) {
            System.out.print(letter + " ");
        }
        System.out.print("\n  ");
        for (letter = 0; letter < 16; letter++) {
            System.out.print("_");
        }

        System.out.println();

        for (int row = 7; row >= 0; row--) {
            System.out.print(num + "| ");
            num --;
            for (int col = 0; col < this.cellArr.length; col++) {
                if (this.cellArr[row][col].getChecker() == null) {
                    System.out.print("- ");
                } else if (this.cellArr[row][col].getChecker().color == WHITE) {
                    if (this.cellArr[row][col].getChecker() instanceof King) {
                        System.out.print("W* ");
                    } else {
                        System.out.print("W ");
                    }
                } else {
                    if (this.cellArr[row][col].getChecker() instanceof King) {
                        System.out.print((char)27 +"B* ");
                    } else {
                        System.out.print("B ");
                    }
                }
            }
            System.out.println();
        }
    }

    public Cell getCellByPosition(Position pos){
        return this.cellArr[pos.getRow()][pos.getCol()];
    }
}