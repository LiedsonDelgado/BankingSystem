//Classe para representar um cartao e suas funcoes/propriedades

public class Card{
    //por enquanto os campos/variavais de instancia ficam como private podendo ser mudados para public ou protected
    protected int number; //numero do cartao
    protected int code; //codigo do cartao
    protected String cardCode; //codigo do cartao a ser inserido no formato XXXX-XXXX-XXXX-XXXX
    protected String bank; //nome do banco a qual o cartao pertence
    protected String cardClass; //tipo da classe pertencente ao cartao do banco

    //Card Constructor
    public Card(int p_number,int p_code,String p_cardCode,String p_bank,String p_cardClass) { //parametro passados ao construtor da classe
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

    public void setCodigo(int s_code){
        this.code = s_code;
    }

    public void setCardCode(String s_cardCode){
        this.cardCode= s_cardCode;
    }

    public void setBanco(String s_bank) {
        this.bank = s_bank;
    }

    public void setClasse(String s_Cardclass) {
        this.cardClass = s_Cardclass;
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    protected StringBuilder showCardInfo(Card card){
        StringBuilder string = new StringBuilder();

        string.append("-Numero: " +card.getNumber() +"\n");
        string.append("-Senha: " +card.getCode() +"\n");
        string.append("-Codigo do Cartao: " +card.getCardCode() +"\n");
        string.append("-Banco: " +card.getBank() +"\n");
        string.append("-Classe: " +card.getCardClass() +"\n");

        return string;
    }
}