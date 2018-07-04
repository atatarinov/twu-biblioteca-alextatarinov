package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class LibraryDatabase {

    public LibraryDatabase() {
        currentBooks.add("Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996");
        currentBooks.add("The Hitchhiker's Guide to the Galaxy; Douglas Adams; 1995");
        currentBooks.add("Something Wicked This Way Comes; Ray Bradbury; 1998");
        currentBooks.add("Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009");
        currentBooks.add("I Was Told There'd Be Cake; Sloane Crosley; 2008");
    }

    private ArrayList<String> currentBooks = new ArrayList<>();

    public ArrayList getCurrentBooks() {
        return currentBooks;
    }

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
