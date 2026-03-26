//Classe para representar um ATM e suas funcoes/propriedades
//Em desenvolvimento...
package model;
import exceptions.InvalidOperationException;

import enums.ATMStatus;
import enums.Languages;

import java.math.BigDecimal;

public class ATM{
    public String localization;
    public Bank bank;
    public ATMStatus status; //estados do atm(ativo,inativo ou em manutencao)
    public Languages language; //idioma configurado
    public BigDecimal balance; //saldo disponivel no ATM
    public BigDecimal maxWithdrawal;
    public BigDecimal[] schedulesTypes; //cedulas de dinheiro disponivel
    public int ATMId;
    public static int nextATMId = 1; //permite criar um id unico para cada ATM por default o primeiro obj ATM contem id=1

    public ATM(String p_localization,Bank p_bank,ATMStatus p_status,Languages p_language,String p_balance){
        this.localization = p_localization;
        this.bank = p_bank;
        this.status = p_status;
        this.language = p_language;
        this.balance = new BigDecimal(p_balance);
        this.maxWithdrawal = new BigDecimal("30000.00");
        this.schedulesTypes = new BigDecimal[]{
                new BigDecimal("1000.00"),
                new BigDecimal("2000.00"),
                new BigDecimal("5000.00"),
                new BigDecimal("10000.00")
        };
        this.ATMId = nextATMId++;
    }

    //Methods
    //Getters
    public String getLocalization(){
        return localization;
    }

    public Bank getBank(){
        return bank;
    }

    public ATMStatus getStatus(){
        return status;
    }

    public Languages getLanguage(){
        return language;
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public BigDecimal getMaxWithdrawal(){
        return maxWithdrawal;
    }

    public BigDecimal[] getSchedulesTypes(){
        return schedulesTypes;
    }

    public int getATMId(){
        return ATMId;
    }

    //Setters
    public void setLocalization(String p_localization){
        this.localization = p_localization;
    }

    public void setBank(Bank p_bank){
        this.bank = p_bank;
    }

    public void setStatus(ATMStatus p_status){
        this.status = p_status;
    }

    public void setLanguage(Languages p_languages){
        this.language = p_languages;
    }

    public void setBalance(BigDecimal p_balance){
        this.balance = p_balance;
    }

    public String showATMInfo(ATM atm){
        StringBuilder string = new StringBuilder();

        string.append("-Localizacao: ");
        string.append("-");
        string.append("-");
        string.append("-");
        string.append("-");
        string.append("-");
        string.append("-Saldo:");
        string.append("-Banco associado: ");

        return string.toString();
    }

    //Specific Methods
    public boolean validateOperation(Account p_account,String p_amount){
        if(p_account == null || p_amount == null){
            System.out.println("Erro: parametro invalido passado!\n");
            return false;
        }

        if(!p_account.getStatus()){ //
            System.out.println("Erro: a conta se encontra inativa!\n");
            return false;
        }

        BigDecimal amount = new BigDecimal(p_amount);

        if(!(amount.compareTo(maxWithdrawal)>=0)|| !(this.balance.compareTo(amount)>=0) || !(this.balance.compareTo(BigDecimal.ZERO)>0)){ //compara se o valor a ser levantado for menor ou igual ao saldo disponivel e maior que 0
            System.out.println("Erro: a operacao nao foi validada!\n");
            return false;
        }

        return true;
    }

    public void moneyWithdrawal(Account p_account,String p_amount){
        if(validateOperation(p_account,p_amount)){
            BigDecimal amount = new BigDecimal(p_amount);

            this.balance = this.balance.subtract(amount);
            p_account.moneyWithdrawal(p_account,p_amount);
        }else{
            throw new InvalidOperationException("Erro: a operacao nao foi validada!\n");
        }
    }

    public void moneyDeposit(Account p_account,String p_amount){
        if(validateOperation(p_account,p_amount)){
            BigDecimal amount = new BigDecimal(p_amount);

            this.balance = this.balance.add(amount);
            p_account.moneyDeposit(p_account,p_amount);
        }else{
            throw new InvalidOperationException("Erro: a operacao nao foi validada!\n");
        }
    }

    public void moneyTransfer(Account p_account1,Account p_account2,String p_amount){ //transferencia de dinheiro entre da conta 1 para a conta 2
        if(validateOperation(p_account1,p_amount) && (p_account2 != null)){
            BigDecimal amount = new BigDecimal(p_amount);

            p_account1.moneyWithdrawal(p_account1,p_amount);
            p_account2.moneyDeposit(p_account2,p_amount);

            System.out.println("-Foi transferido uma quantia de: " +amount +" CVE\n");
        }else{
            throw new InvalidOperationException("Erro: a operacao nao foi validada!\n");
        }
    }

    public void printReceipt(Account p_account,String p_amount){
        if(validateOperation(p_account,p_amount)){
            //(em desenvolvimento)
        }else{
            throw new InvalidOperationException("Erro: a operacao nao foi validada!\n");
        }
    }
}
