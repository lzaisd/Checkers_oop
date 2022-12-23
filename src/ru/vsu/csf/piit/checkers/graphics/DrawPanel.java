package ru.vsu.csf.piit.checkers.graphics;

import ru.vsu.csf.piit.checkers.board.*;
import ru.vsu.csf.piit.checkers.checker.Color;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Board board;
    private final int cellSize = 50;
    Color currColor = Color.WHITE;


    public DrawPanel() {
        this.board = new Board();
    }

    @Override
    protected void paintComponent(Graphics g) {
        BoardDrawer bd = new BoardDrawer(board, cellSize);
        bd.draw(g);

        GameModel gm = new GameModel(board, currColor, cellSize);
        this.addMouseListener(gm);
        repaint();
    }
}
