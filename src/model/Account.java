//Classe para representar uma conta e suas propriedades
package model;
import exceptions.InvalidOperationException;

import java.math.*;
import java.time.*;

public class Account{
    protected String accName; //nome identificador da conta
    protected String accCode; //codigo da conta
    protected LocalDateTime creationDate;
    protected Bank bank; //agencia ou banco que a conta esta associada
    protected BigDecimal balance; //saldo do cartao representado pelo tipo BigDecimal que e mais apropriado para valores monetarios
    protected CreditCard card; //objeto cartao na qual a conta tem associada
    protected boolean status; //estado da conta ativa(true) ou nao ativa(false)
    private int accId; //id da conta
    private static int nextAccID = 1; //permite criar um id unico para cada cliente por default o primeiro obj conta contem id=1

    //Account Constructor
    public Account(){}

    public Account(int p_acId){
        this.accId = p_acId;
    }

    public Account(String p_accName,String p_accCode,Bank p_bank,String p_balance,boolean p_status,CreditCard p_card){
        this.accName = p_accName;
        this.accCode = p_accCode;
        this.creationDate = LocalDateTime.now();
        this.bank = p_bank;
        this.balance = new BigDecimal(p_balance);
        this.status = p_status;
        this.card = p_card;

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

    public LocalDateTime getCreationDate(){
        return creationDate;
    }

    public Bank getAccBank(){
        return bank;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public CreditCard getCreditCard(){
        return card;
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

    public void setAccBank(Bank p_bank){
        this.bank = p_bank;
    }

    public void setBalance(BigDecimal s_balance,Account p_account){
        if(p_account.getStatus()){//verifica se a conta se encontra ativa
            this.balance = s_balance;
        }else{
            System.out.println("Conta esta desativada!");
        }
    }

    public void setCreditCard(CreditCard p_card){
        if(p_card == null){
            throw new IllegalArgumentException("Erro: parametro vazio passado!\n");
        }
        this.card = p_card;
    }

    public void setStatus(boolean p_status){
        this.status = p_status;
    }

    public void setAccId(int p_accountId){
        this.accId = p_accountId;
    }

    @SuppressWarnings("StringConcatenationInsideStringBufferAppend")//oculta os warnings de concatenacao de string
    public String showAccountInfo(Account account){
        StringBuilder string = new StringBuilder();

        string.append("-Nome da conta: " +account.getAccName() +"\n");
        string.append("-Codigo do conta: " +account.getAccCode() +"\n");
        string.append("-Data de criacao: " +account.getCreationDate() +"\n");
        string.append("-ID do usuario: " +account.getAccId() +"\n");
        string.append("-Saldo: " +account.getBalance() +"\n");
        string.append("-Banco associado: " +account.getAccBank().getBankName() +"\n");

        return string.toString();
    }

    //Account Operations
    //------------------------------------------------------
    //Validate Operations Method
    public boolean validateOperations(Account p_account,String p_amount){
        //tratamento de erros caso os parametros forem passados a null
        if(p_account == null || p_amount == null){
            System.out.println("Erro: parametro invalido passado!\n");
            return false;
        }

        if(!p_account.getStatus()){ //verifica se a conta se encontra ativa
            System.out.println("Erro: a conta se encontra inativa!\n");
            return false;
        }

        BigDecimal amount = new BigDecimal(p_amount);
        if(!(this.balance.compareTo(amount) >= 0) || !(amount.compareTo(BigDecimal.ZERO) > 0)){ //compara se o valor a ser levantado for menor ou igual ao saldo disponivel e maior que 0
            System.out.println("Erro: saldo insuficiente para operacao!\n");
            return false;
        }
        return true;
    }

    //Money Withdrawal Operation Method
    public void moneyWithdrawal(Account p_account,String p_amount){ //operacao de levantamento
        if(validateOperations(p_account,p_amount)){
            BigDecimal amount = new BigDecimal(p_amount);

            this.balance = this.balance.subtract(amount);

            System.out.println("-Foi levantado a quantia de: " +amount +" CVE");
            System.out.println("-Saldo atual: " +this.balance +" CVE\n");
        }else{
            throw new InvalidOperationException("Erro: a operacao nao foi validada!\n");
        }
    }
    //------------------------------------------------------
    //Money Deposit Operation Method
    public void moneyDeposit(Account p_account,String p_amount){ //operacao de deposito
        if(validateOperations(p_account,p_amount)){
            BigDecimal amount = new BigDecimal(p_amount);

            this.balance = this.balance.add(amount);

            System.out.println("-Foi depositado uma quantia de: " +amount +" CVE");
            System.out.println("-Saldo atual: " +this.balance +" CVE\n");
        }else{
            throw new InvalidOperationException("Erro: a operacao nao foi validada!\n");
        }
    }
    //------------------------------------------------------
}
