package com.twu.biblioteca;

public class UserMenuOptionsAndMessages {

    public String invalidLoginMessage() {
        return "Invalid library number or password, try again";
    }

    public String enterPasswordOption() {
        return "Please enter your password and press ENTER";
    }

    public String enterLibraryNumberOption() {
        return "Please enter your library number (xxx-xxxx) and press ENTER";
    }

    public String listBooksOption() {
        return "To view all available books: type \"list books\" and press ENTER";
    }

    public String invalidOption() {
        return "Select a valid option!";
    }

    public String quitOption() {
        return "To quit: type \"quit\" and press ENTER";
    }

    public String bookCheckoutOption() {
        return "To checkout a book, type \"checkout book\" and press ENTER";
    }

    public String checkoutBookEntryOption() {
        return "To checkout a book, type in the book's title and press ENTER";
    }

    public String bookCheckoutSuccessMessage() {
        return "Thank you! Enjoy the book";
    }

    public String bookCheckoutFailMessage() {
        return "That book is not available";
    }

    public String bookReturnOption() {
        return "To return a book: type \"return book\" and press ENTER";
    }

    public String returnBookEntryOption() {
        return "To return a book: type in the book's title and press ENTER";
    }

    public String bookReturnSuccessMessage() {
        return "Thank you for returning the book";
    }

    public String bookReturnFailMessage() {
        return "That is not a valid book to return";
    }

    public String listMoviesOption() {
        return "To view all available movies: type \"list movies\" and press ENTER";
    }

    public String movieCheckoutOption() {
        return "To checkout a movie: type \"checkout movie\" and press ENTER";
    }

    public String checkoutMovieEntryOption() {
        return "To checkout a movie: type in the movie's title and press ENTER";
    }

    public String movieCheckoutSuccessMessage() {
        return "Thank you! Enjoy the movie";
    }

    public String movieCheckoutFailMessage() {
        return "That movie is not available";
    }

    public String goodByeMessage() {
        return "Good bye!";
    }

    public String loginRequiredMessage() {
        return "You must login to check-out and return books";
    }

    public String continueAsGuestOrUserOption() {
        return "hello";
    }

    public String showUserInfoOption() {
        return "To view your account information: type \"my account\" and press ENTER";
    }
}
