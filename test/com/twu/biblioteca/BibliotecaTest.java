package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void greetsUserOnStart() {
        assertEquals("Welcome to the Bangalore Public Library Management System", new UserGreeter().greetUserOnStart());
    }

    @Test
    public void getsCurrentLibraryBooksInfo() {

        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "The Hitchhiker's Guide to the Galaxy; Douglas Adams; 1995, " +
                "Something Wicked This Way Comes; Ray Bradbury; 1998, Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        assertEquals(expected, new LibraryDatabase().getCurrentBooks().toString());
    }



}
