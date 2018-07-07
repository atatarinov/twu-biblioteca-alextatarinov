package com.twu.biblioteca;

public class UserMenuOptionsAndMessages {

    public String listBooksOption() {
        return "Please type \"list books\" and press ENTER to view all available books";
    }

    public String invalidOption() {
        return "Select a valid option!";
    }

    public String quitOption() {
        return "or type \"quit\" and press ENTER to quit";
    }

    public String generalCheckoutOption() {
        return "To checkout a book, type \"checkout\" and press ENTER";
    }

    public String checkoutBookOption() {
        return "To checkout a book, type in the book's title and press ENTER";
    }

    public String checkoutSuccessMessage() {
        return "Thank you! Enjoy the book";
    }

    public String checkoutFailMessage() {
        return "That book is not available";
    }

    public String generalReturnOption() {
        return "To return a book, type \"return\" and press ENTER";
    }

    public String returnBookOption() {
        return "To return a book, type in the book's title and press ENTER";
    }

    public String returnSuccessMessage() {
        return "Thank you for returning the book";
    }

    public String returnFailMessage() {
        return "That is not a valid book to return";
    }

    public String listMoviesOption() {
        return "Type \"list movies\" and press ENTER to view all available movies";
    }
}
