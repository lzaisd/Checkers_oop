package ru.vsu.csf.piit.checkers.server;

public enum Command {
    MOVE("MOVE"),

    MAKEMOVE_W("MAKEMOVE_W"),
    MAKEMOVE_B("MAKEMOVE_B");

    private final String commandString;
    Command(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString(){
        return commandString;
    }
}
