//Classe de testes unitarios da classe Manager
package tests.model;
import enums.*;
import model.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManagerTest{
    Bank bank = new Bank("Bank 1","No Where",111111);
    CreditCard card = new CreditCard(1111,"1111-1111-1111-1111",bank,CardTypes.VISA);
    Account account = new Account("Account 1","111-111-111",bank,"100000",true,card);
    Client client = new Client("Client 1","client1@gmail.com","01/01/2001","No where","+238 1111111","1111",18,account);

    Manager manager = new Manager("Manager 1","manager1@gmail.com","Geral Management","+238 1111111","Bank Management",ExperienceLevel.SENIORLEVEL,"150000",bank,bank.getListOfClients(),bank.getListOfAccounts());

    @Test
    public void getNumOfClientsAfterAdd(){
        manager.addClientToList(client,true);
        assertEquals(1,manager.getNumsOfClientsOnList());
    }

    @Test
    public void getNumOfClientsAfterRemove(){
        manager.removeClientFromList(client,true);
        assertEquals(0,manager.getNumsOfClientsOnList());
    }

    @Test
    public void getNumOfAccountsAfterAdd(){
        manager.addAccountToList(account,true);
        assertEquals(1,manager.getNumsOfAccountsOnList());
    }

    @Test
    public void getNumOfAccountsAfterRemove(){
        manager.removeAccountFromList(account,true);
        assertEquals(0,manager.getNumsOfAccountsOnList());
    }
}
