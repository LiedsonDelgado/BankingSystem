//Classe para representar uma conta e suas propriedades
import java.math.BigDecimal;

public class Account{
    protected String accName; //nome identificador da conta
    protected String accCode; //codigo da conta
    protected String bank; //agencia ou banco que a conta esta associada
    protected BigDecimal balance; //saldo do cartao representado pelo tipo BigDecimal que e mais apropriado para valores monetarios
    protected CreditCard card; //objeto cartao na qual a conta tem
    protected boolean status; //estado da conta ativa(true) ou nao ativa(false)

    private final int accId; //id da conta
    private static int nextAccID = 1; //permite criar um id unico para cada cliente por default o primeiro obj contem id=1

    //Account Constructor
    public Account(String p_accName,String p_accCode,String p_bank,String p_balance,CreditCard p_card,boolean p_status){
        this.accName = p_accName;
        this.accCode = p_accCode;
        this.bank = p_bank;
        this.balance = new BigDecimal(p_balance);
        this.card = p_card;
        this.status = p_status;

        this.accId = nextAccID++;
    }

    //Methods
    //Getters
    public String getAccName(){
        return accName;
    }

    public String getAccCode(){
        return accCode;
    }

    public String getAccBank(){
        return bank;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public boolean getStatus(){
        return status;
    }

    public int getAccId(){
        return accId;
    }

    //Setters
    public void setAccName(String p_accName){
        this.accName = p_accName;
    }

    public void setAccCode(String p_accCode){
        this.accCode = p_accCode;
    }

    public void setAccBank(String p_bank){
        this.bank = p_bank;
    }

    public void setBalance(BigDecimal s_balance,Account p_account){
        if(p_account.getStatus()){
            this.balance = s_balance;
        }else{
            System.out.println("Conta esta desativada!");
        }
    }

    public void setStatus(boolean p_status){
        this.status = p_status;
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public String showAccountInfo(Account account){
        StringBuilder string = new StringBuilder();

        string.append("-Nome da Conta: " +account.getAccName() +"\n");
        string.append("-Codigo do Conta: " +account.getAccCode() +"\n");
        string.append("-ID do Usuario: " +account.getAccId() +"\n");
        string.append("-Saldo: " +account.getBalance() +"\n");
        string.append("-Banco Associado: " +account.getAccBank() +"\n");

        return string.toString();
    }

    //Account Operations (que irao ser usadas pelo o ATM)
    //------------------------------------------------------
    public void moneyWithdrawal(Account account,String p_value){ //operacao de levantamento
        try{ //o uso do try-catch atende quando for passado um valor invalido ex.: null,etc
            BigDecimal value = new BigDecimal(p_value);

            if(account.getStatus()){ //verifica se o estado for true
                if((this.balance.compareTo(value) >= 0) && (value.compareTo(BigDecimal.ZERO) >= 0)){ //compara se o valor a ser levantado for menor que o saldo disponivel e maior que 0
                    this.balance = balance.subtract(value);
                    System.out.println("-Foi levantado a quantia de: " +value +" CVE");
                }else{
                    System.out.println("-Erro: impossivel realizar levantamento, o saldo e insuficiente!\n");
                }
            }else{
                System.out.println("-Erro: conta nao esta ativa!");
            }
        }catch(NumberFormatException error){
            System.out.println("-Erro: valor invalido");
        }

    }

    public void moneyDeposit(Account account,String p_value){ //operacao de deposito
        try{ //o uso do try-catch atende quando for passado um valor invalido ex.: null,etc
            BigDecimal value = new BigDecimal(p_value);

            if(account.getStatus()){ //verifica se o estado for true
                if(value.compareTo(BigDecimal.ZERO) > 0){ //compara se o valor a ser depositado for menor que o saldo disponivel e maior que 0
                    this.balance = balance.add(value);
                    System.out.println("-Foi depositado uma quantia de: " +value +" CVE");
                }else{
                    System.out.println("-Erro: valor a ser depositado deve ser superior a 0 !");
                }
            }else{
                System.out.println("-Erro: conta nao esta ativa!");
            }
        }catch(NumberFormatException error){
            System.out.println("-Erro: valor invalido");
        }
    }

    //------------------------------------------------------
}
