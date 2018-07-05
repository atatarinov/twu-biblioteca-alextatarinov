package com.twu.biblioteca;

public class UserMenuOptions {

    public String listBooks() {
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

    public String checkoutUnsuccessMessage() {
        return "That book is not available";
    }

}
