package com.twu.biblioteca;

import java.util.Scanner;

public class RunLibraryApp {

    public static void startLibraryApp() {
        UserGreeterAndInfoPrinter userGreeter = new UserGreeterAndInfoPrinter();
        UserMenuOptionsAndMessages userOptions = new UserMenuOptionsAndMessages();
        Scanner reader = new Scanner(System.in);

        userGreeter.startupGreeting();
        String userInput = reader.nextLine().trim();

        while (true) {
            if (userInputIsGuest(userInput)) {
                userGreeter.listOptionsForGuestUser(userOptions);
                runAppForGuestUser(userOptions, userGreeter);
                break;
            } else if (userInputIsLogin(userInput)) {
                loginUser(userGreeter, userOptions);
                break;
            } else if (userInputIsQuit(userInput)) {
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

    private static boolean userInputIsQuit(String userInput) {
        return userInput.equals("quit");
    }

    private static boolean userInputIsLogin(String userInput) {
        return userInput.equals("login");
    }

    private static boolean userInputIsGuest(String userInput) {
        return userInput.equals("guest");
    }

    private static boolean userInputIsListBooks(String userInput) {
        return userInput.equals("list books");
    }

    private static boolean userInputIsCheckoutBooks(String userInput) {
        return userInput.equals("checkout books");
    }

    private static boolean userInputIsListMovies(String userInput) {
        return userInput.equals("list movies");
    }

    private static boolean userInputIsUser(String userInput) {
        return userInput.equals("user");
    }

    private static boolean userInputIsReturnBook(String userInput) {
        return userInput.equals("return book");
    }

    private static boolean userInputIsCheckoutMovies(String userInput) {
        return userInput.equals("checkout movies");
    }

    private static void runAppForGuestUser(UserMenuOptionsAndMessages userOptions, UserGreeterAndInfoPrinter userGreeter) {
        LibraryDatabase database = new LibraryDatabase();
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine().trim();

        while (true) {

            if (userInputIsListBooks(userInput)) {
                userGreeter.printAvailableBooksToScreenForUser(database);
                userGreeter.listOptionsForGuestUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInputIsListMovies(userInput)) {
                userGreeter.printAvailableMoviesToScreenForUser(database);
                userGreeter.listOptionsForGuestUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInputIsQuit(userInput)) {
                System.out.println();
                System.out.println(userOptions.goodByeMessage());
                reader.close();
                break;
            } else {
                System.out.println();
                System.out.println(userOptions.invalidOption());
                userGreeter.listOptionsForGuestUser(userOptions);
                userInput = reader.nextLine().trim();
            }
        }
    }

    private static void runAppForLoggedInUser(UserMenuOptionsAndMessages userOptions, UserGreeterAndInfoPrinter userGreeter, LibraryDatabase database, String[] loggedInUser) {
        Scanner reader = new Scanner(System.in);
        userGreeter.listOptionsForLoggedInUser(userOptions);
        String userInput = reader.nextLine().trim();

        while (true) {

            if (userInputIsListBooks(userInput)) {
                userGreeter.printAvailableBooksToScreenForUser(database);
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInputIsListMovies(userInput)) {
                userGreeter.printAvailableMoviesToScreenForUser(database);
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            } else if (userInputIsCheckoutBooks(userInput)) {
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

            } else if (userInputIsCheckoutMovies(userInput)) {
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

            } else if (userInputIsReturnBook(userInput)) {
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

            } else if (userInputIsQuit(userInput)) {
                System.out.println();
                System.out.println(userOptions.goodByeMessage());
                reader.close();
                break;
            } else if (userInputIsUser(userInput)) {
                printUserNameEmailPhone(loggedInUser);
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            } else {
                System.out.println();
                System.out.println(userOptions.invalidOption());
                userGreeter.listOptionsForLoggedInUser(userOptions);
                userInput = reader.nextLine().trim();
            }
        }
    }

    private static void printUserNameEmailPhone(String[] loggedInUser) {
        System.out.println();
        System.out.println("Your user information:");
        System.out.println();
        System.out.println("Name: " + loggedInUser[2] + "\nEmail: " + loggedInUser[3] + "\nPhone number: " + loggedInUser[4]);
    }

    private static void loginUser(UserGreeterAndInfoPrinter userGreeter, UserMenuOptionsAndMessages userOptions) {
        Scanner reader = new Scanner(System.in);
        LibraryDatabase database = new LibraryDatabase();
        String[] loggedInUser;

        System.out.println();
        System.out.println("Please enter your library number (xxx-xxxx) and press ENTER");
        String userInput = reader.nextLine().trim();

        while (true) {
            if (database.processUserLoginRequest(userInput)) {
                System.out.println("Please enter your password and press ENTER");
                userInput = reader.nextLine().trim();

                if (database.checkUserPassword(userInput)) {
                    loggedInUser = database.getUserToLogin();
                    System.out.println("Welcome back, " + loggedInUser[2] + "!");
                    runAppForLoggedInUser(userOptions, userGreeter, database, loggedInUser);
                    break;
                }

            } else if (userInputIsQuit(userInput)) {
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
