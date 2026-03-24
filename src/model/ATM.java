//Classe para representar um ATM e suas funcoes/propriedades
package model;

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

    public ATM(String p_localization,Bank p_bank,ATMStatus p_status,Languages p_language,BigDecimal p_balance){
        this.localization = p_localization;
        this.bank = p_bank;
        this.status = p_status;
        this.language = p_language;
        this.balance = p_balance;
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

    //Specific Methods
    //Deposit(...)
    //Withdrawal(...)
    //etc(...)
}
