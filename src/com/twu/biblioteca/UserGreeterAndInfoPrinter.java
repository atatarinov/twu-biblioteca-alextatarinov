package com.twu.biblioteca;

import java.util.ArrayList;

public class UserGreeterAndInfoPrinter {

    public void startupGreeting() {
        System.out.println("*****************************************************************");
        System.out.println("*** " + greetUserOnStart() + " ***");
        System.out.println("*****************************************************************");
        System.out.println();
        System.out.println(continueAsGuestOrUserOption());
    }

    public String continueAsGuestOrUserOption() {
        return "To continue as a guest: type in \"guest\" and press ENTER\nTo login: type in \"login\" and press ENTER";
    }

    public void printAvailableMoviesToScreenForUser(LibraryDatabase database) {
        System.out.println();
        System.out.println("Currently available movies:");
        System.out.println();
        printMoviesTable(database.getCurrentMovies());
    }

    public void listOptionsForGuestUser(UserMenuOptionsAndMessages userOptions) {
        System.out.println();
        System.out.println(userOptions.loginRequiredMessage());
        System.out.println();
        System.out.println(userOptions.listBooksOption());
        System.out.println(userOptions.listMoviesOption());
        System.out.println();

        System.out.println(userOptions.quitOption());
    }

    public void listOptionsForLoggedInUser(UserMenuOptionsAndMessages userOptions) {
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

    public void printAvailableBooksToScreenForUser(LibraryDatabase database) {
        System.out.println();
        System.out.println("Currently available books:");
        System.out.println();
        printBooksTable(database.getCurrentBooks());
    }

    public String greetUserOnStart() {
        return "Welcome to the Bangalore Public Library Management System";
    }

    public void printBooksTable(ArrayList<String> bookList) {

        System.out.printf("%-41s %-40s %4s\n", "Title:", "Author:", "Year:");
        System.out.println();

        for (String book : bookList) {
            String[] bookItem = book.split(";");

            String bookTitle = bookItem[0];
            String bookAuthor = bookItem[1];
            String bookPublicationYear = bookItem[2];
            System.out.printf("%-40s %-40s %4s\n", bookTitle, bookAuthor, bookPublicationYear);
        }
    }

    public void printMoviesTable(ArrayList<String> movieList) {
        System.out.printf("%-41s %-6s %-40s %4s\n", "Name:", "Year:", "Director:", "IMDb rating:");
        System.out.println();

        for (String movie : movieList) {
            String[] movieItem = movie.split(";");

            String movieName = movieItem[0];
            String movieYear = movieItem[1];
            String movieDirector = movieItem[2];
            String movieRating = movieItem[3];
            System.out.printf("%-40s %-6s %-40s %4s\n", movieName, movieYear, movieDirector, movieRating);
        }
    }
}
