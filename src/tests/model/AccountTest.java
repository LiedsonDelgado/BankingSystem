//Classe de testes unitarios da classe Account
package tests.model;
import enums.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest{
    Bank bank = new Bank("Bank 1","No Where",111111);
    CreditCard card = new CreditCard(1111,"1111-1111-1111-1111",bank,CardTypes.VISA);
    Account account = new Account("Account 1","111-111-111",bank,"100000",true,card);

    @Test
    public void moneyWithdrawal(){
        String withdrawal = "10000";

        assertTrue(account.validateOperations(account,withdrawal));
        account.moneyWithdrawal(account,withdrawal);
    }

    @Test
    public void moneyDeposit(){
        String deposit = "15000";

        assertTrue(account.validateOperations(account,deposit));
        account.moneyDeposit(account,deposit);
    }
}
