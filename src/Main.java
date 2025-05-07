public class Main{
    public static void main(String[] args){

        //Area de Testes!!!
        //---------------------------------------------------------------------

        Bank bcv = new Bank("09-06-1994","BCV Services","Mindelo-Rua da Angola",136796);
        Account a1 = new Account("2000000.31","Liedson Delgado","xz89b7647");
        Account a2 = new Account("218190.31","Nuno Silva","bz98c746v5");

        System.out.println(a1.showAccountInfo(a1));
        System.out.println(a2.showAccountInfo(a2));

        a1.moneyWithdrawal(a1,"1566");
        System.out.println("-Saldo Disponivel: " +a1.getBalance() +"\n");

        a1.moneyDeposit(a1,"466");
        System.out.println("-Saldo Disponivel: " +a1.getBalance() +"\n");

        bcv.addAccountToBank(a1,true);
        bcv.addAccountToBank(a2,true);

        System.out.println(bcv.ShowBankInfo());
        System.out.println(bcv.ShowCardsAndAccounts());

        //---------------------------------------------------------------------
    }
}

/*Trechos abaixo serao importantes talvez no constructor e no setter de data de criacao

    1-Imports a serem feitos:
        -import java.time.LocalDate;
        -import java.time.format.DateTimeFormatter;
        -import java.util.Scanner;

    2-recebe a <varString> no formato dd-mm-aaaa*...
        -DateTimeFormatter dateFormated = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    3-...*converte para um objeto LocalDate
        -LocalDate date = LocalDate.parse(varString, dateFormated);
*/
