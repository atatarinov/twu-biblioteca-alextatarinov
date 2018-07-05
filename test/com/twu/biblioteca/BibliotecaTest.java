package com.twu.biblioteca;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void greetsUserOnStart() {
        assertEquals("Welcome to the Bangalore Public Library Management System", new UserGreeter().greetUserOnStart());
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
        assertEquals("Please type \"list books\" and press ENTER to view all available books", new UserMenuOptions().listBooks());
    }

    @Test
    public void outputsInvalidOptionToUser() {
        assertEquals("Select a valid option!", new UserMenuOptions().invalidOption());
    }

    @Test
    public void outputsQuitOptionToUser() {
        assertEquals("or type \"quit\" and press ENTER to quit", new UserMenuOptions().quitOption());
    }

    @Test
    public void outputsCheckoutOptionToUser() {
        assertEquals("To checkout a book, type \"checkout\" and press ENTER", new UserMenuOptions().generalCheckoutOption());
    }

    @Test
    public void checksOutBookToUser() {
        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "Something Wicked This Way Comes; Ray Bradbury; 1998, " +
                "Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        LibraryDatabase database = new LibraryDatabase();
        database.processUserRequest("The Hitchhiker's Guide to the Galaxy");

        assertEquals(expected, database.getCurrentBooks().toString());
    }

    @Test
    public void outputsSuccessfulCheckoutMessage() {
        assertEquals("Thank you! Enjoy the book", new UserMenuOptions().checkoutSuccessMessage());
    }

    @Test
    public void outputsUnsuccessfulCheckoutMessage() {
        assertEquals("That book is not available", new UserMenuOptions().checkoutUnsuccessMessage());
    }


}

