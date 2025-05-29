//Classe para representar um cartao e suas funcoes/propriedades
import java.lang.*;
import java.util.HashMap;

public class CreditCard{
    protected int number; //numero do cartao
    protected int code; //senha do cartao no formato XXXX digitos
    protected String cardCode; //codigo do cartao a ser inserido no formato XXXX-XXXX-XXXX-XXXX
    protected String bank; //nome do banco a qual o cartao pertence
    protected String cardClass; //tipo da classe pertencente ao cartao do banco

    //Card Constructor
    public CreditCard(int p_number,int p_code,String p_cardCode,String p_bank,String p_cardClass) { //parametro passados ao construtor da classe
        this.number = p_number;
        this.code = p_code;
        this.cardCode= p_cardCode;
        this.bank = p_bank;
        this.cardClass = p_cardClass;
    }

    //Getters
    public int getNumber(){
        return number;
    }

    public int getCode(){
        return code;
    }

    public String getCardCode(){
        return cardCode;
    }

    public String getBank(){
        return bank;
    }

    public String getCardClass(){
        return cardClass;
    }

    //Setters
    public void setNumber(int s_number){
        this.number = s_number;
    }

    public void setCode(int s_code){
        if(String.valueOf(s_code).length() == 4){
            this.code = s_code;
        }else{
            System.out.println("Senha do Cartao Invalido!");
        }
    }

    public void setCardCode(String s_cardCode){
        if((s_cardCode.length() == 19)){
            this.cardCode= s_cardCode;
        }else{
            System.out.println("Codigo de Cartao Invalido!");
        }
    }

    public void setBanco(String s_bank){
        if(s_bank != null){
            this.bank = s_bank;
        }else{
            System.out.println("Esse campo nao pode ser vazio!");
        }
    }

    public void setClasse(String s_Cardclass){
        if(s_Cardclass != null){
            this.cardClass = s_Cardclass;
        }else{
            System.out.println("Esse campo nao pode ser vazio!");
        }
    }

    //Methods for validation
    //------------------------------------------------------
    public void validateCard(CreditCard p_card){
        //implementar logica de validacao...
    }
    //------------------------------------------------------

    //Methods for autentication
    //------------------------------------------------------
    public void autenticateCard(CreditCard p_card){
        //implementar logica de autenticacao...
    }
    //------------------------------------------------------

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    protected String showCardInfo(CreditCard card){
        StringBuilder string = new StringBuilder();

        string.append("-Numero: " +card.getNumber() +"\n");
        string.append("-Senha: " +card.getCode() +"\n");
        string.append("-Codigo do Cartao: " +card.getCardCode() +"\n");
        string.append("-Banco: " +card.getBank() +"\n");
        string.append("-Classe: " +card.getCardClass() +"\n");

        return string.toString();
    }
}