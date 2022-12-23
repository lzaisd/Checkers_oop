package ru.vsu.csf.piit.checkers.server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AppClient {
    private final String host;
    private final int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private ServerGame game;

    public AppClient(String host, int port, ServerGame game) {
        this.host = host;
        this.port = port;
        this.game = game;
    }

    public static void main(String[] args) throws IOException {
        ServerGame game = new ServerGame();
        AppClient client = new AppClient("localhost", 1234, game);
        client.start();
    }

    public void start() throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        while (!socket.isClosed()) {
            String command = in.readLine();
            System.out.println("From server: " + command);
            if (command.equals(Command.MAKEMOVEW.getCommandString())) {
                System.out.print("Enter position, white turn: ");
            }
            if (command.equals(Command.MAKEMOVEB.getCommandString())) {
                System.out.print("Enter position, black turn: ");
            }
            String nextLine = new Scanner(System.in).nextLine();
            String answer = Command.MOVE.getCommandString() + " " + nextLine;
            System.out.println("To server: " + answer);
            out.println(answer);
        }
    }
}
