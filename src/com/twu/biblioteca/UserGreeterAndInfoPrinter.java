package com.twu.biblioteca;

import java.util.ArrayList;

public class UserGreeterAndInfoPrinter {

    public String greetUserOnStart() {
        return "Welcome to the Bangalore Public Library Management System";
    }

    public void printBooksToScreenForUser(ArrayList<String> bookList) {

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

    public void printMoviesToScreenForUser(ArrayList<String> movieList) {
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
