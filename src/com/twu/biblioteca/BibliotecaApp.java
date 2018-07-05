package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        UserGreeter startup = new UserGreeter();
        System.out.println("*****************************************************************");
        System.out.println("*** " + startup.greetUserOnStart() + " ***");
        System.out.println("*****************************************************************");


        UserMenuOptionsAndMessages userOptions = new UserMenuOptionsAndMessages();
        LibraryDatabase database = new LibraryDatabase();
        BookPrinter bookPrinter = new BookPrinter();
        Scanner reader = new Scanner(System.in);

        System.out.println();
        System.out.println(userOptions.listBooksOption());
        System.out.println(userOptions.generalCheckoutOption());
        System.out.println(userOptions.generalReturnOption());
        System.out.println(userOptions.quitOption());
        String userInput = reader.nextLine();

        while (true) {

            if (userInput.equals("list books")) {
                System.out.println();
                System.out.println("Currently available books:");
                System.out.println();
                bookPrinter.printBooksInfoToScreen(database.getCurrentBooks());
                System.out.println();
                System.out.println(userOptions.generalCheckoutOption());
                System.out.println(userOptions.generalReturnOption());
                System.out.println(userOptions.quitOption());
                userInput = reader.nextLine();
            } else if(userInput.equals("checkout")) {
                System.out.println();
                System.out.println(userOptions.checkoutBookOption());
                userInput = reader.nextLine();

                if (database.processCheckoutRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.checkoutSuccessMessage());
                    System.out.println();
                    System.out.println(userOptions.listBooksOption());
                    System.out.println(userOptions.generalCheckoutOption());
                    System.out.println(userOptions.generalReturnOption());
                    System.out.println(userOptions.quitOption());
                    userInput = reader.nextLine();
                } else {
                    System.out.println();
                    System.out.println(userOptions.checkoutFailMessage());
                    System.out.println();
                    System.out.println(userOptions.listBooksOption());
                    System.out.println(userOptions.generalCheckoutOption());
                    System.out.println(userOptions.generalReturnOption());
                    System.out.println(userOptions.quitOption());
                    userInput = reader.nextLine();
                }

            } else if (userInput.equals("return")) {
                System.out.println();
                System.out.println(userOptions.returnBookOption());
                userInput = reader.nextLine();

                if (database.processReturnRequestFromUser(userInput)) {
                    System.out.println();
                    System.out.println(userOptions.returnSuccessMessage());
                    System.out.println();
                    System.out.println(userOptions.listBooksOption());
                    System.out.println(userOptions.generalCheckoutOption());
                    System.out.println(userOptions.generalReturnOption());
                    System.out.println(userOptions.quitOption());
                    userInput = reader.nextLine();
                } else {
                    System.out.println();
                    System.out.println(userOptions.returnFailMessage());
                    System.out.println();
                    System.out.println(userOptions.listBooksOption());
                    System.out.println(userOptions.generalCheckoutOption());
                    System.out.println(userOptions.generalReturnOption());
                    System.out.println(userOptions.quitOption());
                    userInput = reader.nextLine();
                }

            } else if (userInput.equals("quit")) {
                System.out.println();
                System.out.println("Good bye!");
                reader.close();
                break;
            } else {
                System.out.println(userOptions.invalidOption());
                System.out.println(userOptions.listBooksOption());
                System.out.println(userOptions.generalCheckoutOption());
                System.out.println(userOptions.generalReturnOption());
                System.out.println(userOptions.quitOption());
                userInput = reader.nextLine();
            }
        }
    }

}
