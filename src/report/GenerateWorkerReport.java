//Classe para representar Generate que ira gerar relatorios dos operario(.json)
package report;
import model.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class GenerateWorkerReport{
    public void generateWorkerReport(Worker p_worker){
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String fileName = "worker_report_";
            String filePath = "E:/Personal Projects/Java/BankingSystem/files/reports/worker/";
            String fileExtension = ".json";
            String newFileName = (fileName+filePath+fileExtension);

            mapper.writeValue(new java.io.File(newFileName),p_worker);

            System.out.println("Relatorio gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro: nao foi possivel gerar relatorio do operario!");
            error.printStackTrace(); //caso ocorra algum erro ele exibe o erro exato para depuracao
        }
    }
}
