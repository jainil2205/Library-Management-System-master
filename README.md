# Library-Management-System-master

## Description

welcome to Library Management System, a simple library management system that allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books developed using java and Test-Driven Development(TDD) technique.

## Problem Statment

Create a simple library management system that allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books.


## Development Tools

Developed using:
- Intelij Idea
- Java
- Junit
- object-orieanted-programming

## classes

Library Management System is devided into 4 class

1. **Library**
2. **Librarian**
3. **User**
4. **Book**

## Details of Library Management System 

### Library

The `Library` class is responsible for managing the overall functionality of the library, including book management and user registration. It contains methods for adding and managing books, registering users, borrowing and returning books, and handling librarian details.

Key methods in the `Library` class include:
- **`addBook`**: Adds a new book to the library's collection, ensuring it is registered with the correct details.
- **`addUser`**: Registers a new user to the library, allowing them to borrow and return books.
- **`bookAllot`**: Allows a registered user to borrow a book, provided the book is available.
- **`bookReturn`**: Handles the return of a borrowed book and updates its availability status.
- **`changeLibrarianPassword`**: Allows the librarian to change their password.
- **`getLibrarianDetail`**: Provides details about the librarian, including their name and ID.
- **`availableBooks`**: Returns a list of all books currently available for borrowing.

The class uses Java's `HashMap` to store books and users, ensuring efficient access and management of library resources.

### Librarian

The `Librarian` class manages the details of the librarian, who is responsible for overseeing the library's operations. This class includes functionality for managing the librarian's personal information and account security.

Key features of the `Librarian` class include:
- **Librarian Identification**: Each librarian is assigned a unique identifier (`librarianId`) that starts with the letter 'L'.
- **Default Password**: Upon creation, a librarian is given a default 8-digit password.
- **Password Management**: The librarian can change their password using the `changePassword` method, which requires entering the current password and setting a new 8-character password.
- **Name Management**: Methods like `changeLibrarianName` and `getLibrarianName` allow for changing and retrieving the librarian's name.
- **Details Retrieval**: The `getLibrarianDetail` method provides a summary of the librarian's name and ID for administrative purposes.

The `Librarian` class ensures that each librarian's credentials are secure and provides functions for managing personal data and password protection.

**Note:** One library have only one librarian

### User

The `User` class represents a library user who can borrow and return books. It manages user-specific information and interactions with the library's collection.

Key features of the `User` class include:
- **User Identification**: Each user is assigned a unique identifier (`userId`) that starts with the letter 'U'.
- **Book Borrowing**: Users can borrow books if they are available. The `bookBorrow` method updates the book's availability status and associates it with the user.
- **Book Returning**: Users can return books they have borrowed. The `bookReturn` method makes the book available again and removes it from the user's collection.
- **User Details**: Methods such as `getUserDetails` provide information about the user's name and ID.

The `User` class manages the list of books borrowed by the user and ensures that book borrowing and returning operations are handled correctly.

### Book

The `Book` class represents a book in the library, containing details about the book and its availability status.

Key features of the `Book` class include:
- **Book Identification**: Each book is assigned a unique identifier (`isbn`) using a hash code.
- **Book Details**: The class holds information about the book's title, author, and publication year.
- **Availability Status**: The `isAvailable` boolean indicates whether the book is currently available for borrowing.
- **Borrower Management**: The `borrower` field keeps track of the user who currently has borrowed the book (or is `null` if available).
- **Book Details Retrieval**: The `getBookDetail` method provides a summary of the book's ISBN, title, author, and publication year.

The `Book` class ensures that each book's details are stored and managed correctly, including its availability status and current borrower.

## Testing

The Library Management System uses JUnit for testing to ensure that all functionalities of the classes work as expected. Below are the details of the test classes used:

1. **BookTest**
2. **LibrarianTest**
3. **UserTest**

### BookTest

The `BookTest` class tests the functionality of the `Book` class and the interactions related to book management within the `Library` class. It ensures that the `Library` class correctly handles book-related operations, including adding books and retrieving available books. 

Key test cases in the `BookTest` class include:

- **Testing Invalid Book Details**:
  - **`testAddBookWarning`**: Verifies that the system provides appropriate warnings when attempting to add a book with invalid details. This includes incorrect passwords, missing or invalid titles, authors, and publication years.

- **Testing Valid Book Addition**:
  - **`testAddBook`**: Checks that books with valid details are successfully added to the library. It also confirms that the `books` HashMap in the `Library` class correctly reflects the number of books added.

- **Testing Available Book List**:
  - **`testAvailableBookList`**: Validates that the list of available books is accurate. The test involves adding several books, borrowing some of them, and checking that the available book count updates correctly when books are borrowed and returned.

The `BookTest` class also includes helper methods:
- **`getUserKeys(Library library)`**: Retrieves a list of user IDs from the library's user HashMap.
- **`getBookKeys(Library library)`**: Retrieves a list of book ISBNs from the library's book HashMap.

These helper methods assist in managing and accessing test data for the various scenarios being tested.


### LibrarianTest

