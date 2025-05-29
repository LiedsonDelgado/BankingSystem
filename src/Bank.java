//Classe para representar um banco e suas funcoes
import java.security.InvalidParameterException;
import java.util.*;

public class Bank{
    protected String creationDate; //formato DD-MM-AAAA
    protected String name;
    protected String bankAdress;
    protected int bankCode;

    protected ArrayList<CreditCard> cartoesEmitidos;
    protected ArrayList<Account>contasCriadas;
    protected ArrayList<Client>clientesAssociados;

    //Bank Construtor
    public Bank(String p_date,String p_name,String p_bankAdress,int p_code){
        this.creationDate = p_date;
        this.name = p_name;
        this.bankAdress = p_bankAdress;
        this.bankCode = p_code;

        this.cartoesEmitidos = new ArrayList<>();
        this.contasCriadas = new ArrayList<>();
        this.clientesAssociados = new ArrayList<>();
    }

    //Methods
    //Getters
    public String getCreationDate(){
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
    public void setCreationDate(String s_creationDate){
        this.creationDate = s_creationDate;
    }

    public void setBankName(String s_name){
        this.name = s_name;
    }

    public void setBankAdress(String s_adress){
        this.bankAdress = s_adress;
    }

    public void setBankCode(int s_code){
        this.bankCode = s_code;
    }
    //Methods to manipulate Cards int the Bank
    //------------------------------------------------------
    public void addCardToBank(CreditCard card,boolean confirmKey){ //recebe um boolean como chave de confirmaca Sim(true) e Nao(false)
        if((card != null) && (confirmKey)){
            cartoesEmitidos.add(card);
            System.out.println("O cartao foi adicionado com sucesso!\n");
        }else{
            System.out.println("O cartao nao foi adicionado\n");
        }
    }

    public ArrayList<CreditCard> removeCardFromBank(CreditCard card,boolean confirmKey){ //recebe um boolean como chave de confirmaca Sim(true) e Nao(false)
        if((card != null) && (confirmKey)){
            cartoesEmitidos.remove(card);
            System.out.println("O cartao foi removido com sucesso!\n");
        }else{
            System.out.println("O cartao nao foi removido\n");
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
    public void addAccountToBank(Account account,boolean confirmKey){ //recebe um boolean como chave de confirmaca Sim(true) e Nao(false)
        if((account != null) && (confirmKey && account.getStatus())){
            contasCriadas.add(account);
            System.out.println("A conta criada com sucesso!\n");
        }else{
            System.out.println("A conta nao foi criada\n");
        }
    }

    public ArrayList<Account> removeAccountFromBank(Account account,boolean confirmKey){ //recebe um boolean como chave de confirmaca Sim(true) e Nao(false)
        if((account != null) && (confirmKey)){
            contasCriadas.remove(account);
            System.out.println("A conta foi removida com sucesso!\n");
        }else{
            System.out.println("A conta nao foi removida\n");
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
    public void addClientToBank(Client client,boolean confirmKey){ //recebe um boolean como chave de confirmaca Sim(true) e Nao(false)
        if((client != null) && (confirmKey)){
            clientesAssociados.add(client);
            System.out.println("A conta criada com sucesso!\n");
        }else{
            System.out.println("A conta nao foi criada\n");
        }
    }

    public ArrayList<Client> removeClientFromBank(Client client,boolean confirmKey){ //recebe um boolean como chave de confirmaca Sim(true) e Nao(false)
        if((client != null) && (confirmKey)){
            clientesAssociados.remove(client);
            System.out.println("A conta foi removida com sucesso!\n");
        }else{
            System.out.println("A conta nao foi removida\n");
        }
        return clientesAssociados;
    }

    public void showAddedClients(){
        for(Client client: clientesAssociados){
            System.out.println(client.showClientInfo(client));
        }
    }
    //------------------------------------------------------

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public String ShowCardsAndAccounts(){
        StringBuilder string = new StringBuilder();

        string.append("-Numero de Cartoes Totais: " +getNumberOfCardsFromBank() +"\n");
        string.append("-Numero de Contas Totais: " +getNumberOfAccountsFromBank() +"\n");
        string.append("-Numero de Clientes Totais: " +getNumberOfClientsFromBank() +"\n");

        return string.toString();
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
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
    //Metodo para imprimir informacoes de uma determinada pesquisa
    public void printSearchAccInfo(Account conta){
        try{
            System.out.println("=>Conta(s) encontrada(s):");
            System.out.println("-----------------------------");
            System.out.print(conta.showAccountInfo(conta));
            System.out.println("-----------------------------");
        }catch(InvalidParameterException error){
            System.out.println("Erro! Nao foi possivel exibir informacoes");
        }
    }

    //Procura pelo ID da Conta
    public String searchAccID(int p_accID){
        String msg = "-Pesquisa terminada!\n";

        for (Account conta : contasCriadas){
            if(conta.getAccId() == (p_accID)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!\n");
            }
        }
        return msg;
    }

    //Procura pelo Codigo da Conta
    public String searchAccCode(String p_accCode){
        String msg = "-Pesquisa terminada!\n";

        for (Account conta : contasCriadas){
            if(conta.getAccCode().contains(p_accCode)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!\n");
            }
        }
        return msg;
    }

    //Procura pelo Banco a qual a Conta pertence
    public String searchAccInBank(String p_bankName){
        String msg = "-Pesquisa terminada!\n";
        for (Account conta : contasCriadas) {
            if(conta.getAccBank().equals(p_bankName)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!\n");
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
                System.out.println("=>A conta nao foi encontrada!\n");
            }
        }
        return msg;
    }

    //Procura pelo Nome da Conta
    public String searchNameBar(String p_accName){ //faz a procura pelo nome funcionando como uma barra de pesquisa para uma String
        String msg = "-Pesquisa terminada!\n";

        for(Account conta : contasCriadas){
            if(conta.getAccName().contains(p_accName)){
                printSearchAccInfo(conta);
            }else{
                System.out.println("=>A conta nao foi encontrada!\n");
            }
        }

        return msg;
    }
}