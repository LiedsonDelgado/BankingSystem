//Classe para representar um banco e suas funcoes
import java.util.*;

public class Bank{
    protected String creationDate; //formato DD-MM-AAAA
    protected String name;
    protected String bankAdress;
    protected int bankCode;

    protected ArrayList<Card> cartoesEmitidos;
    protected ArrayList<Account>contasCriadas;
    protected ArrayList<Client>clientesAssociados;

    //Construtor Banco
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
    //Methods to manipulate Accounts in the Bank
    //------------------------------------------------------
    protected ArrayList addAccountToBank(Account account,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            contasCriadas.add(account);
            System.out.println("A conta criada com sucesso!");
        }else{
            System.out.println("A conta nao foi criada");
        }
        return contasCriadas;
    }

    protected ArrayList removeAccountFromBank(Account account,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            contasCriadas.remove(account);
            System.out.println("A conta foi removida com sucesso!");
        }else{
            System.out.println("A conta nao foi removida");
        }
        return contasCriadas;
    }

    protected void showAddedAccounts(){
        for(Account conta: contasCriadas){
            System.out.println(conta.showAccountInfo(conta));
        }
    }
    //------------------------------------------------------

    //Methods to manipulate Cards int the Bank
    //------------------------------------------------------
    protected ArrayList addCardToBank(Card card,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            cartoesEmitidos.add(card);
            System.out.println("O cartao foi adicionado com sucesso!");
        }else{
            System.out.println("O cartao nao foi adicionado");
        }
        return cartoesEmitidos;
    }

    protected ArrayList removeCardFromBank(Card card,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            cartoesEmitidos.remove(card);
            System.out.println("O cartao foi removido com sucesso!");
        }else{
            System.out.println("O cartao nao foi removido");
        }
        return cartoesEmitidos;
    }

    protected void showAddedCards(){
        for(Card cards: cartoesEmitidos){
            System.out.println(cards.showCardInfo(cards));
        }
    }
    //------------------------------------------------------

    //Method to manipulate Clients in the Bank
    //------------------------------------------------------
    protected ArrayList addClientToBank(Client client,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            clientesAssociados.add(client);
            System.out.println("A conta criada com sucesso!");
        }else{
            System.out.println("A conta nao foi criada");
        }
        return clientesAssociados;
    }

    protected ArrayList removeClientFromBank(Client client,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            clientesAssociados.remove(client);
            System.out.println("A conta foi removida com sucesso!");
        }else{
            System.out.println("A conta nao foi removida");
        }
        return clientesAssociados;
    }

    protected void showAddedClients(){
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

        return ShowCardsAndAccounts();
    }
}
