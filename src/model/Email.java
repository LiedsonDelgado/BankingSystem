//Classe que representa um Email e garante a sua validacao e seguranca
package model;
import exceptions.*;

public class Email{
    public String email;

    public Email(String p_email){
        if(p_email == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        this.email = p_email.replaceAll(" ","").toLowerCase(); //remove todos os espacos em branco e converte tudo para minusculo
    }

    //Methods
    //Getters
    private String getEmail(){
        return email;
    }

    //Setters
    private void setEmail(String p_email){
        this.email = p_email;
    }

    //Own email methods
    public void validateEmail(String p_email){
        if(p_email == null){
            throw new InvalidEmailException("Erro: o email e invalido!\n");
        }

        if(p_email.length() > 73){ //total de 73 caracteres, 64 caracteres para a parte local e 9 para o dominio
            throw new InvalidEmailException("Erro: o email e invalido!\n");
        }

        if(!p_email.contains("@") || !p_email.contains(".")){ //verifica se o email esta completo contendo a parte dominio(ex:@gmail.com)
            throw new InvalidEmailException("Erro: o email e invalido!\n");
        }

        for(int i=0;i<p_email.length();i++){ //(,!*<>#;~")caracteres invalidos que a parte local nao pode conter
            if(p_email.charAt(i) == ',' || p_email.charAt(i) == '!' || p_email.charAt(i) == '*' || p_email.charAt(i) == '<' || p_email.charAt(i) == '>' || p_email.charAt(i) == ';' || p_email.charAt(i) == '~'){
                throw new InvalidEmailException("Erro: o email e invalido!\n");
            }
        }
    }

    public boolean equalsToEmail(String p_email){
        if(p_email == null){
            throw new IllegalArgumentException("Erro: parametro invalido passado!\n");
        }
        return getEmail().equals(p_email);
    }
}
