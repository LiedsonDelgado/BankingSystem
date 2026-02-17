//Classe para representar um banco e suas funcoes;
package model;
import java.util.*;
import java.time.*;

public class Bank{  
    protected LocalDateTime creationDate;
    protected String name;
    protected String bankAdress;
    protected int bankCode;

    protected ArrayList<CreditCard> issuedCards;
    protected ArrayList<Account>createdAccounts;
    protected ArrayList<Client>associatedClients;
    protected ArrayList<Object>institutionEmployees;

    //Bank Construtor
    public Bank(String p_name,String p_bankAdress,int p_code){
        this.creationDate = LocalDateTime.now();
        this.name = p_name;
        this.bankAdress = p_bankAdress;
        this.bankCode = p_code;

        this.issuedCards = new ArrayList<>();
        this.createdAccounts = new ArrayList<>();
        this.associatedClients = new ArrayList<>();
        this.institutionEmployees = new ArrayList<>();
    }

    //Methods
    //Getters
    public LocalDateTime getCreationDate(){
        return creationDate;
    }

    public String getBankName(){
        return name;
    }

    public String getBankAdress(){
        return bankAdress;
    }

    public int getBankCode(){
        return bankCode;
    }

    //Specific Getters
    //-----------------------------------------
    public ArrayList<Account> getListOfAccounts(){
        return createdAccounts;
    }

    public ArrayList<Client> getListOfClients(){
        return associatedClients;
    }

    public ArrayList<CreditCard> getListOfCreditCards(){
        return issuedCards;
    }

    public ArrayList<Object> getListOfEmployees(){
        return institutionEmployees;
    }

    public int getNumberOfAccountsFromBank(){
        return createdAccounts.size();
    }

    public int getNumberOfCardsFromBank(){
        return issuedCards.size();
    }

    public int getNumberOfClientsFromBank(){
        return associatedClients.size();
    }

    public int getNumberOfEmployessFromBank(){
        return institutionEmployees.size();
    }
    //-----------------------------------------

    //Setters
    public void setBankName(String s_name){
        if(s_name == null || s_name.isEmpty()){
            throw new IllegalArgumentException("Erro: parametro vazio passado");
        }
        this.name = s_name;
    }

    public void setBankAdress(String s_adress){
        if(s_adress == null || s_adress.isEmpty()){
            throw new IllegalArgumentException("Erro: parametro invalido passado");
        }

        this.bankAdress = s_adress;
    }

    public void setBankCode(int s_code){
        this.bankCode = s_code;
    }

