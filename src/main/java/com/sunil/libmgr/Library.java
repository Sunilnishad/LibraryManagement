package com.sunil.libmgr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (books.stream().noneMatch(b -> b.getISBN().equals(book.getISBN()))) {
            books.add(book);
        } else {
            System.out.println("Book with ISBN " + book.getISBN() + " already exists.");
        }
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }

    public List<Book> findBookByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Book> findBookByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> listAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> listAvailableBooks() {
        return books.stream()
                .filter(Book::isAvailability)
                .collect(Collectors.toList());
    }
}

