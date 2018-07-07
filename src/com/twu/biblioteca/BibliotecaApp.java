package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static void listOptions(UserMenuOptionsAndMessages userOptions) {
        System.out.println();
        System.out.println(userOptions.listBooksOption());
        System.out.println(userOptions.listMoviesOption());
        System.out.println(userOptions.generalCheckoutOption());
        System.out.println(userOptions.generalReturnOption());
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
            } else if (userInput.equals("checkout")) {
                System.out.println();
                System.out.println(userOptions.checkoutBookOption());
                userInput = reader.nextLine().trim();

                if (database.processCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.checkoutSuccessMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.checkoutFailMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("return")) {
                System.out.println();
                System.out.println(userOptions.returnBookOption());
                userInput = reader.nextLine().trim();

                if (database.processReturnRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.returnSuccessMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.returnFailMessage());
                    listOptions(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("quit")) {
                System.out.println();
                System.out.println("Good bye!");
                reader.close();
                break;
            } else {
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
