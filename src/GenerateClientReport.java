//Classe para representar Generate que ira gerar relatorios dos clientes do banco(.json)
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.*;
import java.io.*;

public class GenerateClientReport{
    public void generateClientReport(Client p_client){ //recebe o conteudo das variaveis de instancia do objeto cliente
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String p_filename = "client_report_";
            String p_filepath = "E:/!UTA(Pratica)/POO/InteliJ_Projects/BankingSystem/files/reports/clients/";
            String p_fileextension = ".json";

            String newFileName = (p_filepath+p_filename+p_client.getClientId()+p_fileextension);
            mapper.writeValue(new java.io.File(newFileName),p_client);

            System.out.println("Relatorio de cliente gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro: nao foi possivel criar o relatorio do cliente!");
            error.printStackTrace(); //caso ocorra algum erro ele exibe o erro exato para depuracao
        }
    }
}
