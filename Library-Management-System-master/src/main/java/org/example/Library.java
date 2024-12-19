package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Library {

    public Librarian librarian; // every library have multiple books and multiple user and one librarian

    public HashMap<Integer, Book> books = new HashMap<>(); // stores book of library , with isbn as key

    public HashMap<String, User> users = new HashMap<>(); // stores users of library , with userid as key

    public Library(String librarianName) {
        librarian = new Librarian(librarianName); // librarian is allocated during creation of Library class's object.
    }

    // change password of librarian
    public String changeLibrarianPassword(String priviousPassword, String newPassword) {
        return librarian.changePassword(priviousPassword, newPassword);
    }

    // change librariane name
    public String changeLibrarianName(String name) {
        return librarian.changeLibrarianName(name);
    }

    // get details of librarian
    public String getLibrarianDetail() {
        return "name = " + librarian.getLibrarianName() + ", librarian id = " + librarian.getLibrarianId();
    }

    //add books in library
    public String addBook(String title, String author, int publicationYear, String password) {
        if (!password.equals(librarian.getLibrarianPassword())) {
            return "wrong password entered";
        }
        if (author == null || author.equals("")) {
            return "wrong auther";
        }
        if (title == null || title.equals("")) {
            return "wrong title";
        }
        if (!(publicationYear >= 0 && publicationYear <= 2024)) {
            return "wrong publicationyear";
        }
        Book book = new Book(title, author, publicationYear);
        books.put(book.getIsbn(), book);
        return "book added";
    }

    // register user in library
    public String addUser(String name) {
        if (name == null || name.equals("")) {
            return "Invalid name";
        }
        User user = new User(name);
        users.put(user.getUserId(), user);
        return "User added";
    }

    //Borrow book
    public String bookBorrow(int isbn, String userId) {
        if (!books.containsKey(isbn)) {
            return "book is not exists";
        }
        return users.get(userId).bookBorrow(books.get(isbn));
    }

    //Return book
    public String bookReturn(int isbn, String userId) {
        if (!books.containsKey(isbn)) {
            return "book is not exists";
        }
        return users.get(userId).bookReturn(isbn);
    }

    //view list of available books
    public ArrayList<Book> availableBooks() {
        Set<Integer> keys = books.keySet();
        ArrayList<Book> availablebooks = new ArrayList<>();
        for (int key : keys) {
           if(books.get(key).isAvailable){ availablebooks.add(books.get(key));}
        }
        return availablebooks;
    }

}
