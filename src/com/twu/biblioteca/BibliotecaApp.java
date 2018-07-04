package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        UserGreeter startup = new UserGreeter();
        System.out.println("*****************************************************************");
        System.out.println("*** " + startup.greetUserOnStart() + " ***");
        System.out.println("*****************************************************************");

        LibraryDatabase database = new LibraryDatabase();
        BookPrinter bookPrinter = new BookPrinter();

        System.out.println();
        System.out.println("Currently available books:");
        System.out.println();
        bookPrinter.printBooksInfoToScreen(database.getCurrentBooks());


    }
}
