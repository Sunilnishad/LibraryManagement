package com.sunil.libmgr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/***
 * Created by Sunil Nishad
 * Created on Date:27/08/2024
 * In this test data is created while object creation.
 */

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Computer Science", true);
        library.addBook(book);
        assertEquals(1, library.listAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Computer Science", true);
        library.addBook(book);
        library.removeBook("123456789");
        assertEquals(0, library.listAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Computer Science", true);
        Book book2 = new Book("Java Concurrency in Practice", "Brian Goetz", "987654321", "Software Engineering", 2006, "Engineering", true);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> foundBooks = library.findBookByTitle("Effective Java");
        assertEquals(1, foundBooks.size());
        assertEquals("123456789", foundBooks.get(0).getISBN());
    }

    @Test
    public void testFindBookByAuthor() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Computer Science", true);
        Book book2 = new Book("Java Concurrency in Practice", "Brian Goetz", "987654321", "Software Engineering", 2006, "Engineering", true);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> foundBooks = library.findBookByAuthor("Joshua Bloch");
        assertEquals(1, foundBooks.size());
        assertEquals("123456789", foundBooks.get(0).getISBN());
    }

    @Test
    public void testListAllBooks() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Computer Science", true);
        Book book2 = new Book("Java Concurrency in Practice", "Brian Goetz", "987654321", "Software Engineering", 2006, "Engineering", true);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> allBooks = library.listAllBooks();
        assertEquals(2, allBooks.size());
    }

    @Test
    public void testListAvailableBooks() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", "123456789", "Programming", 2008, "Computer Science", true);
        Book book2 = new Book("Java Concurrency in Practice", "Brian Goetz", "987654321", "Software Engineering", 2006, "Engineering", false);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> availableBooks = library.listAvailableBooks();
        assertEquals(1, availableBooks.size());
        assertEquals("123456789", availableBooks.get(0).getISBN());
    }
}

