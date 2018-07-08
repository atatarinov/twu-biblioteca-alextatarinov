package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryDatabaseTest {

    @Test
    public void getCurrentBooks() {
        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "The Hitchhiker's Guide to the Galaxy; Douglas Adams; 1995, " +
                "Something Wicked This Way Comes; Ray Bradbury; 1998, " +
                "Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        assertEquals(expected, new LibraryDatabase().getCurrentBooks().toString());
    }

    @Test
    public void getCurrentMovies() {
        String expected = "[The Godfather; 1972; Francis Ford Coppola; 9.2," +
                " The Shawshank Redemption; 1994; Frank Darabont; 9.3, " +
                "Schindler's List; 1993; Steven Spielberg; 8.9, " +
                "Raging Bull; 1980; Martin Scorsese; 8.2," +
                " Casablanca; 1942; Michael Curtiz; 8.5]";

        assertEquals(expected, new LibraryDatabase().getCurrentMovies().toString());
    }
}