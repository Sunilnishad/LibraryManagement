package com.sunil.libmgr;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private Scanner scanner;

    public LibraryMenu(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    findBookByAuthor();
                    break;
                case 5:
                    listAllBooks();
                    break;
                case 6:
                    listAvailableBooks();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Is the book available (true/false): ");
        boolean availability = scanner.nextBoolean();

        Book book = new Book(title, author, ISBN, genre, publicationYear, department, availability);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private void removeBook() {
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
        System.out.println("Book removed successfully.");
    }

    private void findBookByTitle() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with the given title.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void findBookByAuthor() {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found by the given author.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void listAllBooks() {
        List<Book> books = library.listAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void listAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("No available books in the library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        LibraryMenu menu = new LibraryMenu(library);
        menu.showMenu();
    }
}

