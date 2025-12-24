//Classe que representa um Numero de Telefone e garante a sua validacao e seguranca
package model;
import exceptions.*;

public class PhoneNumber {
    public String phoneNumber;

    //PhoneNumber Constructor
    PhoneNumber(String p_phoneNumber){
        this.phoneNumber = p_phoneNumber.replaceAll(" ",""); // remove todos espacos em branco;
    }

    //Methods
    //Getters
    private String getPhoneNumber(){
        return phoneNumber;
    }

    //Setters
    private void setPhoneNumber(String p_phoneNumber){
        this.phoneNumber = p_phoneNumber;
    }

    //Own phone number methods
    public void validatePhoneNumber(String p_phoneNumber){
        if(!(p_phoneNumber.length() > 11)){ // tamanho do "+238" mais o tamanho do numero que contem 7 digitos
            throw new InvalidPhoneNumberException("Erro: numero de telefone e invalido!\n");
        }

        if(!p_phoneNumber.contains("+238")){
            throw new InvalidPhoneNumberException("Erro: numero de telefone e invalido!\n");
        }
    }
}
