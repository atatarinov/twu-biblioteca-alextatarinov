package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void greetsUserOnStartup() {

        assertEquals("Welcome to the Bangalore Public Library Management System", new UserGreeter().greetUserOnStartup());
    }


}
