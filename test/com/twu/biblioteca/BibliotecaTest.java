package com.twu.biblioteca;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void greetsUserOnStart() {
        assertEquals("Welcome to the Bangalore Public Library Management System", new UserGreeterAndInfoPrinter().greetUserOnStart());
    }

    @Ignore
    @Test
    public void getsCurrentLibraryBooksTitles() {

        String expected = "[Do Androids Dream of Electric Sheep?" +
                "The Hitchhiker's Guide to the Galaxy" +
                "Something Wicked This Way Comes, Pride and Prejudice and Zombies; " +
                "Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake]";

        assertEquals(expected, new LibraryDatabase().getCurrentBooks().toString());
    }

    @Test
    public void getsCurrentLibraryBooksInfo() {

        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "The Hitchhiker's Guide to the Galaxy; Douglas Adams; 1995, " +
                "Something Wicked This Way Comes; Ray Bradbury; 1998, " +
                "Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        assertEquals(expected, new LibraryDatabase().getCurrentBooks().toString());
    }

    @Test
    public void outputsListBooksOptionToUser() {
        assertEquals("To view all available books: type \"list books\" and press ENTER", new UserMenuOptionsAndMessages().listBooksOption());
    }

    @Test
    public void outputsInvalidOptionToUser() {
        assertEquals("Select a valid option!", new UserMenuOptionsAndMessages().invalidOption());
    }

    @Test
    public void outputsQuitOptionToUser() {
        assertEquals("To quit: type \"quit\" and press ENTER", new UserMenuOptionsAndMessages().quitOption());
    }

    @Test
    public void outputsBookCheckoutOptionToUser() {
        assertEquals("To checkout a book, type \"checkout books\" and press ENTER", new UserMenuOptionsAndMessages().bookCheckoutOption());
    }

    @Test
    public void checksOutBookToUser() {
        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "Something Wicked This Way Comes; Ray Bradbury; 1998, " +
                "Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        LibraryDatabase database = new LibraryDatabase();
        database.processBookCheckoutRequestFromUser("The Hitchhiker's Guide to the Galaxy");

        assertEquals(expected, database.getCurrentBooks().toString());
    }

    @Test
    public void outputsSuccessfulCheckoutMessage() {
        assertEquals("Thank you! Enjoy the book", new UserMenuOptionsAndMessages().bookCheckoutSuccessMessage());
    }

    @Test
    public void outputsUnsuccessfulCheckoutMessage() {
        assertEquals("That book is not available", new UserMenuOptionsAndMessages().bookCheckoutFailMessage());
    }

    @Test
    public void outputsReturnOptionToUser() {
        assertEquals("To return a book: type \"return book\" and press ENTER", new UserMenuOptionsAndMessages().bookReturnOption());
    }

    @Test
    public void checksInBookFromUser() {
        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        LibraryDatabase database = new LibraryDatabase();
        database.processBookCheckoutRequestFromUser("Do Androids Dream of Electric Sheep");
        database.processBookCheckoutRequestFromUser("The Hitchhiker's Guide to the Galaxy");
        database.processBookCheckoutRequestFromUser("Something Wicked This Way Comes");
        database.processBookReturnRequestFromUser("Do Androids Dream of Electric Sheep?");

        assertEquals(expected, database.getCurrentBooks().toString());
    }

    @Test
    public void outputsSuccessfulReturnMessage() {
        assertEquals("Thank you for returning the book", new UserMenuOptionsAndMessages().bookReturnSuccessMessage());
    }

    @Test
    public void outputsUnsuccessfulReturnMessage() {
        assertEquals("That is not a valid book to return", new UserMenuOptionsAndMessages().bookReturnFailMessage());
    }

    @Test
    public void outputsListMoviesOptionToUser() {
        assertEquals("To view all available movies: type \"list movies\" and press ENTER", new UserMenuOptionsAndMessages().listMoviesOption());
    }

    @Test
    public void outputsMoiveCheckoutOptionToUser() {
        assertEquals("To checkout a movie: type in the movie's title and press ENTER", new UserMenuOptionsAndMessages().checkoutMovieEntry());
    }
}

