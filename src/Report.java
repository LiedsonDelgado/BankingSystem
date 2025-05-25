//Classe para representar um relatorio que podera ser gerado ex.: ".pdf",".doc" ou ".txt"
public class Report{
    String extension; //extensao do ficheiro
    StringBuilder content; //conteudo contido no relatorio

    //Report Constructor
    public Report(String p_extension,Account p_account){
        this.extension = p_extension;
        this.content = p_account.showAccountInfo(p_account);
    }

    //Methods
    //Getters
    String getExtension(){
        return extension;
    }

    StringBuilder getContent(){
        return content;
    }

    //Setters
    @SuppressWarnings("unused") //oculta o warning de que o metodo nao esta sendo utilizado
    void setExtension(String p_extension){
        this.extension = p_extension;
    }

    @SuppressWarnings("unused")//oculta o warning de que o metodo nao esta sendo utilizado
    void setContent(Account p_account){
        this.content = p_account.showAccountInfo(p_account);
    }
}