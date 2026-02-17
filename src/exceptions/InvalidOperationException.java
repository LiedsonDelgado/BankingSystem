//Classe que cria uma Exception personalizada para tratar erros da classe Account
package exceptions;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message){
        super(message);
    }
}
