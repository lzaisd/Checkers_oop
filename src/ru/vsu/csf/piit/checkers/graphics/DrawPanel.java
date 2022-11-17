package ru.vsu.csf.piit.checkers.graphics;

import ru.vsu.csf.piit.checkers.board.*;
import ru.vsu.csf.piit.checkers.checker.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawPanel extends JPanel implements MouseListener {
    private Board board;
    private final int cellSize = 50;
    private final int startPosX = 50;
    private final int startPosY = 50;
    private Position start = null;
    private Position finish = null;
    Color currColor = Color.WHITE;


    public DrawPanel() {
        this.board = new Board();
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new java.awt.Color(197, 197, 197));
        g.fillRect(0, 0, getWidth(), getHeight());

        writePos(g);
        drawBoard(g);
    }

    private void writePos(Graphics g) {
        g.setColor(java.awt.Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, cellSize / 2));
        char l = 'A';
        for (int n = 1; n <= this.board.getLength(); n++, l++) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, cellSize * 5 / 8));
            g.drawString(String.valueOf(this.board.getLength() + 1 - n), cellSize + this.startPosX, n * cellSize - cellSize/3 + this.startPosY);
            g.setFont(new Font("TimesRoman", Font.BOLD, cellSize / 2));
            g.drawString(String.valueOf(l), n * cellSize + cellSize * 5 /4 + this.startPosX, 9 * cellSize + this.startPosY);
        }
    }

    private void drawBoard(Graphics g) {
        for (int row = this.board.getLength() - 1; row >= 0; row--) {
            for (int col = 0; col < this.board.getLength(); col++) {
                g.setColor(this.board.getCellArr()[row][col].getColor());
                g.fillRect((col + 2) * cellSize + this.startPosX, (this.board.getLength() - row - 1) * cellSize + this.startPosY, cellSize, cellSize);

                if (this.board.getCellArr()[row][col].containsChecker()) {
                    g.setColor(this.board.getCellArr()[row][col].getChecker().getColor());
                    g.fillOval((col + 2) * cellSize + this.startPosX + cellSize/4, (this.board.getLength() - row - 1) * cellSize + this.startPosY + cellSize/4, cellSize/2, cellSize/2);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.board.getLength() - e.getY()/cellSize;
        int col = e.getX()/cellSize - 3;

        Position pos = new Position(row, col);
        if (pos.checkPosition()) {
            if (this.start == null) {
                start = pos;
            } else {
                finish = pos;
                if (board.move(new PosVector(start, finish), currColor) != null) {
                   currColor = currColor == Color.WHITE ? Color.BLACK : Color.WHITE;
                }
                start = null;
                finish = null;
                }
        } else {
            start = null;
            finish = null;
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
