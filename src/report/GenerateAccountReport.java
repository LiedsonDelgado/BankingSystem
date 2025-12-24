//Classe para representar Generate que ira gerar relatorios de contas bancarias(.json)
package report;
import model.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class GenerateAccountReport{
    public void generateAccountReport(Account p_account){ //recebe o conteudo das variaveis de instancia do objeto conta
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String fileName = "account_report_";
            String filePath = "E:/Personal Projects/Java/BankingSystem/files/reports/account/";
            String fileExtension = ".json";
            String newFileName = (filePath+fileName+p_account.getAccId()+fileExtension);

            mapper.writeValue(new java.io.File(newFileName),p_account);

            System.out.println("Relatorio de conta gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro: nao foi possivel criar o relatorio da conta!");
            error.printStackTrace(); //caso ocorra algum erro ele exibe o erro exato para depuracao
        }
    }
}