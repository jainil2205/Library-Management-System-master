package org.example;

import java.util.HashMap;

public class User {
    private String name;
    private String userId;
    private HashMap<Integer, Book> books = new HashMap<>(); // Stores books borrowed by the user, with ISBN as the key.

    public User(String name) {
        this.name = name;
        this.userId = "U" + super.hashCode(); // Unique user ID starts with 'U'
    }

    // Get user ID
    public String getUserId() {
        return userId;
    }

    // Get user name
    public String getUserName() {
        return name;
    }

    // Get user's details
    public String getUserDetails() {
        return "User's name = " + getUserName() + ", user's Id = " + getUserId();
    }

    // Borrow a book
    public String bookBorrow(Book book) {
        if (!book.isAvailable) {
            return "Book is not available";
        }
        book.isAvailable = false;
        books.put(book.getIsbn(), book);
        book.borrower = this;
        return "Book is borrowed";
    }

    // Return a book
    public String bookReturn(int isbn) {
        if (!books.containsKey(isbn)) {
            return "This user does not have this book";
        }
        Book book = books.get(isbn);
        book.isAvailable = true;
        book.borrower = null;
        books.remove(isbn);
        return "Book is returned";
    }
}
