package com.twu.biblioteca;

import java.util.ArrayList;

public class BookPrinter {

    public void printBooksInfoToScreen(ArrayList<String> bookList) {

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
}
