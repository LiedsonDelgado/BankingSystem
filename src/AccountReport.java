//Classe para representar um relatorio que podera ser gerado ex.: ".pdf",".doc" ou ".txt"
import java.time.*;

public class AccountReport{
    protected String extension; //extensao do ficheiro
    protected String content; //conteudo contido no relatorio
    protected LocalDate creationDate = LocalDate.now();
    protected LocalTime actualTime = LocalTime.now();
    protected int reportId;
    private int reportNextId = 1;

    //Report Constructor
    public AccountReport(String p_extension,Account p_account){
        this.extension = p_extension;
        this.content = ("--Relatorio de Conta--\n\n" +p_account.showAccountInfo(p_account) +"\n-Data e Hora gerado: " +creationDate +" as " +actualTime);
        this.reportId = reportNextId;
    }

    //Methods
    //Getters
    public String getExtension(){
        return extension;
    }

    public String getContent(){
        return content;
    }

    public int getReportId(){
        return reportId = reportNextId++;
    }

    //Setters
    @SuppressWarnings("unused") //oculta o warning de que o metodo nao esta sendo utilizado
    public void setExtension(String p_extension){
        this.extension = p_extension;
    }

    @SuppressWarnings("unused")//oculta o warning de que o metodo nao esta sendo utilizado
    public void setContent(Account p_account){
        this.content = ("--Relatorio de Conta--\n\n" +p_account.showAccountInfo(p_account) +"\n-Data e Hora gerado: " +creationDate +" as " +actualTime);
    }
}