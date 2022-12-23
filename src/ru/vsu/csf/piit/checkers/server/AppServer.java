package ru.vsu.csf.piit.checkers.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer {
    public static final int DEFAULT_PORT = 1234;
    private final ServerSocket serverSocket;

    public AppServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public static void main(String[] args) {
        try {
            AppServer server = new AppServer(DEFAULT_PORT);
            server.start();
        } catch (IOException e) {
            throw new IllegalStateException("Cannot connect to server", e);
        }
    }

    public void start() throws IOException {
        System.out.println("Game server started on port: " + serverSocket.getLocalPort());
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getInetAddress());
            ServerGameSession gs = new ServerGameSession(clientSocket);
            Thread t = new Thread(gs);
            t.start();
        }
    }
}
