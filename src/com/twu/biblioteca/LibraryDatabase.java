package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryDatabase {

    public LibraryDatabase() {
        currentBooks.add("Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996");
        currentBooks.add("The Hitchhiker's Guide to the Galaxy; Douglas Adams; 1995");
        currentBooks.add("Something Wicked This Way Comes; Ray Bradbury; 1998");
        currentBooks.add("Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009");
        currentBooks.add("I Was Told There'd Be Cake; Sloane Crosley; 2008");
    }

    private ArrayList<String> currentBooks = new ArrayList<>();
    private ArrayList<String> checkedoutBooks = new ArrayList<>();

    public ArrayList getCurrentBooks() {
        return currentBooks;
    }

    public void checkoutBookToUser(int index) {
        currentBooks.remove(index);
    }

    public void returnBookFromUser(String book) {
        currentBooks.add(book);
    }

    public boolean processCheckoutRequestFromUser(String title) {
        int bookIndex = -1;
        String bookToCheckout;

        for (String bookEntry : currentBooks) {
            String bookTitle = getBookTitle(bookEntry);

            if (bookTitle.equals(title)) {
                bookIndex = currentBooks.indexOf(bookEntry);
                bookToCheckout = bookEntry;
            }
        }

        if (bookIndex > -1) {
            checkedoutBooks.add(currentBooks.get(bookIndex));
            checkoutBookToUser(bookIndex);
            return true;
        }
        return false;
    }

    private String getBookTitle(String bookEntry) {
        return bookEntry.split(";")[0];
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
            currentBooks.add(bookToReturn);
            checkedoutBooks.remove(bookIndex);
            return true;
        }
        return false;
    }

}
