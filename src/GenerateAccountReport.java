//Classe para representar Generate que ira gerar ficheiros em concreto
import java.io.*;
import java.lang.*;

public class GenerateAccountReport implements Generate{

    @Override
    public void generateAccountReport(String p_filename,String p_filepath,String p_extension,Account p_account){//recebe o conteudo do report e concatena com a sua extensao
        AccountReport r = new AccountReport(p_extension,p_account); //objeto que que representa os relatorios
        r.setContent(p_account);

        String newFileName = (p_filepath +p_filename +p_account.getAccId() +r.getExtension());
        String fileContent = (r.getContent());

        try(FileWriter generatedReport = new FileWriter(newFileName)){
            generatedReport.write(fileContent);
            System.out.println("Relatorio gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro nao foi possivel criar relatorio!");
        }
    }
}