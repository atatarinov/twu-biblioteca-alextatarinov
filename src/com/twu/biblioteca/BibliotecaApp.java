package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static void listOptions(UserMenuOptionsAndMessages userOptions) {
        System.out.println();
        System.out.println(userOptions.listBooksOption());
        System.out.println(userOptions.listMoviesOption());
        System.out.println();
        System.out.println(userOptions.bookCheckoutOption());
        System.out.println(userOptions.movieCheckoutOption());
        System.out.println();
        System.out.println(userOptions.bookReturnOption());
        System.out.println(userOptions.quitOption());
    }

    private static void printBooksOnScreenForUser(UserGreeterAndInfoPrinter userGreeter, LibraryDatabase database) {
        System.out.println();
        System.out.println("Currently available books:");
        System.out.println();
        userGreeter.printBooksToScreenForUser(database.getCurrentBooks());
    }

    private static void printMoviesOnScreenForUser(UserGreeterAndInfoPrinter userGreeter, LibraryDatabase database) {
        System.out.println();
        System.out.println("Currently available movies:");
        System.out.println();
        userGreeter.printMoviesToScreenForUser(database.getCurrentMovies());
    }

    private static void runOptionsForUser(UserMenuOptionsAndMessages userOptions, UserGreeterAndInfoPrinter userGreeter) {
        LibraryDatabase database = new LibraryDatabase();
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine().trim();


        while (true) {

            if (userInput.equals("list books")) {
                printBooksOnScreenForUser(userGreeter, database);
                listOptions(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("list movies")) {
                printMoviesOnScreenForUser(userGreeter, database);
                listOptions(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("checkout books")) {
                System.out.println();
                System.out.println(userOptions.checkoutBookEntry());
                userInput = reader.nextLine().trim();

                if (database.processBookCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.bookCheckoutSuccessMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.bookCheckoutFailMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("checkout movies")) {
                System.out.println();
                System.out.println(userOptions.checkoutMovieEntry());
                userInput = reader.nextLine().trim();

                if (database.processMovieCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.movieCheckoutSuccessMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.movieCheckoutFailMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("return book")) {
                System.out.println();
                System.out.println(userOptions.returnBookOption());
                userInput = reader.nextLine().trim();

                if (database.processBookReturnRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.bookReturnSuccessMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.bookReturnFailMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("quit")) {
                System.out.println();
                System.out.println("Good bye!");
                reader.close();
                break;
            } else {
                System.out.println();
                System.out.println(userOptions.invalidOption());
                listOptions(userOptions);
                userInput = reader.nextLine().trim();
            }
        }
    }


    public static void main(String[] args) {
        UserGreeterAndInfoPrinter userGreeter = new UserGreeterAndInfoPrinter();
        UserMenuOptionsAndMessages userOptions = new UserMenuOptionsAndMessages();

        System.out.println("*****************************************************************");
        System.out.println("*** " + userGreeter.greetUserOnStart() + " ***");
        System.out.println("*****************************************************************");

        listOptions(userOptions);
        runOptionsForUser(userOptions, userGreeter);
    }

}
