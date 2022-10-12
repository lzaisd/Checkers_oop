package ru.vsu.csf.piit.checkers.board;


public class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position (String s) {
        char letter = s.charAt(0);
        char number = s.charAt(1);

        switch (letter) {
            case 'A', 'a': {
                this.col = 0;
                break;
            }
            case 'B', 'b': {
                this.col = 1;
                break;
            }
            case 'C', 'c': {
                this.col = 2;
                break;
            }
            case 'D', 'd': {
                this.col = 3;
                break;
            }
            case 'E', 'e': {
                this.col = 4;
                break;
            }
            case 'F', 'f': {
                this.col = 5;
                break;
            }
            case 'G', 'g': {
                this.col = 6;
                break;
            }
            case 'H', 'h': {
                this.col = 7;
                break;
            }
        }

        this.row = Character.getNumericValue(number) - 1;
    }

    public int getRow() {
        return row;
    }


    public int getCol() {
        return col;
    }


    public boolean checkPosition(){
        return this.row <= 7 && this.col <= 7 && this.col >= 0 && this.row >= 0;
    }

}
