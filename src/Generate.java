//Classe para representar a interface de Generate que ira gerar ficheiros
public interface Generate{
    //Methods
    public void generate(String p_filename,String p_filepath,String p_extension,Account p_account); //recebe nome do ficheiro relatorio e objeto relatorio(conteudo), gera e salva o ficheiro que foi geradoz
}