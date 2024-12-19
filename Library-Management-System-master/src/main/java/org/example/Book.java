package org.example;

public class Book {

    private int isbn; // Unique identifier for the book

    private String title;

    private String author;

    private int publicationYear;

    boolean isAvailable;

    User borrower; // User who currently has borrowed the book (null if available)

    public Book(String title, String author, int publicationYear) {

        isbn = super.hashCode();

        this.title = title;

        this.author = author;

        this.publicationYear = publicationYear;

        isAvailable = true; // by default book is available and borrower is null

        borrower = null;
    }

    // get isbn number of book
    public int getIsbn() {
        return isbn;
    }

    // get title of book
    public String getTitle() {
        return title;
    }

    // get author name of book
    public String getAuthor() {
        return author;
    }

    // get publicationyear of book
    public int getPublicationYear() {
        return publicationYear;
    }

    // get book details
    public String getBookDetail() {
        return "Isbn number = " + isbn + ", title = " + title + ", author = " + author + ", publication year = "
                + publicationYear;
    }

}