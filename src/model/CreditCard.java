//Classe para representar um cartao e suas funcoes/propriedades
package model;
import enums.*;

public class CreditCard{
    private int cardId; //numero do cartao
    private static int nextCardId = 1; //permite criar um id unico para cada cartao por default o primeiro obj cartao contem id=1
    protected int code; //senha do cartao no formato XXXX digitos
    protected String cardCode; //codigo do cartao a ser inserido no formato XXXX-XXXX-XXXX-XXXX
    protected Bank bank; //nome do banco a qual o cartao pertence
    protected CardTypes cardType; //tipo da classe pertencente ao cartao do banco
    protected boolean cardStatus; //estado do cartao ativo(true) ou nao ativo(false)

    //Card Constructor
    public CreditCard(){}

    public CreditCard(int p_cardId){
        this.cardId = p_cardId;
    }

    public CreditCard(int p_code,String p_cardCode,Bank p_bank,CardTypes p_cardType) {//parametro passados ao construtor da classe
        this.cardId = nextCardId++;
        this.code = p_code;
        this.cardCode= p_cardCode;
        this.bank = p_bank;
        this.cardType = p_cardType;
        this.cardStatus = false; //por padrao todos os cartoes sao criados com o status nao ativo(false)
    }

    //Getters
    public int getCardId(){
        return cardId;
    }

    public int getCode(){
        return code;
    }

    public String getCardCode(){
        return cardCode;
    }

    public Bank getBank(){
        return bank;
    }

    public boolean getCardStatus(){
        return cardStatus;
    }

    public CardTypes getCardType(){
        return cardType;
    }

    //Setters
    public void setCardId(int p_cardId){
        this.cardId = p_cardId;
    }

    public void setCode(int p_code){
        if(String.valueOf(p_code).length() != 4){
            throw new IllegalArgumentException("Erro: senha do cartao invalido!");
        }
        this.code = p_code;
    }

    public void setCardCode(String p_cardCode){
        if((p_cardCode.length() != 19)){
            System.out.println("!");
            throw new IllegalArgumentException("Erro: codigo de cartao invalido!");
        }
        this.cardCode= p_cardCode;
    }

    public void setBanco(Bank p_bank){
        if(p_bank == null){
            throw new IllegalArgumentException("Erro: nome invalido!");
        }
        this.bank = p_bank;
    }

    public void setCardType(CardTypes p_cardType){
        this.cardType = p_cardType;
    }

    public void setCardStatus(boolean p_status){
        if(!p_status){
            System.out.println("O cartao ainda esta inativa!");
            return;
        }
        this.cardStatus = true;
        System.out.println("O cartao foi ativado!");
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public String showCardInfo(CreditCard card){
        StringBuilder string = new StringBuilder();

        string.append("-Numero: " +card.getCardId() +"\n");
        string.append("-Senha: " +card.getCode() +"\n");
        string.append("-Codigo do cartao: " +card.getCardCode() +"\n");
        string.append("-Banco: " +card.getBank().getBankName() +"\n");
        string.append("-Classe: " +getCardType() +"\n");
        string.append("-Status: " +card.getCardStatus() +"\n");

        return string.toString();
    }
}