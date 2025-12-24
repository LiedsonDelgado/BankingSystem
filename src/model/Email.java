package model;

public class Email{
    public String localPart; //parte antes do @ no email
    public String domain; //dominio do email(gmail.com,hotmail.com,bcv.com,etc)

    public Email(String p_localPart){
        if(p_localPart == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        this.localPart = p_localPart.toLowerCase().replaceAll(" ",""); //converte a parte local todo para caracteres minusculos e remove todos os espacos em branco
        this.domain = null;
    }

    //Methods
    //Getters
    public String getLocalPart(){
        return localPart;
    }

    public String getDomain(){
        return domain;
    }

    public String getCompleteEmail(){
        if(this.domain == null){
            throw new IllegalArgumentException("Erro: o dominio e invalido");
        }
        return this.localPart+this.domain;
    }

    //Setters
    public void setLocalPart(String p_localPart){
        this.localPart = p_localPart;
    }

    //Own email methods
    public void generateDomain(Object p_user){
        if(p_user instanceof Manager || p_user instanceof StaffMember || p_user instanceof Worker){
            String newBankName = ((Employee)p_user).getEmployeeBank().getBankName().toLowerCase();
            this.domain = "@"+newBankName.charAt(0)+newBankName.charAt(1)+newBankName.charAt(2)+".cv";
        }
        if(p_user instanceof Client){
           this.domain = "@gmail.com";
        }

        if(!(p_user instanceof Manager || p_user instanceof StaffMember || p_user instanceof Worker || p_user instanceof Client)){
            throw new IllegalArgumentException("Erro: insira um usuario valido!\n");
        }
    }

    public boolean validateEmail(String p_email){
        if(p_email == null){
            return false;
        }

        if(p_email.length() >= 73){ //total de 73 caracteres, 64 caracteres para a parte local e 9 para o dominio
            return false;
        }

        if(!p_email.contains(localPart) && p_email.contains(domain)){ //verifica se o email esta completo contendo a parte local e o dominio
            return false;
        }

        for(int i=0;i<p_email.length();i++){ //(,!*<>#;~")caracteres invalidos que a parte local nao pode conter
            if(p_email.charAt(i) == ',' || p_email.charAt(i) == '!' || p_email.charAt(i) == '*' || p_email.charAt(i) == '<' || p_email.charAt(i) == '>' || p_email.charAt(i) == ';' || p_email.charAt(i) == '~'){
                return false;
            }
        }
        return true;
    }

    public boolean equalsToEmail(Email p_email){
        if(p_email == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        return this.getCompleteEmail().equals(p_email.getCompleteEmail());
    }
}
