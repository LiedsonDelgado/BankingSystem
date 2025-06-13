//Classe para representar um banco e suas funcoes;
import java.util.*;
import java.time.*;

public class Bank{
    protected LocalDate creationDate;
    protected String name;
    protected String bankAdress;
    protected int bankCode;

    protected ArrayList<CreditCard> cartoesEmitidos;
    protected ArrayList<Account>contasCriadas;
    protected ArrayList<Client>clientesAssociados;

    //Bank Construtor
    public Bank(String p_name,String p_bankAdress,int p_code){
        this.creationDate = LocalDate.now();
        this.name = p_name;
        this.bankAdress = p_bankAdress;
        this.bankCode = p_code;

        this.cartoesEmitidos = new ArrayList<>();
        this.contasCriadas = new ArrayList<>();
        this.clientesAssociados = new ArrayList<>();
    }

    //Methods
    //Getters
    public LocalDate getCreationDate(){
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
    public int getNumberOfAccountsFromBank(){
        return contasCriadas.size();
    }

    public int getNumberOfCardsFromBank(){
        return cartoesEmitidos.size();
    }

    public int getNumberOfClientsFromBank(){
        return clientesAssociados.size();
    }
    //-----------------------------------------

    //Setters
    public void setBankName(String s_name){
        if(s_name == null || s_name.isEmpty()){
            throw new IllegalArgumentException("Erro: parametro vazio passado\n");
        }
        this.name = s_name;
    }

    public void setBankAdress(String s_adress){
        if(s_adress == null || s_adress.isEmpty()){
            throw new IllegalArgumentException("Erro: parametro vazio passado\n");
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
            throw new IllegalArgumentException("Erro: parametro vazio passado\n");
        }

        if(confirmKey){
            cartoesEmitidos.add(card);
            System.out.println("O cartao foi adicionado com sucesso!");
        }else{
            System.out.println("O cartao nao foi adicionado");
        }
    }

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public ArrayList<CreditCard> removeCardFromBank(CreditCard card,boolean confirmKey){
        if(card == null){
            throw new IllegalArgumentException("Erro: parametro vazio passado!\n");
        }

        if(confirmKey){
            cartoesEmitidos.remove(card);
            System.out.println("O cartao foi removido com sucesso!");
        }else{
            System.out.println("O cartao nao foi removido!");
        }
        return cartoesEmitidos;
    }

    public void showAddedCards(){
        for(CreditCard cards: cartoesEmitidos){
            System.out.println(cards.showCardInfo(cards));
        }
    }
    //------------------------------------------------------

    //Methods to manipulate Accounts in the Bank
    //------------------------------------------------------
    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public void addAccountToBank(Account account,boolean confirmKey){
        if(account == null){
            throw new IllegalArgumentException("Erro: parametro vazio passado!\n");
        }

        if(confirmKey && account.getStatus()){
            contasCriadas.add(account);
            System.out.println("A conta criada com sucesso!");
        }else{
            System.out.println("A conta nao foi criada!");
        }
    }

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public ArrayList<Account> removeAccountFromBank(Account account,boolean confirmKey){
        if(account == null){
            throw new IllegalArgumentException("Erro: parametro vazio passado!");
        }

        if(confirmKey){
            contasCriadas.remove(account);
            System.out.println("A conta foi removida com sucesso!");
        }else{
            System.out.println("A conta nao foi removida!");
        }
        return contasCriadas;
    }

    public void showAddedAccounts(){
        for(Account conta: contasCriadas){
            System.out.println(conta.showAccountInfo(conta));
        }
    }
    //------------------------------------------------------

    //Method to manipulate Clients in the Bank
    //------------------------------------------------------
    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public void addClientToBank(Client client,boolean confirmKey){
        if(client == null || !client.validateAge(client.getClientAge())){
            throw new IllegalArgumentException("Erro: parametro vazio passado ou idade invalida!\n");
        }

        if(confirmKey){
            clientesAssociados.add(client);
            System.out.println("Cliente associado com sucesso!");
        }else{
            System.out.println("Cliente nao foi associado!");
        }
    }

    //recebe um boolean como chave(confirmKey) de confirmacao Sim(true) e Nao(false)
    public ArrayList<Client> removeClientFromBank(Client client,boolean confirmKey){
        if(client == null){
            throw new IllegalArgumentException("Erro: parametro vazio passado!\n");
        }

        if(confirmKey){
            clientesAssociados.remove(client);
            System.out.println("Cliente foi removido com sucesso!");
        }else{
            System.out.println("Conta nao foi removida!");
        }
        return clientesAssociados;
    }

    public void showAddedClients(){
        for(Client client: clientesAssociados){
            System.out.println(client.showClientInfo(client));
        }
    }
    //------------------------------------------------------

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend") //oculta os warnings de concatenacao de string
    public String ShowCardsAndAccounts(){
        StringBuilder string = new StringBuilder();

        string.append("-Numero de Cartoes Totais: " +getNumberOfCardsFromBank() +"\n");
        string.append("-Numero de Contas Totais: " +getNumberOfAccountsFromBank() +"\n");
        string.append("-Numero de Clientes Totais: " +getNumberOfClientsFromBank() +"\n");

        return string.toString();
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend") //oculta os warnings de concatenacao de string
    public String ShowBankInfo(){
        StringBuilder string = new StringBuilder();

        string.append("-Nome do Banco: " +getBankName() +"\n");
        string.append("-Endereco do Banco: " +getBankAdress() +"\n");
        string.append("-Data de Criacao: " +getCreationDate() +"\n");
        string.append("-Codigo do Banco: " +getBankCode() +"\n");

        return string.toString();
    }
    //Methods for searching
    //------------------------------------------------------
    //Metodo que imprime informacoes para um determinado tipo de pesquisa
    public void printSearchAccInfo(Account conta){
        if(conta == null){
            throw new IllegalArgumentException("Erro: parametro vazio passado");
        }

        System.out.println("=>Conta(s) encontrada(s):");
        System.out.println("-----------------------------");
        System.out.print(conta.showAccountInfo(conta));
        System.out.println("-----------------------------");
    }

    //Procura a conta pelo id
    public String searchAccID(int p_accID){
        String msg = "-Pesquisa terminada!\n";

        for (Account conta : contasCriadas){
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
            throw new IllegalArgumentException("Erro: parametro vazio passado!\n");
        }

        String msg = "-Pesquisa terminada!\n";
        for (Account conta : contasCriadas){
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
            throw new IllegalArgumentException("Erro: parametro vazio passado");
        }

        String msg = "-Pesquisa terminada!\n";
        for (Account conta : contasCriadas) {
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
        for (Account conta : contasCriadas) {
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
            throw new IllegalArgumentException("Erro: parametro vazio passado");
        }

        String msg = "-Pesquisa terminada!\n";
        for(Account conta : contasCriadas){
            if(conta.getAccName().contains(p_accName)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!");
            }
        }

        return msg;
    }
}