The `LibrarianTest` class tests the functionality of the `Librarian` class within the `Library` system. It focuses on the management and security aspects related to the librarian's personal details.

Key test cases in the `LibrarianTest` class include:

- **Testing Librarian Name Change**:
  - **`testChangeLibrarianName`**: Verifies that the librarian's name is updated correctly. The test checks that after changing the librarian’s name, the new name is accurately reflected in the library's details.

- **Testing Librarian Password Change**:
  - **`testChangeLibrarianPassword`**: Checks the process of changing the librarian’s password. It validates various scenarios:
    - Entering a new password of incorrect length.
    - Providing an incorrect old password.
    - Successfully updating the password with a valid old password and a new 8-character password.
  - The test ensures that after a successful password change, the new password is correctly stored and retrieved.

- **Testing Librarian Details Retrieval**:
  - **`testGetLibrarianDetails`**: Verifies that the `getLibrarianDetail` method returns accurate details about the librarian. The test checks if the returned details include the updated name and correct librarian ID.

These test classes help maintain the integrity of the Library Management System by ensuring that all methods and functionalities perform as expected. They are an essential part of the development process and provide confidence in the system's reliability and correctness.


### UserTest

The `UserTest` class focuses on testing the `User` class and its interactions with the `Library` class. It verifies that user-related functionalities work correctly, including adding users, borrowing and returning books, and handling edge cases.

Key test cases in the `UserTest` class include:

- **Testing Invalid User Details**:
  - **`testAddUserWarning`**: Ensures that the system provides warnings when attempting to add a user with invalid details, such as `null` or an empty name.

- **Testing Valid User Addition**:
  - **`testAddUser`**: Verifies that users with valid details are successfully added to the library. It checks that the `users` HashMap in the `Library` class reflects the correct number of added users.

- **Testing Borrowing of Unavailable Books**:
  - **`testWarningOfUnavailableBook`**: Ensures that the system provides a warning when attempting to borrow a book that is already borrowed by another user.

- **Testing Borrowing Non-Existent Books**:
  - **`testWarningOfNotExistsBook`**: Validates that a warning is issued if a user tries to borrow a book that does not exist in the library.

- **Testing Successful Book Borrowing**:
  - **`borrowBook`**: Confirms that a book can be successfully borrowed if it is available and exists in the library.

- **Testing Returning Non-Existent Books**:
  - **`testWarningOfNotExistsBookReturn`**: Ensures that the system provides a warning if a user tries to return a book that does not exist in the library.

- **Testing Returning Books Not Borrowed by the User**:
  - **`testWarningOfReturnNotHaveBook`**: Validates that a warning is issued if a user tries to return a book they do not have.

- **Testing Successful Book Return**:
  - **`testReturnBook`**: Confirms that a book is successfully returned if it was borrowed by the user.

The `UserTest` class also includes helper methods:
- **`addTestUsersAndBooks(Library library)`**: Adds predefined users and books to the library for testing purposes.
- **`getUserKeys(Library library)`**: Retrieves a list of user IDs from the library's user HashMap.
- **`getBookKeys(Library library)`**: Retrieves a list of book ISBNs from the library's book HashMap.

These test classes help maintain the integrity of the Library Management System by ensuring that all methods and functionalities perform as expected. They are an essential part of the development process and provide confidence in the system's reliability and correctness.

## Additional Featuers

1. **One Librarian:** one library have only one librarian.
2. **Password Authentication:** for changing password of librarian you need to enter old password of librarian.
3. **Add Book Authority:** librarian only have authority of adding book in library, and librarian need to enter his password before adding book in library.

## Feedback

We appreciate your feedback! If you have any suggestions or find any issues, please open an issue or reach out to us.

## Setup for Running the Project

1.**Install IntelliJ IDEA:**
  Download and install IntelliJ IDEA from [JetBrains.](https://www.jetbrains.com/idea/download/?section=windows)

2.**Set Up JUnit 5 and Learn the Basics:**
  Configure JUnit 5 with IntelliJ IDEA and familiarize yourself with the basics of JUnit testing by reading the [JetBrains Blog.](https://blog.jetbrains.com/idea/2020/09/writing-tests-with-junit-5/)

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/jainil2205/Library-Management-System-master

2. **Open the Project in IntelliJ IDEA:**
  Open the cloned project in IntelliJ IDEA.

3. **Explore the Code and Run Tests:**
  Review the code and execute tests to ensure everything is working correctly.

## Test Coverage

### Book Test

The Book test coverage of this project is **84%**.

https://drive.google.com/file/d/1Pp1Fy02o63kQbtMBMzW3tlDl76UYrqIn/view?usp=sharing


### Librarian Test

The Librarian test coverage of this project is **100%**.


https://drive.google.com/file/d/1dXjlzd9_ZQ9aEUj77LG00c4mNDvkUsSK/view?usp=sharing

### User Test

The User test coverage of this project is **57%**.


https://drive.google.com/file/d/1pUchVlXjws8QLOHM7EM3oK4GkLq_VZjH/view?usp=sharing
