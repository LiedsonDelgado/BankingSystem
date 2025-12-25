//Classe para representar Generate que ira gerar relatorios de cartoes de credito(.json)
package report;
import model.*;
import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class GenerateCardReport {
    public void generateCreditCardReport(CreditCard p_card){ //recebe o conteudo das variaveis de instancia do objeto cartao
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String fileName = "card_report_";
            String filePath = "E:/Personal Projects/Java/BankingSystem/files/reports/card/";
            String fileExtension = ".json";

            String newFileName = (filePath+fileName+p_card.getCardId()+fileExtension);
            mapper.writeValue(new java.io.File(newFileName),p_card);

            System.out.println("Relatorio de cartao gerado com sucesso!");
        }catch(IOException ioe){
            System.out.println("Erro: nao foi possivel gerar o relatorio do cartao!");
            ioe.printStackTrace(); //caso ocorra algum erro ele exibe o erro exato para depuracao
        }
    }
}
