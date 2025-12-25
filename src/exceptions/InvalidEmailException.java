//Classe que cria uma Exception personalizada para tratar erros da classe Email
package exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message){
        super(message);
    }
}
