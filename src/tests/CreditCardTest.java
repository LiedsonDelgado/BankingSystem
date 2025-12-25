//Classe de testes unitarios da classe CreditCard
package tests;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

class CreditCardTest{
    CreditCard c1 = new CreditCard(1111,"1111-1111-1111-1111","Bank 1", CardTypes.MASTERCARD);
    CreditCard c2 = new CreditCard(2222,"2222-2222-2222-2222","Bank 1",CardTypes.AMERICANEXPRESS);
    CreditCard c3 = new CreditCard(3333,"3333-3333-3333-3333","Bank 1",CardTypes.VISA);
}
