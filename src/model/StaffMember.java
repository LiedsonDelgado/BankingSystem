//Classe que representa os Membros do Equipe do Banco
package model;
import enums.ExperienceLevel;

public class StaffMember extends Employee{
    private int id;
    private static int nextStaffMemberId = 1;

    //StaffMember Constructor
    public StaffMember(){
    }

    public StaffMember(String p_name,String p_phoneNumber,String p_salary,ExperienceLevel p_experienceLevel,Bank p_bank){
        super(p_name,p_phoneNumber,p_salary,p_experienceLevel,p_bank);
        this.id = nextStaffMemberId++;
    }

    //Methods
    //Getters
    public int getIdStaffMember(){
        return id;
    }

    public String showStaffMemberInfo(StaffMember staffMember){
        StringBuilder string = new StringBuilder();
        string.append("-Nome: " +staffMember.getName() +"\n");
        string.append("-Email: " +staffMember.getEmail() +"\n");
        string.append("-Telefone: " +staffMember.getPhoneNumber() +"\n");
        string.append("-Salario: " +staffMember.getSalary() +"\n");
        string.append("-Banco associado: " +staffMember.getEmployeeBank() +"\n");
        string.append("-ID membro de equipe: " +staffMember.getIdStaffMember() +"\n");
        string.append("-Nivel de experiencia: " +staffMember.getExperienceLevel() +"\n");

        return string.toString();
    }
}
