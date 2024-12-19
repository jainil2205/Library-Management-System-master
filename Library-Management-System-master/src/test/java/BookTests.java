import org.example.Book;
import org.example.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

public class BookTests {

    @Test
    @DisplayName("should give warning whenever user try to enter book with invalid detail")
    void testAddBookWarning(){
        Library library = new Library("jainil doshi");
        Assertions.assertEquals("wrong password entered",library.addBook("Around the World in Eighty Days","Jules Verne",1872,"210280116"));
        Assertions.assertEquals( "wrong auther",library.addBook("Around the World in Eighty Days","",1872,"21028011"));
        Assertions.assertEquals("wrong auther",library.addBook("Around the World in Eighty Days",null,1872,"21028011"));
        Assertions.assertEquals("wrong title",library.addBook("","Jules Verne",1872,"21028011"));
        Assertions.assertEquals("wrong title",library.addBook(null,"Jules Verne",1872,"21028011"));
        Assertions.assertEquals("wrong publicationyear",library.addBook("Around the World in Eighty Days","Jules Verne",-300,"21028011"));
        Assertions.assertEquals("wrong publicationyear",library.addBook("Around the World in Eighty Days","Jules Verne",2055,"21028011"));
    }

    @Test
    @DisplayName("should add book whenever enter book with valid details")
    void testAddBook(){
        Library library = new Library("jainil doshi");
        Assertions.assertEquals( "book added",library.addBook("Around the World in Eighty Days","Jules Verne",1872,"21028011"));
        library.addBook("The Intelligent Investor","Benjamin Graham",1949,"21028011");
        Assertions.assertEquals(2,library.books.size()); //2 book was added so books hashmap of Library class has should be 2 size.
    }

    @Test
    @DisplayName("should show valid available book list")
    void testAvailableBookList(){
        Library library = new Library("jainil doshi");
        library.addBook("Around the World in Eighty Days","Jules Verne",1872,"21028011");
        library.addBook("The Intelligent Investor","Benjamin Graham",1949,"21028011");
        library.addBook("The Road","Cormac McCarthy",2006,"21028011");
        library.addBook("The Night Circus","Erin Morgenstern",2011,"21028011");
        library.addUser("jainil ");
        library.addUser("parth");
        library.addUser("vinayak");
        library.addUser("jayesh");
        ArrayList<String> keyUserList = getUserKeys(library);
        ArrayList<Integer> keyBookList = getBookKeys(library);

        library.bookBorrow(keyBookList.get(0),keyUserList.get(0));
        library.bookBorrow(keyBookList.get(1),keyUserList.get(1));

        ArrayList<Book> availableBooks = library.availableBooks();
        Assertions.assertEquals(2,availableBooks.size()); //2 books are availble

        library.bookBorrow(keyBookList.get(3),keyUserList.get(3));
        availableBooks = library.availableBooks();
        Assertions.assertEquals(1,availableBooks.size()); //1 book is availble

        library.bookReturn(keyBookList.get(1),keyUserList.get(1));
        Assertions.assertEquals(1,availableBooks.size()); //2 book are availble

    }

    //get list of keys of user hashmap of Library class.
    ArrayList<String> getUserKeys(Library library){
        Set<String> keys = library.users.keySet();
        ArrayList<String> keyList = new ArrayList<>();
        for(String key : keys){
            keyList.add(key);
        }
        return keyList;
    }

    //get list of keys of books hashmap of Library class.
    ArrayList<Integer> getBookKeys(Library library){
        Set<Integer> keys = library.books.keySet();
        ArrayList<Integer> keyList = new ArrayList<>();
        for(Integer key : keys){
            keyList.add(key);
        }
        return keyList;
    }
}
