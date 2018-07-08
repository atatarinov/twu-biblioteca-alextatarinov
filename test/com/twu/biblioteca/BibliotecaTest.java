package com.twu.biblioteca;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void checksInBookFromUser() {
        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        LibraryDatabase database = new LibraryDatabase();
        database.processBookCheckoutRequestFromUser("Do Androids Dream of Electric Sheep");
        database.processBookCheckoutRequestFromUser("The Hitchhiker's Guide to the Galaxy");
        database.processBookCheckoutRequestFromUser("Something Wicked This Way Comes");
        database.processBookReturnRequestFromUser("Do Androids Dream of Electric Sheep?");

        assertEquals(expected, database.getCurrentBooks().toString());
    }

    @Test
    public void checkoutBookEntry() {
        String expected = "[Do Androids Dream of Electric Sheep?; Philip K. Dick; 1996, " +
                "Something Wicked This Way Comes; Ray Bradbury; 1998, " +
                "Pride and Prejudice and Zombies; Seth Grahame-Smith & Jane Austen; 2009, " +
                "I Was Told There'd Be Cake; Sloane Crosley; 2008]";

        LibraryDatabase database = new LibraryDatabase();
        database.processBookCheckoutRequestFromUser("The Hitchhiker's Guide to the Galaxy");

        assertEquals(expected, database.getCurrentBooks().toString());
    }

}

