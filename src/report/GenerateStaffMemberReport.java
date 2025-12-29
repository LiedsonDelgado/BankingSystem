//Classe para representar Generate que ira gerar relatorios dos nembros de equipe(.json)
package report;
import model.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class GenerateStaffMemberReport{
    public void generateStaffMemberReport(StaffMember p_staffMember){ //recebe o conteudo das variaveis de instancia do objeto ...
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String fileName = "staff_member_report_";
            String filePath = "E:/Personal Projects/Java/BankingSystem/files/reports/staff_member/";
            String fileExtension = ".json";
            String newFileName = (filePath+fileName+p_staffMember.getIdStaffMember()+fileExtension);

            mapper.writeValue(new java.io.File(newFileName),p_staffMember);

            System.out.println("Relatorio gerado com sucesso!");
        }catch(IOException ioe){
            System.out.println("Erro: nao foi possivel criar o relatorio do membro de equipe!");
            ioe.printStackTrace();
        }
    }
}
