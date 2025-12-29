//Classe de testes unitarios da classe PhoneNumber
package tests.model;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneNumberTest{
    PhoneNumber phoneNumber1 = new PhoneNumber("+238 1111111");
    PhoneNumber phoneNumber2 = new PhoneNumber("+238 2222222");

    @Test
    public void validateAndTestPhoneNumber(){
        phoneNumber1.validatePhoneNumber("+238 1111111");
        phoneNumber2.validatePhoneNumber("+238 2222222");
        assertFalse(phoneNumber1.equalsToPhoneNumber("+238 2222222"));
    }
}