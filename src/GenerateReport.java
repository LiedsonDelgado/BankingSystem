//Classe para representar Generate que ira gerar ficheiros em concreto
public class GenerateReport implements Generate{

    @Override
    public void generate(String p_filename,String p_filepath,Report p_report){//recebe o conteudo do report e concatena com a sua extensao
        System.out.println(p_filename +p_report.getExtension() +"\n" +p_report.getContent());
    }
}