package app;
import model.*;
import dao.*;
import enums.*;
import report.*;
import util.ConnectionToDB;
import util.DriverLoader;
import util.TestDataBaseConnection;

public class ConsoleTestArea{
    public static void main(String[] args){
        //Area de Testes!!!
        //---------------------------------------------------------------------

        Bank bcv = new Bank("BCV Services","Mindelo-Rua de Angola",136796);
        System.out.println(bcv.ShowBankInfo());
        System.out.println(bcv.ShowCardsAccountsAndClients());

        Manager manager = new Manager("Marco Wahnon","mwahnon@gmail.com","Gerente de Administracao","+238 5819375","Gerencia",ExperienceLevel.SENIOR,"150000",bcv,bcv.getListOfClients(),bcv.getListOfAccounts());

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

        System.out.println(bcv.ShowCardsAccountsAndClients());

        Client client1 = new Client("Liedson Delgado","ldelgado@gmail.com","27-08-2005","31 Monte Sossego,Mindelo","+238 9572843","136gb89cv",20,a1);

        a2.setStatus(false);
        System.out.println("\n" +bcv.ShowCardsAccountsAndClients());

        //teste da pesquisa de uma string no arraylist de contas pesquisando pelo nome da conta
        System.out.println(bcv.searchNameBar("Liedson"));
        System.out.println(bcv.searchAccByStatus(false));

        StaffMember staff = new StaffMember("Mary Verissimo","mverissimo@gmail.com","+238 9332745","45000",ExperienceLevel.MIDLEVEL,bcv);
        Worker worker = new Worker("Jose Borges","jborges@gmail.com","+238 5924523","40000",ExperienceLevel.MIDLEVEL,bcv);

        bcv.addEmployeeToBank(manager,true);

        manager.getEmployeeBank().addEmployeeToBank(worker,true);
        manager.getEmployeeBank().addEmployeeToBank(staff,true);
        manager.getEmployeeBank().addAccountToBank(a1,true);
        manager.getEmployeeBank().addAccountToBank(a2,true);
        manager.getEmployeeBank().addClientToBank(client1,true);
        manager.getEmployeeBank().addCardToBank(c1,true);
        manager.getEmployeeBank().addCardToBank(c2,true);

        bcv.showAllEmployee();
        //bcv.showEspecifiedEmployee();

        //Testes para geracao de relatorios de contas,cartoes e clientes
        //---------------------------------------------------------------------
        Account p_account = a1;
        CreditCard p_creditcard = c1;
        Client p_client = client1;
        Manager p_manager = manager;
        StaffMember p_staff = staff;
        Worker p_worker = worker;

        try{
            Thread.sleep(2000); //timer de 2 segundos
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        GenerateAccountReport generatorAccRep = new GenerateAccountReport(); //objeto que cria o gerador de relatorios de contas
        generatorAccRep.generateAccountReport(p_account); //geracao de um relatorio

        GenerateCardReport generatorCardRep = new GenerateCardReport(); //objeto que cria o gerador de relatorios de cartoes
        generatorCardRep.generateCreditCardReport(p_creditcard);

        GenerateClientReport generatorClientRep = new GenerateClientReport(); //objeto que cria o gerador de relatorios de clientes
        generatorClientRep.generateClientReport(p_client);

        /*
        //erro 1
        GenerateManagerReport generatorManRep = new GenerateManagerReport(); //objeto que cria o gereador de relatorio do gerente
        generatorManRep.generateManagerReport(p_manager);

        //erro 2
        GenerateStaffMemberReport generatorStaffRep = new GenerateStaffMemberReport(); //objeto que cria o gereador de relatorio dos membros de equipe
        generatorStaffRep.generateStaffMemberReport(p_staff);

        //erro 3
        GenerateWorkerReport generatorWorkerRep = new GenerateWorkerReport(); //objeto que cria o gereador de relatorio dos operarios
        generatorWorkerRep.generateWorkerReport(p_worker);

        System.out.print("\n");
         */

        try{
            Thread.sleep(2000); //timer de 2 segundos
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }

        //Testes para a base de dados
        DriverLoader driverLoader; //carrega o driver da base de dados
        TestDataBaseConnection testConnection; //testa a conexao com a base de dados
        ConnectionToDB connection; //conecta a base de dados

        //Manipulacao dentro da base de dados
        //...

        //---------------------------------------------------------------------
    }
}