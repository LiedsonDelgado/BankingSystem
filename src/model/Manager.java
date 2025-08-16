//Classe que representa o Gerente que e o unico que pode adicionar e remover contas,cartoes e clientes, que tambem ele que gera relatorios
package model;
import enums.AcessLevel;
import java.util.*;

public class Manager extends Employee{
    public String position; //cargo do gerente
    public String specialization;
    public AcessLevel accessLevel; //nivel senioridade
    public int idManager;
    public int nextManagerId = 1;
    public ArrayList<Client> listOfClients; //clientes sobre sua responsabilidade
    public ArrayList<Account> listOfAccounts; //clientes sobre sua responsabilidade

    //Manager Constructor
    public Manager(){
    }

    public Manager(String p_name,String p_position,String p_email,String p_phoneNumber,String p_specialization,AcessLevel p_accessLevel,Bank p_bank,ArrayList<Client> p_lisOfClient,ArrayList<Account> p_listOfAccounts){
        super(p_name,p_email,p_phoneNumber,p_bank);
        this.position = p_position;
        this.specialization = p_specialization;
        this.accessLevel = p_accessLevel;
        this.idManager = nextManagerId++;
        this.listOfClients = p_lisOfClient;
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

    public AcessLevel getManagerAccessLevel(){
        return accessLevel;
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

    public void setManagerAcessLevel(AcessLevel p_acessLevel){
        this.accessLevel = p_acessLevel;
    }

    public void setListOfClients(ArrayList p_newClientList){
        this.listOfClients = p_newClientList;
    }
    
    public void setListOfAccounts(ArrayList p_newAccountList){
        this.listOfAccounts = p_newAccountList;
    }

    public String showManagerInfo(Manager manager){
        StringBuilder string = new StringBuilder();

        string.append("-Nome: " +manager.getName() +"\n");
        string.append("-Email: " +manager.getEmail() +"\n");
        string.append("-Telefone: " +manager.getPhoneNumber() +"\n");
        string.append("-Banco associado: " +manager.getEmployeeBank().getBankName() +"\n");
        string.append("-ID Gerente: " +manager.getIdManager() +"\n");
        string.append("-Cargo do Gerente: " +manager.getManagerPosition() +"\n");
        string.append("-Especializacao: " +manager.getManagerSpecialization() +"\n");
        string.append("-Nivel de Acesso/Senioridade: " +manager.getManagerAccessLevel() +"\n");
        string.append("-Numero de Contas que administra: " +manager.getNumsOfAccountsOnList() +"\n");
        string.append("-Numero de Clientes que administra: " +manager.getNumsOfClientsOnList() +"\n");

        return string.toString();
    }
}