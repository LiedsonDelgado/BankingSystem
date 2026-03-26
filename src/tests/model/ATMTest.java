//Classe de testes unitarios da classe ATM
package tests.model;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ATMTest{
    Bank bank = new Bank("Bank 1","No Where",111111);
    ATM atm = new ATM("No Where",bank,ATMStatus.ACTIVO,Languages.PTPT,"1000000");
    CreditCard card1 = new CreditCard(1111,"1111-1111-1111-1111",bank,CardTypes.VISA);
    CreditCard card2 = new CreditCard(2222,"2222-2222-2222-2222",bank,CardTypes.VISA);
    Account account1 = new Account("Account 1","111-111-111",bank,"100000",true,card1);
    Account account2 = new Account("Account 2","222-222-222",bank,"20000",true,card2);

    @Test
    public void moneyWithdrawal(){
        String withdrawal = "10000";

        assertTrue(atm.validateOperation(account1,withdrawal));
        atm.moneyWithdrawal(account1,withdrawal);
    }

    @Test
    public void moneyDeposit(){
        String deposit = "10000";

        assertTrue(atm.validateOperation(account1,deposit));
        atm.moneyWithdrawal(account1,deposit);
    }

    @Test
    public void moneyTransfer(){
        String transferAmount = "15000";

        assertTrue(atm.validateOperation(account1,transferAmount));
        atm.moneyTransfer(account1,account2,transferAmount);
    }

    @Test
    public void printReceipt(){

    }
}
