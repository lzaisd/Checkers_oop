package ru.vsu.csf.piit.checkers.graphics;

import ru.vsu.csf.piit.checkers.board.*;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Board board;
    private final int cellSize = 50;
    private final int startPosX = 50;
    private final int startPosY = 50;


    public DrawPanel() {
        this.board = new Board();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(197, 197, 197));
        g.fillRect(0, 0, getWidth(), getHeight());

        writePos(g);
        drawBoard(g);
    }

    private void writePos(Graphics g) {
        g.setColor(Color.BLACK);
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
        for (int row = 0; row < this.board.getLength(); row++) {
            for (int col = 0; col < this.board.getLength(); col++) {
                g.setColor(this.board.getCellArr()[row][col].getColor());
                g.fillRect((col + 2) * cellSize + this.startPosX, row * cellSize + this.startPosY, cellSize, cellSize);

                if (this.board.getCellArr()[row][col].containsChecker()) {
                    g.setColor(this.board.getCellArr()[row][col].getChecker().getColor());
                    g.fillOval((col + 2) * cellSize + this.startPosX + cellSize/4, row * cellSize + this.startPosY + cellSize/4, cellSize/2, cellSize/2);
                }
            }
        }
    }
}
