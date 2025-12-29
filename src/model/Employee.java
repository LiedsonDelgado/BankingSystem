package model;
import enums.ExperienceLevel;
import java.math.*;
import java.time.*;

public class Employee{
    public String name;
    protected static String email;
    public String phoneNumber;
    public BigDecimal salary;
    public ExperienceLevel experienceLevel; //nivel experiencia do funcionario
    public Bank bank;

    //Employee Constructor
    public Employee() {

    }

    public Employee(String p_name,String p_email,String p_phoneNumber,String p_salary,ExperienceLevel p_experienceLevel,Bank p_bank){
        this.salary = new BigDecimal(p_salary);
        this.name = p_name;

        Email emailObj = new Email(p_email);
        emailObj.validateEmail(p_email);
        email = p_email;

        this.phoneNumber = p_phoneNumber;
        PhoneNumber phoneNumber = new PhoneNumber(p_phoneNumber);
        phoneNumber.validatePhoneNumber(p_phoneNumber);

        this.experienceLevel = p_experienceLevel;
        this.bank = p_bank;
    }

    //Methods
    //Getters
    public String getName(){
        return name;
    }

    protected String getEmail(){
        if(email == null){
            throw new IllegalArgumentException("Erro: o funcionario nao possui um email para retornar!\n");
        }
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public BigDecimal getSalary(){
        return salary;
    }

    public ExperienceLevel getExperienceLevel(){
        return experienceLevel;
    }

    public Bank getEmployeeBank(){
        return bank;
    }

    //Setters
    public void setName(String p_name){
        this.name = p_name;
    }

    public void setEmail(String p_email){
        email = p_email;
    }

    public void setPhoneNumber(String p_phoneNumber){
        this.phoneNumber = p_phoneNumber;
    }

    public void setBalance(BigDecimal p_salary){
        this.salary = p_salary;
    }

    public void setExperienceLevel(ExperienceLevel p_experienceLevel){
        this.experienceLevel = p_experienceLevel;
    }

    public void setBank(Bank p_bank){
        this.bank = p_bank;
    }
}
