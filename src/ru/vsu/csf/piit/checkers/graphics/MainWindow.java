package ru.vsu.csf.piit.checkers.graphics;

import javax.swing.*;

public class MainWindow extends JFrame {
    private DrawPanel dp;

    public MainWindow() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);

        dp = new DrawPanel();
        this.add(dp);
    }
}
