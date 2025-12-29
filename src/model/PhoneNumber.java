//Classe que representa um Numero de Telefone e garante a sua validacao e seguranca
package model;
import exceptions.*;

public class PhoneNumber{
    protected String phoneNumber;

    //PhoneNumber Constructor
    public PhoneNumber(String p_phoneNumber){
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
        if(p_phoneNumber == null || p_phoneNumber.isEmpty()){
            throw new InvalidPhoneNumberException("Erro: numero de telefone invalido!\n");
        }

        if(!p_phoneNumber.contains("+238")){
            throw new InvalidPhoneNumberException("Erro: numero de telefone e invalido!\n");
        }

        String filteredPhoneNumber = p_phoneNumber.replace("+","").replaceAll("238 ",""); //filtra o numero removendo o +238 de "+238 XXXXXXX" para "XXXXXXX"

        if(filteredPhoneNumber.length() != 7){ // tamanho do "+238" mais o tamanho do numero que contem 7 digitos
            throw new InvalidPhoneNumberException("Erro: numero de telefone e invalido!\n");
        }
    }

    public boolean equalsToPhoneNumber(String p_phoneNumber){
        if(p_phoneNumber == null || p_phoneNumber.isEmpty()){
            throw new InvalidPhoneNumberException("Erro: numero de telefone e invalido!\n");
        }
        return phoneNumber.equals(p_phoneNumber);
    }
}
