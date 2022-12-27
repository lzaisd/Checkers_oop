package ru.vsu.csf.piit.checkers.server;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.graphics.BoardDrawer;
import ru.vsu.csf.piit.checkers.graphics.DrawPanel;

import java.awt.*;

public class ServerPanel extends DrawPanel {
    private ServerGameModel sgm;
    private BoardDrawer bd;
    private Board board;

    public ServerPanel() {
        this.board = new Board();
        this.sgm = new ServerGameModel(board, cellSize);
        this.bd = new BoardDrawer(board, cellSize);
        this.addMouseListener(sgm);
    }
    @Override
    protected void paintComponent(Graphics g) {
        bd.draw(g);
    }
    public Position getCurrPos(){
        return sgm.getCurrPos();
    }
    public void setCurrPos(Position p){
        this.sgm.setCurrPos(p);
    }
}
