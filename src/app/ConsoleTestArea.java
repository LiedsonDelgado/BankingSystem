package app;
import model.*;
import enums.*;
import report.*;

public class ConsoleTestArea{
    public static void main(String[] args){
        //Area de Testes!!!
        //---------------------------------------------------------------------
        Bank bcv = new Bank("BCV Services","Mindelo-Rua de Angola",136796);
        System.out.println(bcv.ShowBankInfo());
        System.out.println(bcv.ShowCardsAndAccounts());

        Manager m1 = new Manager("Marco Wahnon","Gerente de Administracao","mwahnon@gmail.com","+238 5819375","Gerencia",AcessLevel.SENIOR,bcv,bcv.getListOfClients(),bcv.getListOfAccounts());
        m1.showManagerInfo(m1);

        CreditCard c1 = new CreditCard(7642,"1234-2345-7483-3441","BCV Services",CardTypes.MASTERCARD);
        c1.setCardStatus(true);
        System.out.println(c1.showCardInfo(c1));

        CreditCard c2 = new CreditCard(8243,"1259-8815-9327-1006","BCV Services",CardTypes.VISA);
        c2.setCardStatus(true);
        System.out.println(c2.showCardInfo(c2));

        Account a1 = new Account("Liedson Delgado","xz89b7647","BCV Services","200.00",true,c1);
        a1.moneyWithdrawal(a1,"156");
        System.out.println("-Saldo atual disponivel: " +a1.getBalance() +" CVE\n");

        a1.moneyDeposit(a1,"44.67");
        System.out.println("-Saldo atual disponivel: " +a1.getBalance() +" CVE\n");

        Account a2 = new Account("Nuno Silva","bz98c746v5","BCV Services","150.00",true,c2);

        System.out.println(bcv.ShowCardsAndAccounts());

        Client cliente1 = new Client("Liedson Delgado","27-08-2005","26 Campim,Mindelo","+238 9572843","136gb89cv",19,a1);

        bcv.addEmployeeToBank(m1,true);
        m1.getEmployeeBank().addAccountToBank(a1,true);
        m1.getEmployeeBank().addAccountToBank(a2,true);
        m1.getEmployeeBank().addClientToBank(cliente1,true);
        m1.getEmployeeBank().addCardToBank(c1,true);
        m1.getEmployeeBank().addCardToBank(c2,true);

        a2.setStatus(false);
        System.out.println("\n" +bcv.ShowCardsAndAccounts());

        //teste da pesquisa de uma string no arraylist de contas pesquisando pelo nome da conta
        System.out.println(bcv.searchNameBar("Liedson"));
        System.out.println(bcv.searchAccByStatus(false));

        //teste para geracao de relatorio de contas,cartoes e clientes
        //---------------------------------------------------------------------
        Account p_account = a1;
        CreditCard p_creditcard = c1;
        Client p_client = cliente1;
        Manager p_manager = m1;

        GenerateAccountReport generatorAccRep = new GenerateAccountReport(); //objeto que cria o gerador de relatorios de contas
        generatorAccRep.generateAccountReport(p_account); //geracao de um relatorio

        GenerateClientReport generatorClientRep = new GenerateClientReport(); //objeto que cria o gerador de relatorios de clientes
        generatorClientRep.generateClientReport(p_client);

        GenerateCardReport generatorCardRep = new GenerateCardReport(); //objeto que cria o gerador de relatorios de cartoes
        generatorCardRep.generateCreditCardReport(p_creditcard);

        GenerateMangerReport generateMangerReport = new GenerateMangerReport(); //objeto que cria o gereador de relatorio do gerente
        generateMangerReport.generateManagerReport(p_manager);

        System.out.print("\n");

        bcv.addEmployeeToBank(m1,true);
        bcv.showAllEmployee();
        bcv.showEspecifiedEmployee();
        //---------------------------------------------------------------------
    }
}