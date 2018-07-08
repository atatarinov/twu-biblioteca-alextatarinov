package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserMenuOptionsAndMessagesTest {

    @Test
    public void listBooksOption() {
        assertEquals("To view all available books: type \"list books\" and press ENTER", new UserMenuOptionsAndMessages().listBooksOption());
    }

    @Test
    public void invalidOption() {
        assertEquals("Select a valid option!", new UserMenuOptionsAndMessages().invalidOption());
    }

    @Test
    public void quitOption() {
        assertEquals("To quit: type \"quit\" and press ENTER", new UserMenuOptionsAndMessages().quitOption());
    }

    @Test
    public void bookCheckoutOption() {
        assertEquals("To checkout a book, type \"checkout books\" and press ENTER", new UserMenuOptionsAndMessages().bookCheckoutOption());
    }

    @Test
    public void bookReturnOption() {
        assertEquals("To return a book: type \"return book\" and press ENTER", new UserMenuOptionsAndMessages().bookReturnOption());
    }

    @Test
    public void returnBookEntryOption() {
        assertEquals("To return a book: type in the book's title and press ENTER", new UserMenuOptionsAndMessages().returnBookEntryOption());
    }

    @Test
    public void listMoviesOption() {
        assertEquals("To view all available movies: type \"list movies\" and press ENTER", new UserMenuOptionsAndMessages().listMoviesOption());
    }

    @Test
    public void movieCheckoutOption() {
        assertEquals("To checkout a movie: type \"checkout movies\" and press ENTER", new UserMenuOptionsAndMessages().movieCheckoutOption());
    }

    @Test
    public void checkoutMovieEntryOption() {
        assertEquals("To checkout a movie: type in the movie's title and press ENTER", new UserMenuOptionsAndMessages().checkoutMovieEntryOption());
    }

    @Test
    public void bookCheckoutSuccessMessage() {
        assertEquals("Thank you! Enjoy the book", new UserMenuOptionsAndMessages().bookCheckoutSuccessMessage());
    }

    @Test
    public void bookCheckoutFailMessage() {
        assertEquals("That book is not available", new UserMenuOptionsAndMessages().bookCheckoutFailMessage());
    }

    @Test
    public void bookReturnSuccessMessage() {
        assertEquals("Thank you for returning the book", new UserMenuOptionsAndMessages().bookReturnSuccessMessage());
    }

    @Test
    public void bookReturnFailMessage() {
        assertEquals("That is not a valid book to return", new UserMenuOptionsAndMessages().bookReturnFailMessage());
    }

    @Test
    public void movieCheckoutSuccessMessage() {
        assertEquals("Thank you! Enjoy the movie", new UserMenuOptionsAndMessages().movieCheckoutSuccessMessage());
    }

    @Test
    public void movieCheckoutFailMessage() {
        assertEquals("That movie is not available", new UserMenuOptionsAndMessages().movieCheckoutFailMessage());
    }

    @Test
    public void goodByeMessage() {
        assertEquals("Good bye!", new UserMenuOptionsAndMessages().goodByeMessage());
    }

    @Test
    public void checkoutBookEntryOption() {
        assertEquals("To checkout a book, type in the book's title and press ENTER", new UserMenuOptionsAndMessages().checkoutBookEntryOption());
    }

    @Test
    public void loginRequiredMessage() {
        assertEquals("You must login to check-out and return books", new UserMenuOptionsAndMessages().loginRequiredMessage());
    }

}
