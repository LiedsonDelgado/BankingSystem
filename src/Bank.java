//Classe para representar um banco e suas funcoes
import java.util.*;

public class Bank{
    protected String creationDate; //formato DD-MM-AAAA
    protected String name;
    protected int bankCode;
    protected ArrayList<Card> cartoesEmitidos;
    protected ArrayList<Account>contasCriadas;

    //Construtor Banco
    public Bank(String p_date, String p_name, int p_code){
        this.creationDate = p_date;
        this.name = p_name;
        this.bankCode = p_code;

        this.cartoesEmitidos = new ArrayList<>();
        this.contasCriadas = new ArrayList<>();
    }

    //Methods
    //Getters
    public String getCreationDate(){
        return creationDate;
    }

    public String getBankName(){
        return name;
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
    //-----------------------------------------

    //Setters
    public void setCreationDate(String s_creationDate){
        this.creationDate = s_creationDate;
    }

    public void setBankName(String s_name){
        this.name = s_name;
    }

    public void setBankCode(int s_code){
        this.bankCode = s_code;
    }
    //Methods to manipulate accounts in the Bank
    //------------------------------------------------------
    protected ArrayList addAccountToBank(Account conta,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            contasCriadas.add(conta);
            System.out.println("A conta criada com sucesso!");
        }else{
            System.out.println("A conta nao foi criada");
        }
        return contasCriadas;
    }

    protected ArrayList removeAccountFromBank(Account conta,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            contasCriadas.remove(conta);
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

    //Methods to manipulate cards int the Bank
    //------------------------------------------------------
    protected ArrayList addCardToBank(Card cartao,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            cartoesEmitidos.add(cartao);
            System.out.println("O cartao foi adicionado com sucesso!");
        }else{
            System.out.println("O cartao nao foi adicionado");
        }
        return cartoesEmitidos;
    }

    protected ArrayList removeCardFromBank(Card cartao,boolean confirmKey){ //recebe um boolean como chave de confirmacao(true=Sim e false=Nao)
        if(confirmKey == true){
            cartoesEmitidos.remove(cartao);
            System.out.println("O cartao foi removido com sucesso!");
        }else{
            System.out.println("O cartao nao foi removido");
        }
        return cartoesEmitidos;
    }

    protected void showAddedCards(){
    for(Card card: cartoesEmitidos){
            System.out.println(card.showCardInfo(card));
    }
    }
    //------------------------------------------------------
    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public String ShowCardsAndAccounts(){
        StringBuilder string = new StringBuilder();

        string.append("-Numero de Cartoes Totais: " +getNumberOfCardsFromBank() +"\n");
        string.append("-Numero de Contas Totais: " +getNumberOfAccountsFromBank() +"\n");

        return ShowCardsAndAccounts();
    }
}