//Classe para representar Generate que ira gerar relatorios do gerente bancario(.json)
package report;
import model.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class GenerateMangerReport {
    public void generateManagerReport(Manager p_manager) { //recebe o conteudo das variaveis de instancia do objeto conta
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String p_filename = "manager_report_";
            String p_filepath = "E:/Personal Projects/Java/BankingSystem/files/reports/manager/";
            String p_fileextension = ".json";

            String newFileName = (p_filepath+p_filename+p_manager.getIdManager()+p_fileextension);
            mapper.writeValue(new java.io.File(newFileName),p_manager);

            System.out.println("Relatorio do gerente gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro: nao foi possivel gerar o relatorio do gerente!");
            error.printStackTrace(); //caso ocorra algum erro ele exibe o erro exato para depuracao
        }
    }
}
