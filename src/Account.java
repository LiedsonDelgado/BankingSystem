//Classe para representar uma conta e suas propriedades
import java.math.*;

public class Account{
    protected BigDecimal balance; //saldo do cartao representado pelo tipo BigDecimal que e mais apropriado para valores monetarios
    protected int accId; //id da conta
    protected String accName; //Nome identificador da conta
    protected String accCode; //codigo da conta

    //Account Constructor
    protected Account(String p_balance,String p_accName,String p_accCode){
        this.balance = new BigDecimal(p_balance);
        this.accName = p_accName;
        this.accCode = p_accCode;
        this.accId = 1; /*fazer com que a cada objeto criado ele seja incrementado p.ex: obj1->ID:0001, obj2->ID:0002 *...
                        ...*mas que por default o obj1 ja contem ID:0001*/
    }

    //Methods
    //Getters
    public BigDecimal getBalance(){
        return balance;
    }

    public int getAccId(){
        return accId;
    }

    public String getAccName(){
        return accName;
    }

    public String getAccCode(){
        return accCode;
    }

    //Setters
    public void setSaldo(BigDecimal s_balance){
        this.balance = s_balance;
    }

    public void setAccName(String p_accName){
        this.accName = p_accName;
    }

    public void setAccCode(String p_accCode){
        this.accCode = p_accCode;
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public StringBuilder showAccountInfo(Account account){
        StringBuilder string = new StringBuilder();

        string.append("-Nome da Conta: " +account.getAccName() +"\n");
        string.append("-Codigo do Conta: " +account.getAccCode() +"\n");
        string.append("-Saldo: " +account.getBalance() +"\n");
        string.append("-ID do Usuario: " +account.getAccId() +"\n");

        return string;
    }
}