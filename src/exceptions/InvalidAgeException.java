//Classe que cria uma Exception personalizada para tratar erros da relacionados a idades
package exceptions;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message){
        super(message);
    }
}
