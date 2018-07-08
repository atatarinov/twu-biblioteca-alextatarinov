package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static void runAppForGuestUser(UserMenuOptionsAndMessages userOptions, UserGreeterAndInfoPrinter userGreeter) {
        LibraryDatabase database = new LibraryDatabase();
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine().trim();

        while (true) {

            if (userInput.equals("list books")) {
                userGreeter.printAvailableBooksToScreenForUser(database);
                userGreeter.listOptionsForGuestUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("list movies")) {
                userGreeter.printAvailableMoviesToScreenForUser(database);
                userGreeter.listOptionsForGuestUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("quit")) {
                System.out.println();
                System.out.println(userOptions.goodByeMessage());
                reader.close();
                break;
            } else {
                System.out.println();
                System.out.println(userOptions.invalidOption());
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            }
        }
    }

    private static void runAppForLoggedInUser(UserMenuOptionsAndMessages userOptions, UserGreeterAndInfoPrinter userGreeter, LibraryDatabase database) {
//        LibraryDatabase database = new LibraryDatabase();
        Scanner reader = new Scanner(System.in);

        userGreeter.listOptionsForLoggedInUser(userOptions);
        String userInput = reader.nextLine().trim();

        while (true) {

            if (userInput.equals("list books")) {
                userGreeter.printAvailableBooksToScreenForUser(database);
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("list movies")) {
                userGreeter.printAvailableMoviesToScreenForUser(database);
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInput.equals("checkout books")) {
                System.out.println();
                System.out.println(userOptions.checkoutBookEntryOption());
                userInput = reader.nextLine().trim();

                if (database.processBookCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.bookCheckoutSuccessMessage());
                    userGreeter.listOptionsForLoggedInUser(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.bookCheckoutFailMessage());
                    userGreeter.listOptionsForLoggedInUser(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("checkout movies")) {
                System.out.println();
                System.out.println(userOptions.checkoutMovieEntryOption());
                userInput = reader.nextLine().trim();

                if (database.processMovieCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.movieCheckoutSuccessMessage());
                    userGreeter.listOptionsForLoggedInUser(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.movieCheckoutFailMessage());
                    userGreeter.listOptionsForLoggedInUser(userOptions);
                    userInput = reader.nextLine().trim();
                }

            } else if (userInput.equals("return book")) {
                System.out.println();
                System.out.println(userOptions.returnBookEntryOption());
                userInput = reader.nextLine().trim();

                if (database.processBookReturnRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.bookReturnSuccessMessage());
                    userGreeter.listOptionsForLoggedInUser(userOptions);
                    userInput = reader.nextLine().trim();
                } else {
                    System.out.println();
                    System.out.println(userOptions.bookReturnFailMessage());
                    userGreeter.listOptionsForLoggedInUser(userOptions);
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
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            }
        }
    }

    public static void main(String[] args) {
        UserGreeterAndInfoPrinter userGreeter = new UserGreeterAndInfoPrinter();
        UserMenuOptionsAndMessages userOptions = new UserMenuOptionsAndMessages();

        userGreeter.startupGreeting();

        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine().trim();

        while (true) {
            if (userInput.equals("guest")) {
                userGreeter.listOptionsForGuestUser(userOptions);
                runAppForGuestUser(userOptions, userGreeter);
                break;
            } else if (userInput.equals("login")) {
                loginUser(userGreeter, userOptions);
                break;
            } else if (userInput.equals("quit")) {
                System.out.println();
                System.out.println(userOptions.goodByeMessage());
                reader.close();
                break;
            } else {
                System.out.println();
                System.out.println(userOptions.invalidOption());
                System.out.println(userGreeter.continueAsGuestOrUserOption());
                userInput = reader.nextLine().trim();
            }
        }


    }

    private static void loginUser(UserGreeterAndInfoPrinter userGreeter, UserMenuOptionsAndMessages userOptions) {
        Scanner reader = new Scanner(System.in);
        LibraryDatabase database = new LibraryDatabase();
        String[] loggedInUser;

        System.out.println();
        System.out.println("Please enter your library number (xxx-xxxx) and press ENTER");
        String userInput = reader.nextLine().trim();

        while(true) {
            if (database.processUserLoginRequest(userInput)) {
                System.out.println("Please enter your password and press ENTER");
                userInput = reader.nextLine().trim();

                if (database.checkUserPassword(userInput)) {
                    loggedInUser = database.getUserToLogin();
                    System.out.println("Welcome back, " + loggedInUser[2] + "!");
                    runAppForLoggedInUser(userOptions, userGreeter, database);
                    break;
                }

            } else if (userInput.equals("quit")) {
                System.out.println();
                System.out.println(userOptions.goodByeMessage());
                reader.close();
                break;
            } else {
                System.out.println();
                System.out.println("Invalid library number or password, try again");
                System.out.println(userOptions.quitOption());
                userInput = reader.nextLine().trim();
            }
        }
    }

}

// lib number, password, name, email, phone,

