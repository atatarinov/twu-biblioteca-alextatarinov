package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryDatabase {

    private ArrayList<String> currentBooks = new ArrayList<>();
    private ArrayList<String> checkedoutBooks = new ArrayList<>();
    private ArrayList<String> currentMovies = new ArrayList<>();
    private ArrayList<String> checkedoutMovies = new ArrayList<>();
    private ArrayList<String> activeUsers = new ArrayList<>();
    private String[] userToLogin;

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

        activeUsers.add("123-4567; password; John Smith; jsmith@gmail.com; (555)555-5555");
        activeUsers.add("111-2222; password; Jane Brown; jbrown@gmail.com; (555)123-4567");
    }

    public ArrayList getCurrentBooks() {
        return currentBooks;
    }

    public ArrayList<String> getCurrentMovies() {
        return currentMovies;
    }

    public boolean processBookCheckoutRequestFromUser(String title) {
        int bookIndex = -1;

        for (String bookEntry : currentBooks) {
            String bookTitle = getFirstItemInEntry(bookEntry);
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

    public boolean processBookReturnRequestFromUser(String userInput) {
        int bookIndex = -1;
        String bookToReturn = null;

        for (String checkedoutBook : checkedoutBooks) {
            String bookTitle = getFirstItemInEntry(checkedoutBook);
            if (bookTitle.equals(userInput)) {
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

    public boolean processMovieCheckoutRequestFromUser(String userInput) {
        int movieIndex = -1;

        for (String movieEntry : currentMovies) {
            String bookTitle = getFirstItemInEntry(movieEntry);
            if (bookTitle.equals(userInput)) {
                movieIndex = currentMovies.indexOf(movieEntry);
            }
        }

        if (movieIndex > -1) {
            checkoutMovieToUser(movieIndex);
            return true;
        }
        return false;
    }

    public boolean processUserLoginRequest(String userInput) {
        int userIndex = -1;

        for (String userEntry : activeUsers) {
            String userLibraryNumber = getFirstItemInEntry(userEntry);
            if (userLibraryNumber.equals(userInput)) {
                userIndex = activeUsers.indexOf(userEntry);
            }
        }

        if (userIndex > -1) {
            userToLogin = activeUsers.get(userIndex).split("; ");
            return true;
        }
        return false;
    }

    public boolean checkUserPassword(String userInput) {
        if (userToLogin[1].equals(userInput)) {
            return true;
        } else {
            return false;
        }
    }

    public String[] getUserToLogin() {
        return userToLogin;
    }

    private void checkoutBookToUser(int bookIndex) {
        checkedoutBooks.add(currentBooks.get(bookIndex));
        currentBooks.remove(bookIndex);
    }

    private void returnBookFromUser(String book) {
        currentBooks.add(book);
        checkedoutBooks.remove(book);
    }

    private String getFirstItemInEntry(String item) {
        return item.split(";")[0];
    }

    private void checkoutMovieToUser(int movieIndex) {
        checkedoutMovies.add(currentMovies.get(movieIndex));
        currentMovies.remove(movieIndex);
    }
}
