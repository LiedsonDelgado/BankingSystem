//Classe que representa o Gerente que e o unico que pode adicionar e remover contas,cartoes e clientes, que tambem ele que gera relatorios
package model;
import enums.ExperienceLevel;
import java.time.*;
import java.util.*;

public class Manager extends Employee{
    public String position; //cargo do gerente
    public String specialization;
    private int idManager;
    private static int nextManagerId = 1;
    public LocalDateTime admissionDate;
    public ArrayList<Client> listOfClients; //clientes sobre sua responsabilidade
    public ArrayList<Account> listOfAccounts; //clientes sobre sua responsabilidade

    //Manager Constructor
    public Manager(){
    }

    public Manager(String p_name,String p_email,String p_position,String p_phoneNumber,String p_specialization,ExperienceLevel p_experienceLevel,String p_balance,Bank p_bank,ArrayList<Client> p_listOfClient,ArrayList<Account> p_listOfAccounts){
        super(p_name,p_email,p_phoneNumber,p_balance,p_experienceLevel,p_bank);
        this.position = p_position;
        this.specialization = p_specialization;
        this.idManager = nextManagerId++;
        this.admissionDate = null;
        this.listOfClients = p_listOfClient;
        this.listOfAccounts = p_listOfAccounts;
    }

    //Methods
    //Getters
    public String getManagerPosition(){
        return position;
    }

    public String getManagerSpecialization(){
        return specialization;
    }

    public int getIdManager(){
        return idManager;
    }

    public ArrayList getListOfClients(){
        return listOfClients;
    }

    public ArrayList getListOfAccounts(){
        return listOfAccounts;
    }

    public int getNumsOfClientsOnList(){
        return listOfClients.size();
    }

    public int getNumsOfAccountsOnList(){
        return listOfAccounts.size();
    }

    //Setters
    public void setManagerPosition(String p_position){
        this.position = p_position;
    }

    public void setManagerSpecialization(String p_specialization){
        this.specialization = p_specialization;
    }

    public void setListOfClients(ArrayList p_newClientList){
        this.listOfClients = p_newClientList;
    }
    
    public void setListOfAccounts(ArrayList p_newAccountList){
        this.listOfAccounts = p_newAccountList;
    }

    //Methods to manipulate Clients
    //------------------------------------------------------
    public void addClientToList(Client client,boolean confirmKey){
        if(client == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        if(confirmKey){
            listOfClients.add(client);
            System.out.println("O cliente foi adicionado com sucesso!");
        }else{
            System.out.println("O cliente nao foi adicionado!");
        }
    }

    public ArrayList<Client> removeClientFromList(Client client,boolean confirmKey){
        if(client == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        if(confirmKey){
            listOfClients.remove(client);
            System.out.println("O cliente foi removido com sucesso!");
        }else{
            System.out.println("O cliente nao foi removido!");
        }

        return listOfClients;
    }

    //Methods to manipulate Accounts
    //------------------------------------------------------
    public void addAccountToList(Account account,Boolean confirmKey){
        if(account == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        if(confirmKey){
            listOfAccounts.add(account);
            System.out.println("A conta foi adicionado com sucesso!");
        }else{
            System.out.println("A conta nao foi adicionado!");
        }
    }

    public ArrayList<Account> removeAccountFromList(Account account,Boolean confirmKey){
        if(account == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        if(confirmKey){
            listOfAccounts.remove(account);
            System.out.println("A conta foi removida com sucesso!");
        }else{
            System.out.println("A conta nao foi removida!");
        }

        return listOfAccounts;
    }

    public String showManagerInfo(Manager manager){
        StringBuilder string = new StringBuilder();

        string.append("-Nome: " +manager.getName() +"\n");
        string.append("-Email: " +manager.getEmail() +"\n");
        string.append("-Telefone: " +manager.getPhoneNumber() +"\n");
        string.append("-Salario: " +manager.getSalary() +"\n");
        string.append("-Banco associado: " +manager.getEmployeeBank().getBankName() +"\n");
        string.append("-ID Gerente: " +manager.getIdManager() +"\n");
        string.append("-Cargo do Gerente: " +manager.getManagerPosition() +"\n");
        string.append("-Especializacao: " +manager.getManagerSpecialization() +"\n");
        string.append("-Nivel de Experiencia: " +manager.getExperienceLevel() +"\n");
        string.append("-Numero de Contas que administra: " +manager.getNumsOfAccountsOnList() +"\n");
        string.append("-Numero de Clientes que administra: " +manager.getNumsOfClientsOnList() +"\n");

        return string.toString();
    }
}