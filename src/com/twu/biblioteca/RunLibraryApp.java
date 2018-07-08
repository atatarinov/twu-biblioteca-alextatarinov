package com.twu.biblioteca;

import java.util.Scanner;

public class RunLibraryApp {

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

    private static boolean userInputIsCheckoutBook(String userInput) {
        return userInput.equals("checkout book");
    }

    private static boolean userInputIsListMovies(String userInput) {
        return userInput.equals("list movies");
    }

    private static boolean userInputIsMyAccount(String userInput) {
        return userInput.equals("my account");
    }

    private static boolean userInputIsReturnBook(String userInput) {
        return userInput.equals("return book");
    }

    private static boolean userInputIsCheckoutMovie(String userInput) {
        return userInput.equals("checkout movie");
    }

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
            } else if (userInputIsCheckoutBook(userInput)) {
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

            } else if (userInputIsCheckoutMovie(userInput)) {
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
            } else if (userInputIsMyAccount(userInput)) {
                userGreeter.printUserNameEmailPhone(loggedInUser);
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

    private static void loginUser(UserGreeterAndInfoPrinter userGreeter, UserMenuOptionsAndMessages userOptions) {
        Scanner reader = new Scanner(System.in);
        LibraryDatabase database = new LibraryDatabase();
        String[] loggedInUser;

        System.out.println();
        System.out.println(userOptions.enterLibraryNumberOption());
        String userInput = reader.nextLine().trim();

        while (true) {
            if (database.processUserLoginRequest(userInput)) {
                System.out.println(userOptions.enterPasswordOption());
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
                System.out.println(userOptions.invalidLoginMessage());
                System.out.println(userOptions.quitOption());
                userInput = reader.nextLine().trim();
            }
        }
    }

}
