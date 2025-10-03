package com.pluralsight;

import java.util.Scanner;

public class Library {

    private static Book[] books = new Book[20];

    private static int numBooks = 6;

    public static void main(String[] args) {
        Scanner scannerBooks = new Scanner(System.in);

        books[0] = new Book(1, "978-0-123456-47-2", "To Kill a Mockingbird", false, "");
        books[1] = new Book(2, "978-0-987654-32-1", "1984", false, "");
        books[2] = new Book(3, "978-1-234567-89-7", "The Great Gatsby", false, "");
        books[3] = new Book(4, "978-0-543210-98-6", "Moby Dick", false, "");
        books[4] = new Book(5, "978-1-111111-11-1", "Pride and Prejudice", false, "");
        books[5] = new Book(6, "978-9-876543-21-0", "The Catcher in the Rye", false, "");

        boolean completed = false;

        while (!completed){
            System.out.println("-------------------");
            System.out.println("The Home Page: ");
            System.out.println("-------------------");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out books");
            System.out.println("3. Exit");

            int userInput = scannerBooks.nextInt();

            switch (userInput) {
                case 1:
                    listAllBooks(); // lists all the books
                    takeBookOrExit(scannerBooks); // menu between taking a book or exiting to main menu

                    break;
                case 2:
                    listCheckedOutBooks();
                    break;
                case 3:
                    System.out.println("Left the program");
                    completed = true;
                    break;
                default:
                    System.out.println("Wrong input, try again");
                    break;

            } // switch ends here

        } // while ends here

    } // main method ends here

    public static void listCheckedOutBooks (){
        System.out.println("All Books that are checked out: ");

        for (int i = 0; i < numBooks; i++) {
            if (books[i].isCheckedOut()){
                System.out.println(books[i]);
            }
        }
    }

    public static void listAllBooks(){
        System.out.println("All Books: ");

        // only shows the books that aren't checked out
        for (int i = 0; i < numBooks; i++) {
            if (!books[i].isCheckedOut())
                System.out.println(books[i]);
        }
    }

    public static void takeBookOrExit (Scanner scanner){
        System.out.println("1. select a book to check out");
        System.out.println("2. Exit to main menu");
        int command = scanner.nextInt();

        switch (command) {
            case 1:
                checkOutBook(scanner); // checks out the book
                break;
            case 2:
                System.out.println("Exiting to home page");
                break;
            default:
                System.out.println("Wrong Input, Try Again");
        }
    }

    public static void checkOutBook (Scanner scanner){
        System.out.println("what is the book id: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < numBooks; i++) {
            if (books[i].getId() == bookId){
                books[i].setCheckedOut(true);

                System.out.println("What is your name: ");
                String nameOnCheckout = scanner.nextLine();
                books[i].setCheckedOutTo(nameOnCheckout);

                System.out.println("You have checked out: " + books[i].getTitle());

                found = true;
            }
        }

        if (!found){
            System.out.println("No books matching that id");
        }

    }

}
