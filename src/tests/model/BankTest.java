//Classe de testes unitarios da classe Bank
package tests.model;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest{
    Bank bank = new Bank("Bank 1","No Where",111111);

    CreditCard c1 = new CreditCard(1111,"1111-1111-1111-1111","Bank 1",CardTypes.MASTERCARD);
    CreditCard c2 = new CreditCard(2222,"2222-2222-2222-2222","Bank 1",CardTypes.AMERICANEXPRESS);
    CreditCard c3 = new CreditCard(3333,"3333-3333-3333-3333","Bank 1",CardTypes.VISA);

    Account a1 = new Account("Account 1","111111111","Bank 1","1000",true,c1);
    Account a2 = new Account("Account 2","222222222","Bank 1","2000",true,c2);
    Account a3 = new Account("Account 3","333333333","Bank 1","3000",true,c3);

    Client client1 = new Client("Client 1","client1@gmail.com","01/01/2007","No Location","+238 1111111","111-111-111",18,a1);
    Client client2 = new Client("Client 2","client2@gmail.com","01/01/1995","No Location","+238 2222222","222-222-222",30,a2);
    Client client3 = new Client("Client 3","client3@gmail.com","01/01/1985","No Location","+238 3333333","333-333-333",40,a3);

    StaffMember s1 = new StaffMember("Staff 1","staff1@gmail.com","+238 1111111","10000",ExperienceLevel.JUNIORLEVEL,bank);
    StaffMember s2 = new StaffMember("Staff 2","staff2@gmail.com","+238 2222222","20000",ExperienceLevel.MIDLEVEL,bank);
    StaffMember s3 = new StaffMember("Staff 3","staff3@gmail.com","+238 3333333","30000",ExperienceLevel.SENIORLEVEL,bank);

    Worker w1 = new Worker("Worker 1","worker1@gmail.com","+238 1111111","1000",ExperienceLevel.JUNIORLEVEL,bank);
    Worker w2 = new Worker("Worker 2","worker2@gmail.com","+238 2222222","2000",ExperienceLevel.MIDLEVEL,bank);
    Worker w3 = new Worker("Worker 3","worker3@gmail.com","+238 3333333","3000",ExperienceLevel.SENIORLEVEL,bank);

    Manager manager1 = new Manager("Manager 1","manager1@gmail.com","Position 1","+238 1111111","Specialization 1", ExperienceLevel.JUNIORLEVEL,"100000",bank,bank.getListOfClients(),bank.getListOfAccounts());

    @Test
    public void infoAboutTheBank(){
        assertEquals("Bank 1",bank.getBankName());
        assertEquals(0,bank.getNumberOfCardsFromBank());
        assertEquals(0,bank.getNumberOfAccountsFromBank());
        assertEquals(0,bank.getNumberOfClientsFromBank());
    }

    @Test
    public void contractManager(){
        bank.addEmployeeToBank(manager1,true);
        assertEquals(1,bank.getNumberOfEmployessFromBank());
    }

    @Test
    public void contractEmployees(){
        manager1.getEmployeeBank().addEmployeeToBank(s1,true);
        manager1.getEmployeeBank().addEmployeeToBank(s2,true);
        manager1.getEmployeeBank().addEmployeeToBank(s3,true);

        manager1.getEmployeeBank().addEmployeeToBank(w1,true);
        manager1.getEmployeeBank().addEmployeeToBank(w2,true);
        manager1.getEmployeeBank().addEmployeeToBank(w3,true);
        assertEquals(6,manager1.getEmployeeBank().getNumberOfEmployessFromBank());
    }

    @Test
    public void createdCards(){
        manager1.getEmployeeBank().addCardToBank(c1,true);
        manager1.getEmployeeBank().addCardToBank(c2,true);
        manager1.getEmployeeBank().addCardToBank(c3,true);
        assertEquals(3,manager1.getEmployeeBank().getNumberOfCardsFromBank());
    }

    @Test
    public void createAccounts(){
        manager1.getEmployeeBank().addAccountToBank(a1,true);
        manager1.getEmployeeBank().addAccountToBank(a2,true);
        manager1.getEmployeeBank().addAccountToBank(a3,true);
        assertEquals(3,manager1.getEmployeeBank().getNumberOfAccountsFromBank());
    }

    @Test
    public void associateClients(){
        manager1.getEmployeeBank().addClientToBank(client1,true);
        manager1.getEmployeeBank().addClientToBank(client2,true);
        manager1.getEmployeeBank().addClientToBank(client3,true);
        assertEquals(3,manager1.getEmployeeBank().getNumberOfClientsFromBank());
    }

    @Test
    public void removeAccounts(){
        manager1.getEmployeeBank().removeAccountFromBank(a1,true);
        manager1.getEmployeeBank().removeAccountFromBank(a2,true);
        manager1.getEmployeeBank().removeAccountFromBank(a3,true);
        assertEquals(0,manager1.getEmployeeBank().getNumberOfAccountsFromBank());
    }

    @Test
    public void fireEmployees(){
        manager1.getEmployeeBank().removeEmployeeFromBank(w1,true);
        manager1.getEmployeeBank().removeEmployeeFromBank(w2,true);
        manager1.getEmployeeBank().removeEmployeeFromBank(w3,true);

        manager1.getEmployeeBank().removeEmployeeFromBank(s1,true);
        manager1.getEmployeeBank().removeEmployeeFromBank(s2,true);
        manager1.getEmployeeBank().removeEmployeeFromBank(s3,true);
        assertEquals(0,manager1.getEmployeeBank().getNumberOfEmployessFromBank());
    }

    @Test
    public void fireManager(){
        bank.removeEmployeeFromBank(manager1,true);
        assertEquals(0,manager1.getEmployeeBank().getNumberOfEmployessFromBank());
    }
}
