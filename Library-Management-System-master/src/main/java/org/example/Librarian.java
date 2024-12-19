package org.example;

public class Librarian {
    private String name;

    private String password;

    private String librarianId; // Unique identifier for the librarian

    public Librarian(String name) {
        librarianId = "L" + super.hashCode(); // unique id for librarian start with 'L'
        this.password = "21028011"; // default 8 digit password for librarian
        this.name = name;
    }

    // change password of librarian account
    public String changePassword(String priviousPassword, String newPassword) {
        if (!priviousPassword.equals(this.password)) {
            return "Please enter valid old password"; // before change password you need to enter old password.
        }
        if (newPassword.length() != 8) {
            return "password length is should be 8";
        }
        this.password = newPassword;
        return "password set succesfully";
    }

    // get librarian name
    public String getLibrarianName() {
        return name;
    }

    // get llibrarian id
    public String getLibrarianId() {
        return librarianId;
    }

    // get librarian password
    public String getLibrarianPassword() {
        return password;
    }

    // change librarian name
    public String changeLibrarianName(String name) {
        this.name = name;
        return "librarian name set";
    }

    // get librarian details
    public String getLibrarianDetail() {
        return "Librarian name = " + getLibrarianName() + ", librarian id = " + getLibrarianId();
    }

}
