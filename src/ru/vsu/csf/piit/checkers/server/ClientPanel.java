package ru.vsu.csf.piit.checkers.server;

import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.checker.Color;
import ru.vsu.csf.piit.checkers.graphics.BoardDrawer;
import ru.vsu.csf.piit.checkers.graphics.GameModel;

import javax.swing.*;
import java.awt.*;

public class ClientPanel extends JPanel {
    private Board board;
    private final int cellSize = 50;
    private BoardDrawer bd;
    private ClientMouseListener listener;

    public ClientPanel() {
        this.board = new Board();
        this.bd = new BoardDrawer(board, cellSize);
        this.listener = new ClientMouseListener(board, cellSize);
        this.addMouseListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        bd.draw(g);
        repaint();
    }

    public ClientMouseListener getListener() {
        return listener;
    }
    public Position getCurrPos(){
        return listener.getCurrPos();
    }
    public void setCurrPos(Position p){
        this.listener.setCurrPos(p);
    }
}
