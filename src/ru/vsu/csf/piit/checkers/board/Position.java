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

        char l = 'A';
        for (int n = 0; n < 8; n ++, l++) {
            if (Character.toUpperCase(letter) == l) {
                this.col = n;
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

    @Override
    public String toString() {
        String r = String.valueOf(row + 1);
        char c = 0;
        int n = 0;
        for (char l = 'A'; l <= 'H'; l++, n++) {
            if (col == n) {
                c = l;
            }
        }

        return c + r;
    }

    public boolean checkPosition(){
        return this.row <= 7 && this.col <= 7 && this.col >= 0 && this.row >= 0;
    }

}
