package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        UserGreeter startup = new UserGreeter();
        System.out.println("*****************************************************************");
        System.out.println("*** " + startup.greetUserOnStartup() + " ***");
        System.out.println("*****************************************************************");
    }
}
