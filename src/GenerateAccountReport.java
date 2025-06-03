//Classe para representar Generate que ira gerar ficheiros em concreto
import java.io.*;
import java.lang.*;

public class GenerateAccountReport{


    public void generateAccountReport(String p_filename,String p_filepath,String p_extension,Account p_account){//recebe o conteudo do report e concatena com a sua extensao
        AccountReport p_report = new AccountReport(p_extension,p_account); //objeto que representa um relatorio
        p_report.setContent(p_account);

        String newFileName = (p_filepath+p_filename+p_account.getAccId()+p_report.getExtension());
        String fileContent = (p_report.getContent());

        try(FileWriter generatedReport = new FileWriter(newFileName)){
            generatedReport.write(fileContent);
            System.out.println("Relatorio gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro nao foi possivel criar relatorio!");
        }
    }
}