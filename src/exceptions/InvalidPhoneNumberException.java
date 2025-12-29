//Classe que cria uma Exception personalizada para tratar erros da classe PhoneNumber
package exceptions;

public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String message){
        super(message);
    }
}
