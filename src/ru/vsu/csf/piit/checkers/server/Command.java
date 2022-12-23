package ru.vsu.csf.piit.checkers.server;

public enum Command {
    MOVE("MOVE"),

    MAKEMOVEW("MAKEMOVEW"),
    MAKEMOVEB("MAKEMOVEB");

    private final String commandString;
    Command(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString(){
        return commandString;
    }
}