    //Methods to manipulate Cards int the Bank
    //------------------------------------------------------

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public void addCardToBank(CreditCard card,boolean confirmKey){
        if(card == null){
            throw new IllegalArgumentException("Erro: parametro invalid passado");
        }

        if(confirmKey){
            issuedCards.add(card);
            System.out.println("O cartao foi adicionado com sucesso!");
        }else{
            System.out.println("O cartao nao foi adicionado");
        }
    }

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public ArrayList<CreditCard> removeCardFromBank(CreditCard card,boolean confirmKey){
        if(card == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        if(confirmKey){
            issuedCards.remove(card);
            System.out.println("O cartao foi removido com sucesso!");
        }else{
            System.out.println("O cartao nao foi removido!");
        }
        return issuedCards;
    }

    public void showAddedCards(){
        for(CreditCard cards: issuedCards){
            System.out.println(cards.showCardInfo(cards));
        }
    }
    //------------------------------------------------------

    //Methods to manipulate Accounts in the Bank
    //------------------------------------------------------
    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public void addAccountToBank(Account account,boolean confirmKey){
        if(account == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        if(confirmKey && account.getStatus()){
            createdAccounts.add(account);
            System.out.println("A conta criada com sucesso!");
        }else{
            System.out.println("A conta nao foi criada!");
        }
    }

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public ArrayList<Account> removeAccountFromBank(Account account,boolean confirmKey){
        if(account == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        if(confirmKey){
            createdAccounts.remove(account);
            System.out.println("A conta foi removida com sucesso!");
        }else{
            System.out.println("A conta nao foi removida!");
        }
        return createdAccounts;
    }

    public void showAddedAccounts(){
        for(Account conta: createdAccounts){    
            System.out.println(conta.showAccountInfo(conta));
        }
    }
    //------------------------------------------------------

    //Methods to manipulate Clients in the Bank
    // ------------------------------------------------------
    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public void addClientToBank(Client client,boolean confirmKey){
        if(client == null || !client.validateAge(client.getClientAge())){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        if(confirmKey){
            associatedClients.add(client);
            System.out.println("O cliente foi associado com sucesso!");
        }else{
            System.out.println("O cliente nao foi associado!");
        }
    }

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public Client removeClientFromBank(Client client,boolean confirmKey){
        if(client == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        if(confirmKey){
            associatedClients.remove(client);
            System.out.println("O cliente foi removido com sucesso!");
        }else{
            System.out.println("O cliente nao foi removida!");
        }
        return client;
    }

    public void showAddedClients(){
        for(Client client: associatedClients){
            System.out.println(client.showClientInfo(client));
        }
    }
    //------------------------------------------------------

    //Methods to manipulate Employees in the Bank
    // ------------------------------------------------------
    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public void addEmployeeToBank(Object p_employee,boolean confirmKey){
        if(p_employee == null){
            throw  new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }

        if(confirmKey){
            institutionEmployees.add(p_employee);
            System.out.println("O funcionario foi contratado com sucesso!");
        }else{
            System.out.println("O funcionario nao foi contratado!");
        }
    }

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public Object removeEmployeeFromBank(Object p_employee,boolean confirmKey){
        if(p_employee == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }

        if(confirmKey){
            institutionEmployees.remove(p_employee);
            System.out.println("O funcionario foi removido com sucesso!");
        }else{
            System.out.println("O funcionario nao foi removido!");
        }
        return p_employee;
    }
    // ------------------------------------------------------
    @SuppressWarnings("StringConcatenationInsideStringBufferAppend") //oculta os warnings de concatenacao de string
    public String showCardsAccountsAndClients(){
        StringBuilder string = new StringBuilder();

        string.append("-Numero de cartoes totais: " +getNumberOfCardsFromBank() +"\n");
        string.append("-Numero de contas totais: " +getNumberOfAccountsFromBank() +"\n");
        string.append("-Numero de clientes totais: " +getNumberOfClientsFromBank() +"\n");

        return string.toString();
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend") //oculta os warnings de concatenacao de string
    public String showBankInfo(){
        StringBuilder string = new StringBuilder();

        string.append("-Nome do banco: " +getBankName() +"\n");
        string.append("-Endereco do banco: " +getBankAdress() +"\n");
        string.append("-Data de criacao: " +getCreationDate() +"\n");
        string.append("-Codigo do banco: " +getBankCode() +"\n");
        string.append("-Numero total de funcionarios : " +getNumberOfEmployessFromBank() +"\n");

        return string.toString();
    }
    //Methods to search employees
    //------------------------------------------------------
    //Exibe informacoes de um tipo especifico de funcionario
    public void showEspecifiedEmployee(){
        Scanner sc = new Scanner(System.in);
        int opc;
        do{
            System.out.println("-------------------");
            System.out.println("1-Gerente"); //Manager
            System.out.println("2-Membro de equipe"); //StaffMember
            System.out.println("3-Operario"); //Worker
            System.out.println("0-Encerrar");
            System.out.println("-------------------");
            System.out.print("Escolha qual empregado deseja exibir: ");
            opc = sc.nextInt();

            switch(opc){
                case 0:
                System.out.println("Encerrando...");
                break;

                case 1:
                for(Object employee : institutionEmployees){
                    if(employee instanceof Manager){
                        Manager manager = ((Manager)employee);
                        System.out.println(manager.showManagerInfo(manager));
                    }
                }
                break;

                case 2:
                for(Object employee : institutionEmployees){
                    if(employee instanceof Worker){
                        Worker worker = ((Worker)employee);
                        System.out.println(worker.showWorkerInfo(worker));
                    }
                }
                break;

                case 3:
                for(Object employee : institutionEmployees){
                    if(employee instanceof StaffMember){
                        StaffMember staffMember = ((StaffMember)employee);
                        System.out.println(staffMember.showStaffMemberInfo(staffMember));
                    }
                }
                break;

                default:
                System.out.println("Opcao invalida, tente novamente!");
                break;
            }
        }while(opc != 0);
    }

    //Exibe informacoes de todos os funcionarios
    public void showAllEmployee(){
        for(Object employee : institutionEmployees){
            if(employee instanceof Manager){
                Manager manager = ((Manager) employee);
                System.out.println(manager.showManagerInfo(manager));
            }

            else if(employee instanceof Worker){
                Worker worker = ((Worker)employee);
                System.out.println(worker.showWorkerInfo(worker));
            }

            else if(employee instanceof StaffMember){
                StaffMember staffMember = ((StaffMember)employee);
                System.out.println(staffMember.showStaffMemberInfo(staffMember));
            }
        }
    }
    //------------------------------------------------------

    //Methods to search accounts
    //------------------------------------------------------
    //Metodo que imprime informacoes para um determinado tipo de pesquisa
    public void printSearchAccInfo(Account conta){
        if(conta == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        System.out.println("=>Conta(s) encontrada(s):");
        System.out.println("-----------------------------");
        System.out.print(conta.showAccountInfo(conta));
        System.out.println("-----------------------------");
    }

    //Procura a conta pelo id
    public String searchAccID(int p_accID){
        String msg = "-Pesquisa terminada!\n";

        for (Account conta : createdAccounts){
            if(conta.getAccId() == p_accID){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!");
            }
        }
        return msg;
    }

    //Procura a conta pelo codigo associado
    public String searchAccCode(String p_accCode){
        if(p_accCode == null || p_accCode.isEmpty()){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        String msg = "-Pesquisa terminada!\n";
        for (Account conta : createdAccounts){
            if(conta.getAccCode().contains(p_accCode)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!");
            }
        }
        return msg;
    }

    //Procura a conta pelo banco a qual ela pertence
    public String searchAccInBank(String p_bankName){
        if(p_bankName == null || p_bankName.isEmpty()){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        String msg = "-Pesquisa terminada!\n";
        for (Account conta : createdAccounts) {
            if(conta.getAccBank().equals(p_bankName)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!");
            }
        }
        return msg;
    }

    //Procura por Estado da Conta(ATIVA ou NAO ATIVA)
    public String searchAccByStatus(boolean p_status){ //procura por contas ATIVA(true) ou NAO ATIVA(false) filtrando-as atraves do parametro passado
        String msg = "-Pesquisa terminada!\n";
        for (Account conta : createdAccounts) {
            if(conta.getStatus() == p_status){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!");
            }
        }
        return msg;
    }

    //Procura pelo Nome da Conta
    public String searchNameBar(String p_accName){ //faz a procura pelo nome funcionando como uma barra de pesquisa para uma String
        if(p_accName == null || p_accName.isEmpty()){
            throw new IllegalArgumentException("Erro: parametro invalido passado!");
        }

        String msg = "-Pesquisa terminada!\n";
        for(Account conta : createdAccounts){
            if(conta.getAccName().contains(p_accName)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!");
            }
        }
        return msg;
    }
}