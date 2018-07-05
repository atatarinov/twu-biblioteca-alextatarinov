package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        UserGreeter startup = new UserGreeter();
        System.out.println("*****************************************************************");
        System.out.println("*** " + startup.greetUserOnStart() + " ***");
        System.out.println("*****************************************************************");

        Scanner reader = new Scanner(System.in);

        System.out.println();
        System.out.println("Please type \"list books\" and press ENTER to view all available books");
        String userInput = reader.nextLine();

        while (true) {

            if (userInput.equals("list books")) {
                LibraryDatabase database = new LibraryDatabase();
                BookPrinter bookPrinter = new BookPrinter();

                System.out.println();
                System.out.println("Currently available books:");
                System.out.println();
                bookPrinter.printBooksInfoToScreen(database.getCurrentBooks());

                System.out.println();
                System.out.println("Please type \"list books\" and press ENTER to view all available books");
                System.out.println("Or type \"quit\" and press ENTER to quit");
                userInput = reader.nextLine();
            } else if (userInput.equals("quit")) {
                System.out.println("Good bye!");
                reader.close();
                break;
            } else {
                System.out.println("Select a valid option!");
                System.out.println("Please type \"list books\" and press ENTER to view all available books");
                System.out.println("Or type \"quit\" and press ENTER to quit");
                userInput = reader.nextLine();
            }
        }
    }

}
