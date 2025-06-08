public class MainTestArea{
    public static void main(String[] args){

        //Area de Testes!!!
        //---------------------------------------------------------------------

        Bank bcv = new Bank("BCV Services","Mindelo-Rua de Angola",136796);

        CreditCard c1 = new CreditCard(7642,"1234-2345-7483-3441","BCV Services",CardTypes.MASTERCARD);
        c1.setCardStatus(true);
        System.out.println(c1.showCardInfo(c1));

        CreditCard c2 = new CreditCard(8243,"1259-8815-9327-1006","BCV Services",CardTypes.VISA);
        c2.setCardStatus(true);
        System.out.println(c2.showCardInfo(c2));

        Account a1 = new Account("Liedson Delgado","xz89b7647","BCV Services","200.00",c1,true);
        Account a2 = new Account("Nuno Silva","bz98c746v5","BCV Services","150.00",c2,true);

        bcv.addAccountToBank(a1,true);
        bcv.addAccountToBank(a2,true);

        a2.setStatus(false);

        a1.moneyWithdrawal(a1,"156");
        System.out.println("-Saldo atual disponivel: " +a1.getBalance() +"CVE\n");

        a1.moneyDeposit(a1,"44.67");
        System.out.println("-Saldo atual disponivel: " +a1.getBalance() +"CVE\n");

        System.out.println(bcv.ShowBankInfo());
        System.out.println(bcv.ShowCardsAndAccounts());

        //teste da pesquisa de uma string no arraylist de contas pesquisando pelo nome da conta
        System.out.println(bcv.searchNameBar(""));
        System.out.println(bcv.searchAccByStatus(false));

        //teste para geracao de relatorio de contas
        //---------------------------------------------------------------------
        Account p_account = a1;
        String p_filename = "relatorio_cliente_";
        String p_filepath = "E:/!UTA(Pratica)/POO/InteliJ_Projects/BankingSystem/files/relatorios/";

        GenerateAccountReport generator = new GenerateAccountReport(); //objeto que cria o gerador de relatorios
        generator.generateAccountReport(p_filename,p_filepath,p_account); //geracao de um relatorio
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