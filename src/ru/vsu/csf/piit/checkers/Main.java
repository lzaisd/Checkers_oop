package ru.vsu.csf.piit.checkers;

import ru.vsu.csf.piit.checkers.console.ConsoleGame;
import ru.vsu.csf.piit.checkers.graphics.MainWindow;

public class Main {

    public static void main(String[] args) {
//        ConsoleGame.startGameInConsole();
        MainWindow mv  = new MainWindow();
        mv.setVisible(true);
    }

}
