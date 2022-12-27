package ru.vsu.csf.piit.checkers.server;


import ru.vsu.csf.piit.checkers.board.Board;
import ru.vsu.csf.piit.checkers.board.PosVector;
import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.graphics.DrawPanel;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AppClient extends JFrame {
    private final String host;
    private final int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private ClientPanel panel;


    public AppClient(String host, int port, ClientPanel panel) {
        this.host = host;
        this.port = port;
        this.panel = panel;
    }

    public static void main(String[] args) throws IOException {
        ClientPanel clientPanel = new ClientPanel();
        AppClient client = new AppClient("localhost", 1234, clientPanel);
        client.start();
    }
    private void drawClientPanel(ClientPanel clientPanel){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        add(clientPanel);
        addMouseListener(clientPanel.getListener());
        setVisible(true);
    }

    public void start() throws IOException {
        drawClientPanel(panel);

        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        while (!socket.isClosed()) {
            String command = in.readLine();
            System.out.println("From server: " + command);

            Position curr = panel.getCurrPos();
            if (command.equals(Command.MAKEMOVE_W.getCommandString()) || command.equals(Command.MAKEMOVE_B.getCommandString())) {

                while (curr == null) {
                    curr = panel.getCurrPos();
                }

            }

            String answer = Command.MOVE.getCommandString() + " " + curr;
            System.out.println("To server: " + answer);
            out.println(answer);
            panel.setCurrPos(null);
        }
    }
}
