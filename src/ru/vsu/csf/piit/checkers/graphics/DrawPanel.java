package ru.vsu.csf.piit.checkers.graphics;

import ru.vsu.csf.piit.checkers.board.*;
import ru.vsu.csf.piit.checkers.checker.Color;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    protected Board board;
    protected final int cellSize = 50;
    protected Color currColor = Color.WHITE;
    private GameModel gm;
    private BoardDrawer bd;


    public DrawPanel() {
        this.board = new Board();
        this.gm = new GameModel(board, currColor, cellSize);
        this.bd = new BoardDrawer(board, cellSize);
        this.addMouseListener(gm);
    }

    @Override
    protected void paintComponent(Graphics g) {
        bd.draw(g);
        repaint();
    }
}
