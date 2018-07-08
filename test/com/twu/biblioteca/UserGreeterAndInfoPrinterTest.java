package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserGreeterAndInfoPrinterTest {

    @Test
    public void greetUserOnStart() {
        assertEquals("Welcome to the Bangalore Public Library Management System", new UserGreeterAndInfoPrinter().greetUserOnStart());
    }

    @Test
    public void continueAsGuestOrUserOption() {
        assertEquals("To continue as a guest: type in \"guest\" and press ENTER\nTo login: type in \"login\" and press ENTER", new UserGreeterAndInfoPrinter().continueAsGuestOrUserOption());
    }
}