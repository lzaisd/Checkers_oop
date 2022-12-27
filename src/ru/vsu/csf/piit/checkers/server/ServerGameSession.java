package ru.vsu.csf.piit.checkers.server;

import ru.vsu.csf.piit.checkers.board.Position;
import ru.vsu.csf.piit.checkers.checker.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerGameSession implements Runnable{
    private ServerGame game;
    private Socket socket;
    private Color currColor = Color.WHITE;
    private PrintWriter out;
    private BufferedReader in;

    public ServerGameSession(Socket socket) {
        this.game = new ServerGame();
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e){
            throw new IllegalStateException("Cannot connect to client", e);
        }
    }

    @Override
    public void run() {
        while (!game.getBoard().gameOver()){
            game.move(getPosition());
        }
        System.out.println("Game over");
    }

    public Position getPosition(){
        String answer = "";
        try {
            String command = (game.getCurrColor() == Color.WHITE) ? Command.MAKEMOVE_W.getCommandString() : Command.MAKEMOVE_B.getCommandString();
            System.out.println("To client: " + command);
            out.println(command);

            while ((answer = in.readLine()) == null) {
            }
            System.out.println("From client: " + answer);
            String[] answerParsed = answer.split(" ");
            if (Command.MOVE.getCommandString().equals(answerParsed[0])) {
                System.out.println("Player's position: " + answerParsed[1]);
//                System.out.println("Player's position: " + answerParsed[2]);
            } else {
                throw new IllegalArgumentException("Client response is not recognized: " + answer);
            }

            return new Position(answerParsed[1]);
//            return new Position(answerParsed[2]);

        } catch (IOException e){
            throw new IllegalStateException("Cannot communicate with a client", e);
        }
    }
}
