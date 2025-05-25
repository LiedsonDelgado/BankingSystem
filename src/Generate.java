//Classe para representar a interface de Generate que ira gerar ficheiros
public interface Generate{
    //Methods
    public void generate(String p_filename,String p_filepath,Report p_report); //recebe nome do ficheiro relatorio e objeto relatorio(conteudo), gera e salva o ficheiro que foi gerado
}