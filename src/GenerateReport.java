//Classe para representar Generate que ira gerar ficheiros em concreto
import java.io.*;
import java.lang.*;

public class GenerateReport implements Generate{

    @Override
    public void generate(Account p_account,String p_filename,String p_filepath,Report p_report){//recebe o conteudo do report e concatena com a sua extensao
        String newFileName = (p_filepath +p_filename +" " +p_account.getAccId() +p_report.getExtension());
        String fileContent = (p_report.getContent());

        try(FileWriter generatedReport = new FileWriter(newFileName)){
            generatedReport.write(fileContent);
            System.out.println("Relatorio gerado com sucesso!");
        }catch(IOException error){
            System.out.println("Erro nao foi possivel criar relatorio!");
        }
    }

    public void deleteGeneratedFile(String p_filename,String p_filepath){

    }

    public void searchFile(String p_filename,String p_filepath){

    }
}