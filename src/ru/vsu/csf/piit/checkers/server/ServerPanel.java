package ru.vsu.csf.piit.checkers.server;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.graphics.BoardDrawer;
import ru.vsu.csf.piit.checkers.graphics.DrawPanel;

import java.awt.*;

public class ServerPanel extends DrawPanel {
    public ServerGame game;
    private ServerGameModel sgm;

    public ServerPanel() {
        this.board = new Board();
        this.game = new ServerGame();
        this.sgm = new ServerGameModel(board, cellSize);
    }
    @Override
    protected void paintComponent(Graphics g) {
        BoardDrawer bd = new BoardDrawer(board, cellSize);
        bd.draw(g);

        this.addMouseListener(sgm);
        repaint();
    }
    public Position getCurrPos(){
        if (this.sgm.getCurrPos() != null) {
            return this.sgm.getCurrPos();
        } else return null;
    }
    public void setCurrPos(Position p){
        this.sgm.setCurrPos(p);
    }
}
