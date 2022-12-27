package ru.vsu.csf.piit.checkers.server;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.PosVector;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.checker.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientMouseListener extends MouseAdapter {
    private Board board;
    private int cellSize;
    private Position currPos = null;

    public ClientMouseListener(Board board, int cellSize) {
        this.board = board;
        this.cellSize = cellSize;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.board.getLength() - e.getY() / cellSize;
        int col = e.getX() / cellSize - 3;

        currPos = new Position(row, col);
    }
    public Position getCurrPos(){
        return currPos;
    }
    public void setCurrPos(Position p){
        currPos = p;
    }
    public Board getBoard() {
        return board;
    }
}
