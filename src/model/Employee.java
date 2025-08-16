package model;

public class Employee{
    public String name;
    public String email; //**dps criar uma classe Email com validacao do email,etc
    public String phoneNumber;
    public Bank bank;

    public Employee() {

    }

    public Employee(String p_name,String p_email,String p_phoneNumber,Bank p_bank){
        this.name = p_name;
        this.email = p_email;
        this.phoneNumber = p_phoneNumber;
        this.bank = p_bank;
    }

    //Methods
    //Getters
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public Bank getEmployeeBank(){
        return bank;
    }

    //Setters
    public void setName(String p_name){
        this.name = p_name;
    }

    public void setEmail(String p_email){
        this.email = p_email;
    }

    public void setPhoneNumber(String p_phoneNumber){
        this.phoneNumber = p_phoneNumber;
    }

    public void setBank(Bank p_bank){
        this.bank = p_bank;
    }
}
