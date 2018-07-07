package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryDatabase {

    public LibraryDatabase() {
        currentBooks.add("Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996");
        currentBooks.add("The Hitchhiker's Guide to the Galaxy; Douglas Adams; 1995");
        currentBooks.add("Something Wicked This Way Comes; Ray Bradbury; 1998");
        currentBooks.add("Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009");
        currentBooks.add("I Was Told There'd Be Cake; Sloane Crosley; 2008");

        currentMovies.add("The Godfather; 1972; Francis Ford Coppola; 9.2");
        currentMovies.add("The Shawshank Redemption; 1994; Frank Darabont; 9.3");
        currentMovies.add("Schindler's List; 1993; Steven Spielberg; 8.9");
        currentMovies.add("Raging Bull; 1980; Martin Scorsese; 8.2");
        currentMovies.add("Casablanca; 1942; Michael Curtiz; 8.5");
    }

    private ArrayList<String> currentBooks = new ArrayList<>();
    private ArrayList<String> checkedoutBooks = new ArrayList<>();
    private ArrayList<String> currentMovies = new ArrayList<>();

    public ArrayList getCurrentBooks() {
        return currentBooks;
    }

    private void checkoutBookToUser(int index) {
        checkedoutBooks.add(currentBooks.get(index));
        currentBooks.remove(index);
    }

    private void returnBookFromUser(String book) {
        currentBooks.add(book);
        checkedoutBooks.remove(book);
    }

    private String getBookTitle(String bookEntry) {
        return bookEntry.split(";")[0];
    }

    public boolean processCheckoutRequestFromUser(String title) {
        int bookIndex = -1;

        for (String bookEntry : currentBooks) {
            String bookTitle = getBookTitle(bookEntry);
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

    public boolean processReturnRequestFromUser(String title) {
        int bookIndex = -1;
        String bookToReturn = null;

        for (String checkedoutBook : checkedoutBooks) {
            String bookTitle = getBookTitle(checkedoutBook);
            if (bookTitle.equals(title)) {
                bookIndex = checkedoutBooks.indexOf(checkedoutBook);
                bookToReturn = checkedoutBook;
            }
        }

        if (bookIndex > -1) {
            returnBookFromUser(bookToReturn);
            return true;
        }
        return false;
    }

    public ArrayList<String> getCurrentMovies() {
        return currentMovies;
    }
}
