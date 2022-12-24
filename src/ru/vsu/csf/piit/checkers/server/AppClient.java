package ru.vsu.csf.piit.checkers.server;


import ru.vsu.csf.piit.checkers.board.PosVector;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.graphics.DrawPanel;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AppClient extends JFrame {
    private final String host;
    private final int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    ServerPanel dp;

    public AppClient(String host, int port, ServerPanel dp) {
        this.host = host;
        this.port = port;
        this.dp = dp;
    }

    public static void main(String[] args) throws IOException {
        ServerPanel dp = new ServerPanel();
        AppClient client = new AppClient("localhost", 1234, dp);
        client.start();
    }

    public void start() throws IOException {
        drawPanel(dp);

        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        while (!socket.isClosed()) {
            String command = in.readLine();
            System.out.println("From server: " + command);

            if (command.equals(Command.MAKEMOVE_W.getCommandString()) || command.equals(Command.MAKEMOVE_B.getCommandString())) {
                Position curr = dp.getCurrPos();
                while (curr == null){
                    curr = dp.getCurrPos();
                }
                String answer = Command.MOVE.getCommandString() + " " + curr;
                System.out.println("To server: " + answer);
                out.println(answer);
                dp.setCurrPos(null);
            }

            String nextLine = new Scanner(System.in).nextLine();
            String answer = Command.MOVE.getCommandString() + " " + nextLine;
            System.out.println("To server: " + answer);
            out.println(answer);
        }
    }

    private void drawPanel(DrawPanel dp){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        add(dp);
        setVisible(true);
    }

}
