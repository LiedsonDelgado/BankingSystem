//Classe para representar um relatorio que podera ser gerado ex.: ".pdf",".doc" ou ".txt"
import java.time.*;

public class Report{
    String extension; //extensao do ficheiro
    String content; //conteudo contido no relatorio
    LocalTime actualTime = LocalTime.now();

    //Report Constructor
    public Report(String p_extension,Account p_account){
        this.extension = p_extension;
        this.content = ("--Relatorio de Conta--\n\n" +p_account.showAccountInfo(p_account) +"\n-Gerado as: " +actualTime);
    }

    //Methods
    //Getters
    String getExtension(){
        return extension;
    }

    String getContent(){
        return content;
    }

    //Setters
    @SuppressWarnings("unused") //oculta o warning de que o metodo nao esta sendo utilizado
    void setExtension(String p_extension){
        this.extension = p_extension;
    }

    @SuppressWarnings("unused")//oculta o warning de que o metodo nao esta sendo utilizado
    void setContent(Account p_account){
        this.content = ("--Relatorio de Conta--\n\n" +p_account.showAccountInfo(p_account) +"\n-Gerado as: " +actualTime );
    }
}