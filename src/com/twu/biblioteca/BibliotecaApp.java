package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static void runAppForUser(UserMenuOptionsAndMessages userOptions, UserGreeterAndInfoPrinter userGreeter) {
        LibraryDatabase database = new LibraryDatabase();
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine().trim();

        while (true) {

            if (userInput.equals("list books")) {
                userGreeter.printAvailableBooksToScreenForUser(database);
                userGreeter.listOptions(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("list movies")) {
                userGreeter.printAvailableMoviesToScreenForUser(database);
                userGreeter.listOptions(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("checkout books")) {
                System.out.println();
                System.out.println(userOptions.checkoutBookEntry());
                userInput = reader.nextLine().trim();

                if (database.processBookCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.bookCheckoutSuccessMessage());
                    userGreeter.listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.bookCheckoutFailMessage());
                    userGreeter.listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("checkout movies")) {
                System.out.println();
                System.out.println(userOptions.checkoutMovieEntry());
                userInput = reader.nextLine().trim();

                if (database.processMovieCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.movieCheckoutSuccessMessage());
                    userGreeter.listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.movieCheckoutFailMessage());
                    userGreeter.listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("return book")) {
                System.out.println();
                System.out.println(userOptions.returnBookOption());
                userInput = reader.nextLine().trim();

                if (database.processBookReturnRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.bookReturnSuccessMessage());
                    userGreeter.listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.bookReturnFailMessage());
                    userGreeter.listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("quit")) {
                System.out.println();
                System.out.println(userOptions.goodByeMessage());
                reader.close();
                break;
            } else {
                System.out.println();
                System.out.println(userOptions.invalidOption());
                userGreeter.listOptions(userOptions);
                userInput = reader.nextLine().trim();
            }
        }
    }

    public static void main(String[] args) {
        UserGreeterAndInfoPrinter userGreeter = new UserGreeterAndInfoPrinter();
        UserMenuOptionsAndMessages userOptions = new UserMenuOptionsAndMessages();

        userGreeter.startupGreeting();
        userGreeter.listOptions(userOptions);
        runAppForUser(userOptions, userGreeter);
    }

}
