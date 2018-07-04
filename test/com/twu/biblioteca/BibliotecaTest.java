package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void greetsUserOnStartup() {
        assertEquals("Welcome to the Bangalore Public Library Management System", new UserGreeter().greetUserOnStartup());
    }

    @Test
    public void getsCurrentLibraryBooks() {

        String expected = "[Do Androids Dream of Electric Sheep?, " +
                "The Hitchhiker's Guide to the Galaxy, " +
                "Something Wicked This Way Comes, " +
                "Pride and Prejudice and Zombies, " +
                "I Was Told There'd Be Cake]";

        assertEquals(expected, new LibraryDatabase().getCurrentBooks().toString());
    }






}
