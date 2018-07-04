package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryDatabase {

    public LibraryDatabase() {
        currentBooks.add("Do Androids Dream of Electric Sheep?");
        currentBooks.add("The Hitchhiker's Guide to the Galaxy");
        currentBooks.add("Something Wicked This Way Comes");
        currentBooks.add("Pride and Prejudice and Zombies");
        currentBooks.add("I Was Told There'd Be Cake");
    }

    private ArrayList<String> currentBooks = new ArrayList<>();

    public ArrayList getCurrentBooks() {
        return currentBooks;
    }

    public void printBooksToScreen(ArrayList<String> bookList) {
        for (String book : bookList) {
            System.out.println(book);
        }
    }

}
