package app;
import model.*;
import enums.*;
import report.*;

public class ConsoleTestArea{
    public static void main(String[] args){
        //Area de Testes!!!
        //---------------------------------------------------------------------
        /*
        Bank bcv = new Bank("BCV Services","Mindelo-Rua de Angola",136796);
        System.out.println(bcv.ShowBankInfo());
        System.out.println(bcv.ShowCardsAccountsAndClients());

        Manager m1 = new Manager("Marco Wahnon","Gerente de Administracao","+238 5819375","Gerencia",ExperienceLevel.SENIOR,"150000",bcv,bcv.getListOfClients(),bcv.getListOfAccounts());
        System.out.println(m1.showManagerInfo(m1));

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

        Client cliente1 = new Client("Liedson Delgado","27-08-2005","26 Campim,Mindelo","+238 9572843","136gb89cv",20,a1);

        m1.getEmployeeBank().addAccountToBank(a1,true);
        m1.getEmployeeBank().addAccountToBank(a2,true);
        m1.getEmployeeBank().addClientToBank(cliente1,true);
        m1.getEmployeeBank().addCardToBank(c1,true);
        m1.getEmployeeBank().addCardToBank(c2,true);

        a2.setStatus(false);
        System.out.println("\n" +bcv.ShowCardsAccountsAndClients());

        //teste da pesquisa de uma string no arraylist de contas pesquisando pelo nome da conta
        System.out.println(bcv.searchNameBar("Liedson"));
        System.out.println(bcv.searchAccByStatus(false));

        //Teste para geracao de relatorio de contas,cartoes e clientes
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

        GenerateManagerReport generatorManRep = new GenerateManagerReport(); //objeto que cria o gereador de relatorio do gerente
        generatorManRep.generateManagerReport(p_manager);

        System.out.print("\n");

        bcv.addEmployeeToBank(m1,true);
        bcv.showAllEmployee();
        bcv.showEspecifiedEmployee();

        //Testes de Email
        //---------------------------------------------------------------------
        Bank bcv = new Bank("BCV Services","Mindelo-Rua de Angola",136796);

        CreditCard c1 = new CreditCard(7642,"1234-2345-7483-3441","BCV Services",CardTypes.MASTERCARD);
        Account a1 = new Account("Liedson Delgado","xz89b7647","BCV Services","200.00",true,c1);

        Client client = new Client("Liedson Delgado","27-08-2005","26 Campim,Mindelo","+238 9572843","136gb89cv",20,a1);
        Manager manager = new Manager("Marco Wahnon","Gerente de Administracao","+238 5819375","Gerencia",ExperienceLevel.SENIOR,"150000",bcv,bcv.getListOfClients(),bcv.getListOfAccounts());
        StaffMember staff = new StaffMember("Mary Verissimo","+232 9332745","45000",ExperienceLevel.MIDLEVEL,bcv);
        Worker worker = new Worker("Jose Borges","+238 5924523","40000",ExperienceLevel.MIDLEVEL,bcv);

        Email email1 = new Email("ldelgado");
        email1.generateDomain(client);
        email1.validateEmail(email1.getCompleteEmail());
        client.setClientEmail(email1.getCompleteEmail());
        System.out.println(client.getClientEmail());

        Email email2 = new Email("mwahnon");
        email2.generateDomain(manager);
        email2.validateEmail(email2.getCompleteEmail());
        manager.setEmail(email2.getCompleteEmail());
        System.out.println(manager.getEmail());

        Email email3 = new Email("jborges");
        email3.generateDomain(worker);
        email3.validateEmail(email3.getCompleteEmail());
        worker.setEmail(email3.getCompleteEmail());
        System.out.println(worker.getEmail());

        Email email4 = new Email("mverissimo");
        email4.generateDomain(staff);
        email4.validateEmail(email4.getCompleteEmail());
        staff.setEmail(email4.getCompleteEmail());
        System.out.println(staff.getEmail());

        Email email5 = new Email("ldelgado");
        email5.generateDomain(client);
        email5.validateEmail(email5.getCompleteEmail());
        client.setClientEmail(email5.getCompleteEmail());
        System.out.println(client.getClientEmail());

        System.out.println(email1.equalsToEmail(email5));
        */

        Bank bcv = new Bank("BCV Services","Mindelo-Rua de Angola",136796);
        System.out.println(bcv.ShowBankInfo());
        System.out.println(bcv.ShowCardsAccountsAndClients());

        Manager manager = new Manager("Marco Wahnon","Gerente de Administracao","+238 5819375","Gerencia",ExperienceLevel.SENIOR,"150000",bcv,bcv.getListOfClients(),bcv.getListOfAccounts());
        Email email1 = new Email("mwahnon");
        email1.generateDomain(manager);
        email1.validateEmail(email1.getCompleteEmail());
        manager.setEmail(email1.getCompleteEmail());
        System.out.println(manager.getEmail());

        bcv.addEmployeeToBank(manager,true);

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

        Client client1 = new Client("Liedson Delgado","27-08-2005","31 Monte Sossego,Mindelo","+238 9572843","136gb89cv",20,a1);
        Email email2 = new Email("ldelgado");
        email2.generateDomain(client1);
        email2.validateEmail(email2.getCompleteEmail());
        client1.setClientEmail(email2.getCompleteEmail());

        manager.getEmployeeBank().addAccountToBank(a1,true);
        manager.getEmployeeBank().addAccountToBank(a2,true);
        manager.getEmployeeBank().addClientToBank(client1,true);
        manager.getEmployeeBank().addCardToBank(c1,true);
        manager.getEmployeeBank().addCardToBank(c2,true);

        a2.setStatus(false);
        System.out.println("\n" +bcv.ShowCardsAccountsAndClients());

        //teste da pesquisa de uma string no arraylist de contas pesquisando pelo nome da conta
        System.out.println(bcv.searchNameBar("Liedson"));
        System.out.println(bcv.searchAccByStatus(false));

        StaffMember staff = new StaffMember("Mary Verissimo","+232 9332745","45000",ExperienceLevel.MIDLEVEL,bcv);
        Email email3 = new Email("mverissimo");
        email3.generateDomain(staff);
        email3.validateEmail(email3.getCompleteEmail());
        staff.setEmail(email3.getCompleteEmail());
        System.out.println(staff.getEmail());

        manager.getEmployeeBank().addEmployeeToBank(staff,true);

        Worker worker = new Worker("Jose Borges","+238 5924523","40000",ExperienceLevel.MIDLEVEL,bcv);
        Email email4 = new Email("jborges");
        email4.generateDomain(worker);
        email4.validateEmail(email4.getCompleteEmail());
        worker.setEmail(email4.getCompleteEmail());
        System.out.println(worker.getEmail());

        manager.getEmployeeBank().addEmployeeToBank(worker,true);

        bcv.showAllEmployee();
        bcv.showEspecifiedEmployee();

        //Teste para geracao de relatorio de contas,cartoes e clientes
        //---------------------------------------------------------------------
        Account p_account = a1;
        CreditCard p_creditcard = c1;
        Client p_client = client1;
        Manager p_manager = manager;
        StaffMember p_staff = staff;
        Worker p_worker = worker;

        try{
            Thread.sleep(2000); //timer de 2 segundos
        }catch(InterruptedException error){
            error.printStackTrace();
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
        //---------------------------------------------------------------------
    }
}