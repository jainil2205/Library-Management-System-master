import org.example.Library;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibrarianTest {

    @Test
    @DisplayName("should change librarian name whenever librarian change the name")
    void testChangeLibrarianName(){
        Library library = new Library("jainil doshi");
        library.changeLibrarianName("vinayak chavda");
        Assertions.assertEquals(library.librarian.getLibrarianName() , "vinayak chavda");
    }

    @Test
    @DisplayName("should change librarian password whenever librarian change the password")
    void testChangeLibrarianPassword(){
        Library library = new Library("jainil doshi");

        Assertions.assertEquals(library.changeLibrarianPassword("21028011","3467") , "password length is should be 8");
        Assertions.assertEquals(library.changeLibrarianPassword("21028011","3463556733") , "password length is should be 8");
        Assertions.assertEquals(library.changeLibrarianPassword("210280116083","23467434") , "Please enter valid old password");
        Assertions.assertEquals(library.changeLibrarianPassword("21028011","34231201"),"password set succesfully");
        Assertions.assertEquals(library.librarian.getLibrarianPassword(), "34231201");

    }

    @Test
    @DisplayName("should get true librarian details")
    void testGetLibrarianDetails(){
        Library library = new Library("jainil doshi");
        library.changeLibrarianName("vinayak chavda");
        Assertions.assertTrue(library.getLibrarianDetail().contains("name = vinayak chavda")); //getLibrarianDetail() function return name = 'name of librarian', librarian id = 'unique librarian id'. so this function contains "name = vinayak chavda"
    }

}
