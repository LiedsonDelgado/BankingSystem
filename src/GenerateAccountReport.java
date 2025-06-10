//Classe para representar Generate que ira gerar relatorios de contas bancarias(.json)
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.*;

public class GenerateAccountReport{
    public void generateAccountReport(Account p_account){//recebe o conteudo do report e concatena com a sua extensao
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String p_filename = "relatorio_conta_";
            String p_filepath = "E:/!UTA(Pratica)/POO/InteliJ_Projects/BankingSystem/files/relatorios/contas/";
            String p_fileextension = ".json";

            String newFileName = (p_filepath+p_filename+p_account.getAccId()+p_fileextension);
            mapper.writeValue(new java.io.File(newFileName),p_account);

            System.out.println("Relatorio de conta gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro: nao foi possivel criar relatorio da conta!");
            error.printStackTrace(); //caso ocorra algum erro ele exibe o erro exato para depuracao
        }
    }
}