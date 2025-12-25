//Classe de testes unitarios da classe Manager
package tests;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

class ManagerTest{
    Bank bank = new Bank("Bank 1","No Where",111111);

    Manager m1 = new Manager("Manager 1","manager1@gmail.com","Position 1","+238 1111111","Specialization 1", ExperienceLevel.JUNIORLEVEL,"100000",bank,bank.getListOfClients(),bank.getListOfAccounts());
    Manager m2 = new Manager("Manager 2","manager2@gmail.com","Position 2","+238 2222222","Specialization 2", ExperienceLevel.MIDLEVEL,"200000",bank,bank.getListOfClients(),bank.getListOfAccounts());
    Manager m3 = new Manager("Manager 3","manager3@gmail.com","Position 3","+238 3333333","Specialization 3", ExperienceLevel.SENIORLEVEL,"300000",bank,bank.getListOfClients(),bank.getListOfAccounts());
}
