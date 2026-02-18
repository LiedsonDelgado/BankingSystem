//Classe de testes unitarios da classe Client
package tests.model;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClientTest{
    Bank bank = new Bank("Bank 1","No Where",111111);
    CreditCard card = new CreditCard(1111,"1111-1111-1111-1111",bank,CardTypes.VISA);
    Account account = new Account("Account 1","111-111-111",bank,"100000",true,card);
    Client client = new Client("Client 1","client1@gmail.com","01/01/2001","No where","+238 1111111","1111",18,account);

    @Test
    public void validateClientAge(){
        assertTrue(client.validateAge(18));
    }
}
