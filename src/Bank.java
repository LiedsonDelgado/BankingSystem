//Classe para representar um banco e suas funcoes
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
        int totalAccouts = contasCriadas.size();
        return totalAccouts;
    }

    public int getNumberOfCardsFromBank(){
        int totalCards = cartoesEmitidos.size();
        return totalCards;
    }

    public int getNumberOfClientsFromBank(){
        int totalClients = clientesAssociados.size();
        return totalClients;
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
    public ArrayList<CreditCard> addCardToBank(CreditCard card,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if((card != null) && (confirmKey == true)){
            cartoesEmitidos.add(card);
            System.out.println("O cartao foi adicionado com sucesso!\n");
        }else{
            System.out.println("O cartao nao foi adicionado\n");
        }
        return cartoesEmitidos;
    }

    public ArrayList<CreditCard> removeCardFromBank(CreditCard card,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if((card != null) && (confirmKey == true)){
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
    public ArrayList<Account> addAccountToBank(Account account,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if((account != null) && (confirmKey == true)){
            contasCriadas.add(account);
            System.out.println("A conta criada com sucesso!\n");
        }else{
            System.out.println("A conta nao foi criada\n");
        }
        return contasCriadas;
    }

    public ArrayList<Account> removeAccountFromBank(Account account,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if((account != null) && (confirmKey == true)){
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
    public ArrayList<Client> addClientToBank(Client client,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if((client != null) && (confirmKey == true)){
            clientesAssociados.add(client);
            System.out.println("A conta criada com sucesso!\n");
        }else{
            System.out.println("A conta nao foi criada\n");
        }
        return clientesAssociados;
    }

    public ArrayList<Client> removeClientFromBank(Client client,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if((client != null) && (confirmKey == true)){
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
    public StringBuilder ShowCardsAndAccounts(){
        StringBuilder string = new StringBuilder();

        string.append("-Numero de Cartoes Totais: " +getNumberOfCardsFromBank() +"\n");
        string.append("-Numero de Contas Totais: " +getNumberOfAccountsFromBank() +"\n");
        string.append("-Numero de Clientes Totais: " +getNumberOfClientsFromBank() +"\n");

        return string;
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public StringBuilder ShowBankInfo(){
        StringBuilder string = new StringBuilder();

        string.append("-Nome do Banco: " +getBankName() +"\n");
        string.append("-Endereco do Banco: " +getBankAdress() +"\n");
        string.append("-Data de Criacao: " +getCreationDate() +"\n");
        string.append("-Codigo do Banco: " +getBankCode() +"\n");

        return string;
    }
    //Methods for searching
    //------------------------------------------------------
    //Procura pelo ID da Conta
    public String searchAccID(int p_accID){
        String msg = "-Pesquisa terminada!\n";

        for (Account conta : contasCriadas){
            if(conta.getAccId() == (p_accID)){
                System.out.println("=>A conta encontrada foi:");
                System.out.println("-----------------------------");
                System.out.print(conta.showAccountInfo(conta));
                System.out.println("-----------------------------");
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
            if(conta.getAccCode().equals(p_accCode)){
                System.out.println("=>A conta encontrada foi:");
                System.out.println("-----------------------------");
                System.out.print(conta.showAccountInfo(conta));
                System.out.println("-----------------------------");
            }else{
                System.out.println("=>A conta nao foi encontrada!\n");
            }
        }
        return msg;
    }

    //Procura pelo Nome da Conta funcionando como uma barra de pesquisa para uma string
    public String searchNameBar(String p_accName){
        String msg = "-Pesquisa terminada!\n";

        for(Account conta : contasCriadas){
            if(conta.getAccName().contains(p_accName)){
                System.out.println("=>A conta encontrada foi:");
                System.out.println("-----------------------------");
                System.out.print(conta.showAccountInfo(conta));
                System.out.println("-----------------------------");
            }else{
                System.out.println("=>A conta nao foi encontrada!\n");
            }
        }

        return msg;
    }
}