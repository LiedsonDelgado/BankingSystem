//Classe de testes unitarios da classe Email
package tests.model;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmailTest{
    String emailString = "email1@gmail.com";
    Email email = new Email(emailString);

    @Test
    public void validateAndCompareEmail(){
        email.validateEmail(emailString);
        assertTrue(email.equalsToEmail("email1@gmail.com"));
    }
}