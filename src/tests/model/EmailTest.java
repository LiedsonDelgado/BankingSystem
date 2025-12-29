//Classe de testes unitarios da classe Email
package tests.model;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmailTest{
    Email email1 = new Email("email1@gmail.com");
    Email email2 = new Email("email2@gmail.com");

    @Test
    public void validateAndCompareEmail(){
        email1.validateEmail("email1@gmail.com");
        email1.validateEmail("email2@gmail.com");
        assertFalse(email1.equalsToEmail("email2@gmail.com"));
    }
}