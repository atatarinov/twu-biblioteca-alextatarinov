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

    public void checkoutBookToUser(int index) {
        currentBooks.remove(index);
    }

    public boolean processUserRequest(String title) {
        int bookIndex = -1;

        for (String bookEntry : currentBooks) {
            String bookTitle = bookEntry.split(";")[0];

            if (bookTitle.equals(title)) {
                bookIndex = currentBooks.indexOf(bookEntry);
            }
        }

        if (bookIndex > -1) {
            checkoutBookToUser(bookIndex);
            return true;
        }
        return false;
    }

}
