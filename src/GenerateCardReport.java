//Classe para representar Generate que ira gerar relatorios de cartoes de credito(.json)
import java.io.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

 class GenerateCardReport {
    public void generateCreditCardReport(CreditCard p_card){ //recebe o conteudo das variaveis de instancia do objeto cartao
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String p_filename = "card_report_";
            String p_filepath = "E:/!UTA(Pratica)/POO/InteliJ_Projects/BankingSystem/files/relatorios/cards/";
            String p_fileextension = ".json";

            String newFileName = (p_filepath+p_filename+p_card.getCardId()+p_fileextension);
            mapper.writeValue(new java.io.File(newFileName),p_card);

            System.out.println("Relatorio de cartao gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro: nao foi possivel gerar o relatorio do cartao!");
            error.printStackTrace(); //caso ocorra algum erro ele exibe o erro exato para depuracao
        }
    }
}
