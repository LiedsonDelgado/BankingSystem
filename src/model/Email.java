package model;

public class Email{
    public String localPart; //parte antes do @ no email
    public String domain; //dominio do email(gmail.com,hotmail.com,bcv.com,etc)

    public Email(Object p_user,String p_localPart){
        if(p_user == null || p_localPart == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }

        //(,!*<>#@;~")caracteres invalidos que a parte local nao pode conter
        for(int i=0;i<p_localPart.length();i++){
            if(p_localPart.charAt(i) == ',' || p_localPart.charAt(i) == '!' || p_localPart.charAt(i) == '*' || p_localPart.charAt(i) == '<' || p_localPart.charAt(i) == '>' || p_localPart.charAt(i) == '@' || p_localPart.charAt(i) == ';' || p_localPart.charAt(i) == '~'){
                throw new IllegalArgumentException("Erro: o email nao pode conter caracteres especiais!\n");
            }
        }

        if(p_localPart.length() == 64){
            throw new IllegalArgumentException("Erro: o email nao pode ter mais que 64 caracteres!");
        }

        this.localPart = p_localPart.toLowerCase().replaceAll(" ",""); //converte a parte local todo para caracteres minusculos e remove todos os espacos em branco
    }

    //Methods
    //Getters
    public String getLocalPart(){
        return localPart;
    }

    public String getDomain(){
        return domain;
    }

    //Setters
    public void setLocalPart(String p_localPart){
        this.localPart = p_localPart;
    }

    public void setDomain(String p_domain){
        this.domain = p_domain;
    }

    //Own email methods
    public String generateDomain(Object p_user){
        if(p_user instanceof Manager || p_user instanceof StaffMember || p_user instanceof Worker){
            String newBankName = ((Employee)p_user).getEmployeeBank().getBankName().toLowerCase();
            return "@"+newBankName.charAt(0)+newBankName.charAt(1)+newBankName.charAt(2)+".com";
        }
        if(p_user instanceof Client){
            return "@gmail.com";
        }
        throw new IllegalArgumentException("Erro: insira um usuario valido!\n");
    }

    public String createCompleteEmail(String p_localPart,String p_domain){
        return p_localPart+p_domain;
    }

    public boolean validateEmail(String p_email){
        return (p_email.contains(localPart) && p_email.contains(domain));
    }

    /*
    public boolean isValid(String p_email){
        if(){
            return true;
        }

        return false;
    }
    */
}
