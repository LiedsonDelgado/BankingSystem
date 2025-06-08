//Classe para representar Generate que ira gerar relatorios(.json) em concreto
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.*;

public class GenerateAccountReport{
    public void generateAccountReport(String p_filename,String p_filepath,Account p_account){//recebe o conteudo do report e concatena com a sua extensao
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String newFileName = (p_filepath+p_filename+p_account.getAccId()+".json");
            mapper.writeValue(new java.io.File(newFileName),p_account);

            System.out.println("Relatorio gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro: nao foi possivel criar relatorio!");
            error.printStackTrace(); //caso ocorra um erro ele exibe o erro exato para depuracao
        }
    }
}