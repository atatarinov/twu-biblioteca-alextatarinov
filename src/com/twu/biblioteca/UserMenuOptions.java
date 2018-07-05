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

    public String checkoutOption() {
        return "To checkout a book, type in the title and press ENTER";
    }

}
