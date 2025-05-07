//Classe para representar uma conta e suas propriedades
import java.math.*;

public class Account{
    protected BigDecimal balance; //saldo do cartao representado pelo tipo BigDecimal que e mais apropriado para valores monetarios
    private final int accId; //id da conta
    private static int nextAccID = 1; //permite criar um id unico para cada cliente por default o primeiro obj contem id=1
    protected String accName; //Nome identificador da conta
    protected String accCode; //codigo da conta

    //Account Constructor
    protected Account(String p_balance,String p_accName,String p_accCode){
        this.balance = new BigDecimal(p_balance);
        this.accName = p_accName;
        this.accCode = p_accCode;
        this.accId = nextAccID++;
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

    //Account Operations (que irao ser usadas pelo o ATM)
    //------------------------------------------------------

    public BigDecimal moneyWithdrawal(Account account,String p_value){ //operacao de levantamento
        BigDecimal value = new BigDecimal(p_value);

        if(this.balance.compareTo(value) >= 0){ //compara se o valor a ser levantado e menor que o saldo disponivel
            this.balance = balance.subtract(value);
            System.out.println("-Foi levantado a quantia de: " +value +" CVE");

        }else{
            System.out.println("-Nao e possivel realizar levantamento, saldo insuficiente!\n");
        }

        return this.balance;
    }

    public BigDecimal moneyDeposit(Account account,String p_value){ //operacao de deposito
        BigDecimal value = new BigDecimal(p_value);
        this.balance = balance.add(value);
        System.out.println("-Foi depositado uma quantia de :" +value +" CVE");

        return this.balance;
    }

    //------------------------------------------------------
}
