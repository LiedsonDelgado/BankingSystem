public class Main {
    public static void main(String[] args) {
        //Area de Testes!!!
        //---------------------------------------------------------------------

        Account a1 = new Account("2000000.31","Liedson Delgado","xz89b7647");

        System.out.println(a1.showAccountInfo(a1));

        //---------------------------------------------------------------------
    }
}

/*Trechos abaixo serao importantes talvez no constructor e no setter de data de criacao

    1-Imports a serem feitos:
        -import java.time.LocalDate;
        -import java.time.format.DateTimeFormatter;
        -import java.util.Scanner;

    2-recebe a <varString> no formato dd-mm-aaaa*...
        -DateTimeFormatter dateFormated = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    3-...*converte para um objeto LocalDate
        -LocalDate date = LocalDate.parse(varString, dateFormated);
*/