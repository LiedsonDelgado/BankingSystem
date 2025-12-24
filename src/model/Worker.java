//Classe que representa os Operarios do Banco
package model;
import enums.ExperienceLevel;

public class Worker extends Employee{
    private int id;
    private static int nextWorkerID = 1;


    //Worker Constructor
    public Worker(){

    }

    public Worker(String p_name,String p_phoneNumber,String p_salary,ExperienceLevel p_experienceLevel,Bank p_bank){
        super(p_name,p_phoneNumber,p_salary,p_experienceLevel,p_bank);
        this.id = nextWorkerID++;
    }

    //Getters
    public int getWorkerId(){
        return id;
    }

    public String showWorkerInfo(Worker worker){
        StringBuilder string = new StringBuilder();

        string.append("-Nome: " +worker.getName() +"\n");
        string.append("-Email: " +worker.getEmail() +"\n");
        string.append("-Telefone: " +worker.getPhoneNumber() +"\n");
        string.append("-Salario: " +worker.getSalary() +"\n");
        string.append("-Banco associado: " +worker.getEmployeeBank() +"\n");
        string.append("-Id funcionario: " +worker.getWorkerId() +"\n");
        string.append("-Nivel de experiencia: " +worker.getExperienceLevel() +"\n");

        return string.toString();
    }
}
