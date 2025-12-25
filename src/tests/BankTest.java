//Classe de testes unitarios da classe Bank
package tests;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

class BankTest{
    Bank bank = new Bank("Bank 1","No Where",111111);

    CreditCard c1 = new CreditCard(1111,"1111-1111-1111-1111","Bank 1",CardTypes.MASTERCARD);
    CreditCard c2 = new CreditCard(2222,"2222-2222-2222-2222","Bank 1",CardTypes.AMERICANEXPRESS);
    CreditCard c3 = new CreditCard(3333,"3333-3333-3333-3333","Bank 1",CardTypes.VISA);

    Account a1 = new Account("Account 1","111111111","Bank 1","",true,c1);
    Account a2 = new Account("Account 2","222222222","Bank 1","",true,c2);
    Account a3 = new Account("Account 3","333333333","Bank 1","",true,c3);

    Manager m1 = new Manager("Manager 1","manager1@gmail.com","Position 1","+238 1111111","Specialization 1", ExperienceLevel.JUNIORLEVEL,"100000",bank,bank.getListOfClients(),bank.getListOfAccounts());
    Manager m2 = new Manager("Manager 2","manager2@gmail.com","Position 2","+238 2222222","Specialization 2", ExperienceLevel.MIDLEVEL,"200000",bank,bank.getListOfClients(),bank.getListOfAccounts());
    Manager m3 = new Manager("Manager 3","manager3@gmail.com","Position 3","+238 3333333","Specialization 3", ExperienceLevel.SENIORLEVEL,"300000",bank,bank.getListOfClients(),bank.getListOfAccounts());

    StaffMember s1 = new StaffMember("Staff 1","staff1@gmail.com","+238 1111111","10000",ExperienceLevel.JUNIORLEVEL,bank);
    StaffMember s2 = new StaffMember("Staff 2","staff2@gmail.com","+238 2222222","20000",ExperienceLevel.MIDLEVEL,bank);
    StaffMember s3 = new StaffMember("Staff 3","staff3@gmail.com","+238 3333333","30000",ExperienceLevel.SENIORLEVEL,bank);

    Worker w1 = new Worker("Worker 1","worker1@gmail.com","+238 1111111","1000",ExperienceLevel.JUNIORLEVEL,bank);
    Worker w2 = new Worker("Worker 2","worker2@gmail.com","+238 2222222","2000",ExperienceLevel.MIDLEVEL,bank);
    Worker w3 = new Worker("Worker 3","worker3@gmail.com","+238 3333333","3000",ExperienceLevel.SENIORLEVEL,bank);
}
