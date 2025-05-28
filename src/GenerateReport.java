//Classe para representar Generate que ira gerar ficheiros em concreto
import java.io.*;
import java.lang.*;

public class GenerateReport implements Generate{

    @Override
    public void generate(String p_filename,String p_filepath,Report p_report){//recebe o conteudo do report e concatena com a sua extensao
        String newFileName = (p_filepath+p_filename+p_report.getExtension());
        String fileContent = (p_report.getContent());

        try(FileWriter report = new FileWriter(newFileName)){
            report.write(fileContent);
            System.out.println("Relatorio Criado!");
        }catch(IOException error){
            System.out.println("Erro ao criar ficheiro!");
        }
    }

    public void deleteGeneratedFile(String p_filename,String p_filepath){

    }

    public void searchFile(String p_filename,String p_filepath){

    }
}